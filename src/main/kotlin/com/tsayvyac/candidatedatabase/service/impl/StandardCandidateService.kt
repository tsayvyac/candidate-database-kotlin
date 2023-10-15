package com.tsayvyac.candidatedatabase.service.impl

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateDetailsResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.model.Candidate
import com.tsayvyac.candidatedatabase.repository.CandidateRepository
import com.tsayvyac.candidatedatabase.service.CandidateService
import org.springframework.stereotype.Service

@Service
class StandardCandidateService(
    private val candidateRepository: CandidateRepository,
    private val standardTechnologyService: StandardTechnologyService,
    private val cutService: CandidateUseTechnologyService,
): CandidateService {

    override fun deleteCandidate(id: Long): Candidate {
        TODO("Not yet implemented")
    }

    override fun updateCandidate(id: Long, candidateRequest: CandidateRequest): Candidate {
        TODO("Not yet implemented")
    }

    override fun getCandidateDetails(id: Long): CandidateDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun getAllCandidates(): List<CandidateResponse> {
        TODO("Not yet implemented")
    }

    override fun addCandidate(candidateRequest: CandidateRequest): Candidate {
        val candidate = Candidate(
            firstName = candidateRequest.firstName,
            lastName = candidateRequest.lastName,
            age = candidateRequest.age
        )

        candidateRepository.save(candidate)
        cutService.addToAssociativeTable(candidate, candidateRequest.technologies)
        return candidate
    }

    override fun addNewCandidateTechnology(
        id: Long,
        candidateTechnologyRequests: List<CandidateTechnologyRequest>
    ): Candidate {
        TODO("Not yet implemented")
    }
}