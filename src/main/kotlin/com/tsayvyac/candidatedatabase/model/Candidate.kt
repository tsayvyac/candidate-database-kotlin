package com.tsayvyac.candidatedatabase.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
data class Candidate (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var firstName: String,

    var lastName: String,

    var age: Int?,

    @OneToMany(mappedBy = "candidate", cascade = [CascadeType.REMOVE], fetch = FetchType.LAZY)
    @JsonManagedReference
    var useTechnologies: Set<CandidateUseTechnology>
)