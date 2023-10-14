package com.tsayvyac.candidatedatabase.service

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyDetailsResponse
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyRequest
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.model.Technology

interface TechnologyService {
    fun deleteTechnology(id: Long): Technology
    fun updateTechnology(id: Long, technologyRequest: TechnologyRequest): Technology
    fun getTechnologyDetails(id: Long): TechnologyDetailsResponse
    fun getAllTechnologies(): List<TechnologyResponse>
    fun addTechnology(technologyRequest: TechnologyRequest): Technology
}