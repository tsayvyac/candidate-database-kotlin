package com.tsayvyac.candidatedatabase.service

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateDetailsResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.model.Candidate

interface CandidateService {
    fun deleteCandidate(id: Long): Candidate
    fun updateCandidate(id: Long, candidateRequest: CandidateRequest): Candidate
    fun getCandidateDetails(id: Long): CandidateDetailsResponse
    fun getAllCandidates(): List<CandidateResponse>
    fun addCandidate(candidateRequest: CandidateRequest): Candidate
    fun addNewCandidateTechnology(id: Long, candidateTechnologyRequest: List<CandidateTechnologyRequest>): Candidate
}