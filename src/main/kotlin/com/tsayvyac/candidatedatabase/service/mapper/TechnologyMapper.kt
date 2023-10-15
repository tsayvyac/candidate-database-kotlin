package com.tsayvyac.candidatedatabase.service.mapper

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.model.Technology
import com.tsayvyac.candidatedatabase.repository.CandidateRepository
import org.springframework.stereotype.Component

@Component
class TechnologyMapper(
    private val candidateRepository: CandidateRepository
) {

    fun mapToResponse(technology: Technology): TechnologyResponse = TechnologyResponse(
            id = technology.id,
            name = technology.name
        )
}