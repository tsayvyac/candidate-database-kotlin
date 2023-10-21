package com.tsayvyac.candidatedatabase.service.mapper

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateDetailsResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyLevel
import com.tsayvyac.candidatedatabase.dto.candidate.TechnologyInfo
import com.tsayvyac.candidatedatabase.model.Candidate
import com.tsayvyac.candidatedatabase.model.CandidateUseTechnology
import com.tsayvyac.candidatedatabase.repository.TechnologyRepository
import org.springframework.stereotype.Component

@Component
class CandidateMapper(
    private val technologyRepository: TechnologyRepository
) {

    fun mapToResponse(candidate: Candidate): CandidateResponse = CandidateResponse(
        id = candidate.id,
        firstName = candidate.firstName,
        lastName = candidate.lastName,
        useTechnologies = mapToCandidateTechnologyLevel(candidate.useTechnologies)
    )

    fun mapToDetailsResponse(candidate: Candidate): CandidateDetailsResponse {
        return CandidateDetailsResponse(
            id = candidate.id,
            firstName = candidate.firstName,
            lastName = candidate.lastName,
            age = candidate.age,
            useTechnologies = mapToTechnologyInfo(candidate.useTechnologies)
        )
    }

    private fun mapToTechnologyInfo(
        candidateUseTechnology: Set<CandidateUseTechnology>
    ): Set<TechnologyInfo> = candidateUseTechnology.map { cut ->
            technologyRepository.findById(cut.technology.id).map { technology ->
                TechnologyInfo(
                    id = technology.id,
                    name = technology.name,
                    level = cut.level,
                    note = cut.note
                )
            }.orElseThrow()
        }.toSet()

    private fun mapToCandidateTechnologyLevel(
        candidateUseTechnology: Set<CandidateUseTechnology>
    ): Set<CandidateTechnologyLevel> = candidateUseTechnology.map { cut ->
            technologyRepository.findById(cut.technology.id).map {technology ->
                CandidateTechnologyLevel(
                    name = technology.name,
                    level = cut.level
                )
            }.orElseThrow()
        }.toSet()
}