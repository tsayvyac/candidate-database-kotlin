package com.tsayvyac.candidatedatabase.repository

import com.tsayvyac.candidatedatabase.model.Technology
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TechnologyRepository: JpaRepository<Technology, Long> {
    fun findByName(name: String): Technology
}