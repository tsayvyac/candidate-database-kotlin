package com.tsayvyac.candidatedatabase.dto.candidate

data class CandidateDetailsResponse (
    var id: Long,
    var firstName: String,
    var lastName: String,
    var age: Int,
    var useTechnologies: Set<TechnologyInfo>
)