package com.tsayvyac.candidatedatabase.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
data class CandidateUseTechnology (
    @EmbeddedId
    var id: CandidateTechnologyKey,

    @ManyToOne @MapsId("technologyId")
    @JoinColumn(name = "technology_id") @JsonBackReference
    var technology: Technology,

    @ManyToOne @MapsId("candidateId")
    @JoinColumn(name = "candidate_id") @JsonBackReference
    var candidate: Candidate,

    var level: Int?,

    var note: String?
)