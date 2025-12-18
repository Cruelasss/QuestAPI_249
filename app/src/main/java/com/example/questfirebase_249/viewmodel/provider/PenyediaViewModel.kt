package com.example.questfirebase_249.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questfirebase_249.repositori.AplikasiDataSiswa


fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            _root_ide_package_.com.example.questfirebase_249.viewmodel.HomeViewModel(
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
        initializer {
            _root_ide_package_.com.example.questfirebase_249.viewmodel.EntryViewModel(
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
    }
}