package com.tsayvyac.candidatedatabase.service.impl

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateDetailsResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.exception.CandidateException
import com.tsayvyac.candidatedatabase.model.Candidate
import com.tsayvyac.candidatedatabase.model.CandidateTechnologyKey
import com.tsayvyac.candidatedatabase.repository.CandidateRepository
import com.tsayvyac.candidatedatabase.service.CandidateService
import com.tsayvyac.candidatedatabase.service.mapper.CandidateMapper
import org.springframework.stereotype.Service

@Service
class StandardCandidateService(
    private val candidateRepository: CandidateRepository,
    private val standardTechnologyService: StandardTechnologyService,
    private val cutService: CandidateUseTechnologyService,
    private val candidateMapper: CandidateMapper
): CandidateService {

    override fun deleteCandidate(id: Long) =
        candidateRepository.deleteById(id)

    override fun updateCandidate(id: Long, candidateRequest: CandidateRequest): Candidate {
        val candidate = candidateRepository.findById(id)
        candidate.ifPresent {
            it.firstName = candidateRequest.firstName
            it.lastName = candidateRequest.lastName
            it.age = candidateRequest.age
            candidateRequest.technologies.forEach { ctr ->
                val techId = standardTechnologyService.getTechnologyId(ctr.name)
                cutService.updateCUT(CandidateTechnologyKey(techId, id), ctr)
            }
            candidateRepository.save(it)
        }
        return candidate.get()
    }

    override fun getCandidateDetails(id: Long): CandidateDetailsResponse {
        return candidateRepository.findById(id)
            .map(candidateMapper::mapToDetailsResponse)
            .orElseThrow()
    }

    override fun getAllCandidates(): List<CandidateResponse> = candidateRepository
        .findAll()
        .map(candidateMapper::mapToResponse)

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
        val candidate = candidateRepository.findById(id)
        if (!candidate.isPresent) throw CandidateException("Candidate not found.")
        cutService.addToAssociativeTable(candidate.get(), candidateTechnologyRequests)
        candidateRepository.save(candidate.get())
        return candidate.get()
    }
}