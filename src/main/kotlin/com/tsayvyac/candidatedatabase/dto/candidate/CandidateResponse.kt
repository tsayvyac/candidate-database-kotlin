package com.tsayvyac.candidatedatabase.dto.candidate

data class CandidateResponse (
    var id: Long,
    var firstName: String,
    var lastName: String,
    var useTechnologies: Set<CandidateTechnologyLevel>
)