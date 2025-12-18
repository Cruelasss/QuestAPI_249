package com.example.questfirebase_249.repositori

import com.example.questfirebase_249.apiservice.ServiceApiSiswa
import com.example.questfirebase_249.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa {
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}