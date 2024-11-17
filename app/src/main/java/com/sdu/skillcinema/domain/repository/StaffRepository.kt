package com.sdu.skillcinema.domain.repository

import com.sdu.skillcinema.domain.model.Staff

interface StaffRepository {

    suspend fun getStaffDetails(id: Int): Staff

}