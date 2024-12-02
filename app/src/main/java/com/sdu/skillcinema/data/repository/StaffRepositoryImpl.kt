package com.sdu.skillcinema.data.repository

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.domain.model.Staff
import com.sdu.skillcinema.domain.repository.StaffRepository
import javax.inject.Inject

class StaffRepositoryImpl @Inject constructor(
    private val api: KinopoiskApi
): StaffRepository {

    override suspend fun getStaffDetails(id: Int): Staff {
        return api.getStaffDetails(id)
    }

}