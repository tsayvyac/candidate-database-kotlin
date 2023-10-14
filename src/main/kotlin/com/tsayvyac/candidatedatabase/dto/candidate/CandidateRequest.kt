package com.tsayvyac.candidatedatabase.dto.candidate

data class CandidateRequest (
    var firstName: String,
    var lastName: String,
    var age: Int,
    var technologies: List<CandidateTechnologyRequest>
)