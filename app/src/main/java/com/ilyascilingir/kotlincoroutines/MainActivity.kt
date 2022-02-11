package com.ilyascilingir.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Dispatchers
        //Dispatchers.Default -> CPU Intensive işlemlerde (görsel işleme yapmak , büyük bir diziyi dizmek vs. [işlemciyi çok yorabilecek işlemler.])
        //Dispatchers.IO ->  Input / Output , Networking işlemlerinde (internetten veri çekmek,bir veritabanından veri almak vs.)
        //Dispatchers.Main -> UI (Kullanıcının göreceği ekranlarda , arayüz vs.)
        //Dispatchers.Unconfined -> Inherited dispatcher (nerede oluşturulduysa miras alıyor.)

        //Tek bir işlem yapacağımız için runBlocking kullanmamız için idealdir.


        runBlocking {

            launch (Dispatchers.Main) {
                println("Main Thread : ${Thread.currentThread().name}")
            }

            launch (Dispatchers.IO) {
                println("IO Thread : ${Thread.currentThread().name}")
            }

            launch (Dispatchers.Default) {
                println("Default Thread : ${Thread.currentThread().name}")
            }

            launch (Dispatchers.Unconfined) {
                println("Unconfined Thread : ${Thread.currentThread().name}")
            }
        }
    }
}

fun main() {
    runBlocking {
        delay(2000)
        println("run blocking")
        myFunction()
    }
}

suspend fun myFunction () {
    coroutineScope {
        delay(4000)
        println("suspend function")
    }
}