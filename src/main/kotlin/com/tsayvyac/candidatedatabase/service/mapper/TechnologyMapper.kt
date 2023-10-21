package com.tsayvyac.candidatedatabase.service.mapper

import com.tsayvyac.candidatedatabase.dto.technology.CandidateInfo
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyDetailsResponse
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.model.CandidateUseTechnology
import com.tsayvyac.candidatedatabase.model.Technology
import com.tsayvyac.candidatedatabase.repository.CandidateRepository
import org.springframework.stereotype.Component

@Component
class TechnologyMapper(
    private val candidateRepository: CandidateRepository
) {

    fun mapToDetailsResponse(technology: Technology): TechnologyDetailsResponse = TechnologyDetailsResponse(
        id = technology.id,
        name = technology.name,
        usesTechnology = mapToCandidateInfo(technology.useTechnologies)
    )

    fun mapToResponse(technology: Technology): TechnologyResponse = TechnologyResponse(
            id = technology.id,
            name = technology.name
        )

    private fun mapToCandidateInfo(
        candidateUseTechnology: Set<CandidateUseTechnology>
    ): Set<CandidateInfo> = candidateUseTechnology.map { cut ->
        candidateRepository.findById(cut.candidate.id).map { candidate ->
            CandidateInfo(
                id = candidate.id,
                firstName = candidate.firstName,
                lastName = candidate.lastName,
                level = cut.level,
                note = cut.note
            )
        }.orElseThrow()
    }.toSet()
}