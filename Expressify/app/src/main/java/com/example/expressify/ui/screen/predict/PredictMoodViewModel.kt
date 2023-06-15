package com.example.expressify.ui.screen.predict

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expressify.data.UserRepository
import com.example.expressify.data.remote.response.MoodPredictionResponse
import com.example.expressify.data.remote.response.RecommendationData
import com.example.expressify.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Locale

class PredictMoodViewModel(private val repository: UserRepository): ViewModel() {

    val isLoading: MutableState<Boolean> = mutableStateOf(true)
    val mood: MutableState<String> = mutableStateOf("")
    val isRequested: MutableState<Boolean> = mutableStateOf(false)
    val recommendationData: MutableState<RecommendationData?> = mutableStateOf(null)
    val isError: MutableState<Boolean> = mutableStateOf(false)

    private val FILENAME_FORMAT = "dd-MMM-yyyy"
    private val timeStamp: String = SimpleDateFormat(
        FILENAME_FORMAT,
        Locale.US
    ).format(System.currentTimeMillis())

    private var token: String = ""
    private var userId: String = ""

    init {
        getUserData()
    }

    fun getUserData() {
        viewModelScope.launch {
            repository.getUser().collect() {
                token = it.token
                userId = it.id
            }
        }
    }

    fun getRecommendation(uri: Uri, context: Context) {
        isLoading.value = true
        isRequested.value = true

        val image = getImage(uri, context)
        val requestImageFile = image.asRequestBody("image/jpeg".toMediaType())
        val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestImageFile
        )

        val client = ApiConfig.getApiService().getPrediction(
            "Bearer $token",
            imageMultipart,
            userId.toRequestBody("text/plain".toMediaType())
        )

        client.enqueue(object : Callback<MoodPredictionResponse> {
            override fun onFailure(call: Call<MoodPredictionResponse>, t: Throwable) {
                isLoading.value = false
                isError.value = true
            }

            override fun onResponse(
                call: Call<MoodPredictionResponse>,
                response: Response<MoodPredictionResponse>
            ) {
                isLoading.value = false
                 if (response.body() != null && response.body()?.status == true) {
                     mood.value = response.body()?.data?.createdData?.prediction ?: ""
                     recommendationData.value = response.body()?.data?.recommendationData
                 } else {
                     isError.value = true
                 }
            }
        })
    }

    private fun getImage(uri: Uri, context: Context): File {
        val contentResolver: ContentResolver = context.contentResolver
        val myFile = createCustomTempFile(context)

        val inputStream = contentResolver.openInputStream(uri) as InputStream
        val outputStream: OutputStream = FileOutputStream(myFile)
        val buf = ByteArray(1024)
        var len: Int
        while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
        outputStream.close()
        inputStream.close()

        return reduceFileImage(myFile)
    }

    private fun reduceFileImage(file: File): File {
        val bitmap = BitmapFactory.decodeFile(file.path)
        var compressQuality = 100
        var streamLength: Int

        do {
            val bmpStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, compressQuality, bmpStream)
            val bmpPicByteArray = bmpStream.toByteArray()
            streamLength = bmpPicByteArray.size
            compressQuality -= 5
        } while (streamLength > 1000000)
        bitmap.compress(Bitmap.CompressFormat.JPEG, compressQuality, FileOutputStream(file))
        return file
    }

    private fun createCustomTempFile(context: Context): File {
        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(timeStamp, ".jpg", storageDir)
    }
}