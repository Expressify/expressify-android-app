package com.example.expressify.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.expressify.R

data class Artikel(
    val id: Long,
    val image: String,
    val title: String,
    val date: String,
    val content: String,
    val fullContent: String
)

val dummyArtikel = listOf(
    Artikel(
        1,
        "https://blogimage.vantagefit.io/vfitimages/2021/06/feature-image-red.png",
        "The Importance of Prioritizing Emotional Well-being", "12 Mei 2023",
        "Kesehatan mental adalah aspek penting dalam kehidupan kita yang sering kali diabaikan. Dalam era yang semakin sibuk dan penuh tekanan ini, menjaga kesehatan mental menjadi sangat penting.",
        "Kesehatan mental adalah aspek penting dalam kehidupan kita yang sering kali diabaikan. Dalam era yang semakin sibuk dan penuh tekanan ini, menjaga kesehatan mental menjadi sangat penting. Beban pekerjaan yang tinggi, hubungan yang rumit, dan tuntutan sosial yang konstan dapat berkontribusi pada gangguan kesehatan mental seperti kecemasan dan depresi. Oleh karena itu, penting bagi setiap individu untuk mengenali pentingnya merawat kesehatan mental mereka dan melibatkan diri dalam kegiatan yang memperkuat kekuatan mental mereka seperti meditasi, olahraga, atau terapi. Meningkatkan kesadaran tentang kesehatan mental juga penting untuk mengurangi stigma yang masih melekat pada masalah kesehatan mental dan memastikan bahwa orang-orang merasa nyaman untuk mencari bantuan saat dibutuhkan.\n" +
                "\n" +
                "Perawatan kesehatan mental bukan hanya tanggung jawab individu, tetapi juga masyarakat secara keseluruhan. Penting bagi kita untuk menciptakan lingkungan yang mendukung dan inklusif, di mana orang-orang merasa didengar dan diterima tanpa takut dihakimi atau diucilkan. Mengedukasi diri sendiri tentang kesehatan mental dan mengenali tanda-tanda gangguan mental juga dapat membantu kita mengidentifikasi teman atau anggota keluarga yang mungkin membutuhkan bantuan. Dalam memperhatikan kesehatan mental, kita dapat membangun fondasi yang kuat untuk kehidupan yang sehat secara menyeluruh, memungkinkan kita untuk mengatasi tantangan dengan lebih baik, menumbuhkan hubungan yang lebih bermakna, dan mencapai potensi penuh kita sebagai manusia."
    ),
    Artikel(
        2,
        "https://akcdn.detik.net.id/visual/2020/09/14/ilustrasi-stress_169.jpeg?w=650",
        "Promoting Mental Health Awareness and Support", "13 Mei 2023",
        "Masalah kesehatan mental adalah isu yang semakin mendapat perhatian di tengah masyarakat saat ini. Namun, stigma yang melekat pada masalah ini masih menjadi penghalang dalam mengakses dukungan dan perawatan yang diperlukan. ",
        "Masalah kesehatan mental adalah isu yang semakin mendapat perhatian di tengah masyarakat saat ini. Namun, stigma yang melekat pada masalah ini masih menjadi penghalang dalam mengakses dukungan dan perawatan yang diperlukan. Penting bagi kita untuk menghancurkan stigma ini dan meningkatkan kesadaran tentang pentingnya perawatan kesehatan mental. Mengatasi masalah kesehatan mental bukanlah tanda kelemahan, tetapi bukti keberanian dan kekuatan untuk menghadapi tantangan hidup.\n" +
                "\n" +
                "Salah satu cara untuk mempromosikan kesadaran dan dukungan terhadap kesehatan mental adalah dengan mengedukasi masyarakat tentang berbagai gangguan mental yang ada, serta tanda-tanda dan gejalanya. Semakin banyak informasi yang tersebar, semakin mudah bagi individu untuk mengenali dan mencari bantuan jika mereka mengalami masalah kesehatan mental. Selain itu, perlu ada ruang yang aman dan inklusif di masyarakat di mana individu merasa nyaman berbicara tentang pengalaman mereka dan mencari dukungan tanpa takut dijauhi atau dihakimi. Dengan mempromosikan keterbukaan, empati, dan pengertian, kita dapat membantu mengubah persepsi masyarakat terhadap masalah kesehatan mental dan menciptakan lingkungan yang mendukung pemulihan dan pertumbuhan.\n" +
                "\n" +
                "Perlu diingat bahwa kesehatan mental adalah tanggung jawab bersama. Setiap individu, keluarga, tempat kerja, dan masyarakat secara keseluruhan memiliki peran dalam memastikan bahwa kesehatan mental diutamakan. Dukungan dapat diberikan melalui fasilitas layanan kesehatan mental, program pencegahan yang diperkuat, dan peningkatan aksesibilitas perawatan. Semua orang memiliki peran dalam menciptakan budaya yang memprioritaskan kesehatan mental, mempromosikan kesadaran, dan memberikan dukungan tanpa syarat. Dengan bersama-sama, kita dapat mengatasi stigma dan memberikan dukungan yang diperlukan bagi mereka yang membutuhkannya, memungkinkan setiap individu untuk hidup dengan kualitas hidup yang lebih baik dan lebih seimbang secara emosional."
    ),
    Artikel(
        3,
        "https://www.verywellmind.com/thmb/_1cwoTnaCf8rpMaZhfGsjwMl1r8=/3000x0/filters:no_upscale():max_bytes(150000):strip_icc()/mental-health-tracker-banner-03-db4c074daa7f4b719dfec6b4b4279c2d.png",
        "Nurturing Mental Health in a Hectic World", "17 Mei 2023",
        "Dalam kehidupan yang serba sibuk dan penuh tekanan, seringkali kita melupakan pentingnya merawat kesehatan mental kita. Self-care, atau perawatan diri, adalah praktek yang sangat penting untuk menjaga keseimbangan emosional dan kesejahteraan kita. ",
        "Dalam kehidupan yang serba sibuk dan penuh tekanan, seringkali kita melupakan pentingnya merawat kesehatan mental kita. Self-care, atau perawatan diri, adalah praktek yang sangat penting untuk menjaga keseimbangan emosional dan kesejahteraan kita. Ini melibatkan mengenali kebutuhan kita sendiri, menghargai batas diri, dan memberikan waktu untuk melakukan kegiatan yang memberikan ketenangan dan kegembiraan.\n" +
                "\n" +
                "Self-care dapat dilakukan dalam berbagai bentuk, tergantung pada preferensi dan kebutuhan individu. Ini bisa berupa meditasi, yoga, olahraga, menghabiskan waktu bersama keluarga dan teman-teman, atau bahkan sekadar mengambil waktu untuk diri sendiri dengan membaca buku atau mendengarkan musik. Dengan meluangkan waktu untuk merawat kesehatan mental kita, kita dapat memperkuat ketahanan kita terhadap stres, meningkatkan kualitas tidur, dan membangun kekuatan mental yang dibutuhkan untuk menghadapi tantangan sehari-hari.\n" +
                "\n" +
                "Penting untuk diingat bahwa self-care bukanlah bentuk egoisme atau kesia-siaan, tetapi merupakan investasi dalam kesehatan dan kebahagiaan kita sendiri. Dalam menghadapi tekanan dan tuntutan yang ada, kita perlu menghargai pentingnya memberikan waktu untuk diri sendiri dan menjaga keseimbangan dalam hidup kita. Dengan merawat kesehatan mental kita secara teratur, kita dapat menciptakan fondasi yang kuat untuk kehidupan yang lebih seimbang, bahagia, dan bermakna."
    ),
)
