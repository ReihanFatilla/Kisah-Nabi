package com.reift.kisahnabiapp.core.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reift.kisahnabiapp.core.di.Injection
import com.reift.kisahnabiapp.core.domain.usecase.KisahUseCase
import com.reift.kisahnabiapp.main.MainViewModel


// Tidak butuh karena menggunakan Koin
class KisahViewModelFactory private constructor(private val useCase: KisahUseCase){
//    : ViewModelProvider.NewInstanceFactory()
//
//        companion object{
//            @Volatile
//            private var instance: KisahViewModelFactory? = null
//
//            fun getInstance(context: Context): KisahViewModelFactory {
//                return instance
//                    ?: synchronized(this){
//                        instance ?: KisahViewModelFactory(
//                            Injection.provideUseCase()
//                        )
//                    }
//            }
//        }
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        when {
//            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
//                MainViewModel(useCase) as T
//            }
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }

}