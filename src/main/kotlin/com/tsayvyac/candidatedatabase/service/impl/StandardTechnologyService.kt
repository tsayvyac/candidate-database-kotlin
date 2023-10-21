package com.tsayvyac.candidatedatabase.service.impl

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyDetailsResponse
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyRequest
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.exception.TechnologyException
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

    override fun deleteTechnology(id: Long) =
        technologyRepository.deleteById(id)

    override fun updateTechnology(id: Long, technologyRequest: TechnologyRequest): Technology {
        if (!technologyRepository.findById(id).isPresent) throw TechnologyException("Technology not found.")
        val technology = technologyRepository.findById(id).get()
        technology.name = technologyRequest.name
        technologyRepository.save(technology)
        return technology
    }

    override fun getTechnologyDetails(id: Long): TechnologyDetailsResponse = technologyRepository
        .findById(id)
        .map(technologyMapper::mapToDetailsResponse)
        .orElseThrow()

    override fun getAllTechnologies(): List<TechnologyResponse> = technologyRepository
        .findAll()
        .map(technologyMapper::mapToResponse)

    override fun addTechnology(technologyRequest: TechnologyRequest): Technology {
        if (technologyRepository.findByName(technologyRequest.name) != null)
            throw TechnologyException("${technologyRequest.name} technology already exist!")
        val technology = Technology(
            name = technologyRequest.name
        )
        return technologyRepository.save(technology)
    }

    fun getTechnologyId(name: String) =
        technologyRepository.findByName(name)?.id ?: throw TechnologyException("Technology with $name does not exist.")
}