package com.tsayvyac.candidatedatabase.model

import jakarta.persistence.*

@Entity
data class Technology (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String,

    @OneToMany(mappedBy = "technology", cascade = [CascadeType.REMOVE], fetch = FetchType.LAZY)
    var useTechnologies: Set<CandidateUseTechnology> = HashSet()
)