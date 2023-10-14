package com.tsayvyac.candidatedatabase.repository

import com.tsayvyac.candidatedatabase.model.CandidateTechnologyKey
import com.tsayvyac.candidatedatabase.model.CandidateUseTechnology
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateUseTechnologyRepository: JpaRepository<CandidateUseTechnology, CandidateTechnologyKey> {
}