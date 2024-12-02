package com.sdu.skillcinema.domain.usecase

import com.sdu.skillcinema.data.repository.StaffRepositoryImpl
import com.sdu.skillcinema.domain.model.Staff
import com.sdu.skillcinema.domain.repository.StaffRepository
import javax.inject.Inject

class StaffUseCase @Inject constructor(
    private val staffRepository: StaffRepository
) {

    suspend fun getStuffDetailsById(id: Int): Staff {
        return staffRepository.getStaffDetails(id)
    }

}