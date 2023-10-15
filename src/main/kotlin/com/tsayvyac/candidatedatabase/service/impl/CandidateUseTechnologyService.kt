package com.tsayvyac.candidatedatabase.service.impl

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.model.Candidate
import com.tsayvyac.candidatedatabase.model.CandidateTechnologyKey
import com.tsayvyac.candidatedatabase.model.CandidateUseTechnology
import com.tsayvyac.candidatedatabase.repository.CandidateUseTechnologyRepository
import com.tsayvyac.candidatedatabase.repository.TechnologyRepository
import com.tsayvyac.candidatedatabase.util.Helper
import org.springframework.stereotype.Service

@Service
class CandidateUseTechnologyService(
    private val cutRepository: CandidateUseTechnologyRepository,
    private val technologyRepository: TechnologyRepository
) {
    fun addToAssociativeTable(
        candidate: Candidate,
        candidateTechnologyRequests: List<CandidateTechnologyRequest>
    ) {
        candidateTechnologyRequests.forEach { ctr ->
            val technology = technologyRepository.findByName(ctr.name)
            cutRepository.save(
                CandidateUseTechnology(
                    id = CandidateTechnologyKey(technology.id, candidate.id),
                    technology = technology,
                    candidate = candidate,
                    level = Helper.checkLevelBounds(ctr.level),
                    note = ctr.note
                )
            )
        }
    }
}