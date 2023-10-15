package com.tsayvyac.candidatedatabase.service.mapper

import com.tsayvyac.candidatedatabase.repository.TechnologyRepository
import org.springframework.stereotype.Component

@Component
class CandidateMapper(
    private val technologyRepository: TechnologyRepository
) {

}