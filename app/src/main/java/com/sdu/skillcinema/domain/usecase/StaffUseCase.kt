package com.sdu.skillcinema.domain.usecase

import com.sdu.skillcinema.data.repository.StaffRepositoryImpl
import com.sdu.skillcinema.domain.model.Staff

class StaffUseCase {

    private val staffRepository = StaffRepositoryImpl()

    suspend fun getStuffDetailsById(id: Int): Staff {
        return staffRepository.getStaffDetails(id)
    }

}