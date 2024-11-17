package com.sdu.skillcinema.data.repository

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.network.retrofit
import com.sdu.skillcinema.domain.model.Staff
import com.sdu.skillcinema.domain.repository.StaffRepository

class StaffRepositoryImpl: StaffRepository {

    private val api = retrofit.create(KinopoiskApi::class.java)

    override suspend fun getStaffDetails(id: Int): Staff {
        return api.getStaffDetails(id)
    }

}