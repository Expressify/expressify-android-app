package com.example.expressify.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expressify.di.Injection
import com.example.expressify.ui.screen.jurnal.JurnalViewModel
import com.example.expressify.ui.screen.predict.PredictMoodViewModel
import com.example.expressify.ui.screen.register.RegisterViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(Injection.provideUserRepository(context), context) as T
            }
            modelClass.isAssignableFrom(JurnalViewModel::class.java) -> {
                JurnalViewModel(Injection.provideUserRepository(context)) as T
            }
            modelClass.isAssignableFrom(PredictMoodViewModel::class.java) -> {
                PredictMoodViewModel(Injection.provideUserRepository(context)) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(Injection.provideUserRepository(context)) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}