package com.tsayvyac.candidatedatabase.service.impl

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyDetailsResponse
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyRequest
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.model.Technology
import com.tsayvyac.candidatedatabase.repository.TechnologyRepository
import com.tsayvyac.candidatedatabase.service.TechnologyService
import com.tsayvyac.candidatedatabase.service.mapper.TechnologyMapper
import org.springframework.stereotype.Service

@Service
class StandardTechnologyService(
    private val technologyRepository: TechnologyRepository,
    private val technologyMapper: TechnologyMapper
): TechnologyService {

    override fun deleteTechnology(id: Long): Technology {
        TODO("Not yet implemented")
    }

    override fun updateTechnology(id: Long, technologyRequest: TechnologyRequest): Technology {
        TODO("Not yet implemented")
    }

    override fun getTechnologyDetails(id: Long): TechnologyDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun getAllTechnologies(): List<TechnologyResponse> = technologyRepository.findAll()
            .map(technologyMapper::mapToResponse)

    override fun addTechnology(technologyRequest: TechnologyRequest): Technology {
        val technology = Technology(
            name = technologyRequest.name
        )
        return technologyRepository.save(technology)
    }
}