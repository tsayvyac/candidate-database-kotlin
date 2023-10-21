package com.tsayvyac.candidatedatabase.service

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateDetailsResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateResponse
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.model.Candidate

interface CandidateService {

    /**
     * Deletes the candidate with ID from the database.
     * @param id ID of the candidate to be deleted.
     */
    fun deleteCandidate(id: Long)

    /**
     * Updates the information of the candidate with ID using the provided candidate request data.
     *
     * @param id              ID of the candidate to be updated.
     * @param candidateRequest The candidate request object containing the updated information.
     */
    fun updateCandidate(id: Long, candidateRequest: CandidateRequest): Candidate

    /**
     * Retrieves detailed information about the candidate with ID.
     *
     * @param id ID of the candidate for which details are to be retrieved.
     * @return An object {@link CandidateDetailsResponse} representing response that contains the detailed information about the candidate.
     */
    fun getCandidateDetails(id: Long): CandidateDetailsResponse

    /**
     * Retrieves all candidates stores in the database.
     *
     * @return A list of {@link CandidateResponse} objects representing the candidates.
     */
    fun getAllCandidates(): List<CandidateResponse>

    /**
     * Adds a new candidate to the database using the provided candidate request data.
     *
     * @param candidateRequest The candidate request object containing the candidate's information.
     */
    fun addCandidate(candidateRequest: CandidateRequest): Candidate

    /**
     * Adds new technologies to an existing candidate using the provided candidate ID and technology requests.
     *
     * @param id                       ID of the candidate to whom technologies will be added.
     * @param candidateTechnologyRequests A list of {@link CandidateTechnologyRequest} objects representing the new technologies.
     */
    fun addNewCandidateTechnology(id: Long, candidateTechnologyRequests: List<CandidateTechnologyRequest>): Candidate
}