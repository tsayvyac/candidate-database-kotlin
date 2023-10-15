package com.tsayvyac.candidatedatabase.dto.technology

data class CandidateInfo(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var level: Int?,
    var note: String?
)
