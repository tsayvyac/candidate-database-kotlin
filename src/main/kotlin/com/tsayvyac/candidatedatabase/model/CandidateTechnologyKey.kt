package com.tsayvyac.candidatedatabase.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import kotlinx.serialization.Serializable

@Embeddable
@Serializable
data class CandidateTechnologyKey (
    @Column(name = "technology_id")
    var technologyId: Long,

    @Column(name = "candidate_id")
    var candidateId: Long
)