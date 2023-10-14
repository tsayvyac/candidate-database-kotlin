package com.tsayvyac.candidatedatabase.repository

import com.tsayvyac.candidatedatabase.model.Candidate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepository: JpaRepository<Candidate, Long> {
}