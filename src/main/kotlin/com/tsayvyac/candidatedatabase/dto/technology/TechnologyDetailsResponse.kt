package com.tsayvyac.candidatedatabase.dto.technology

data class TechnologyDetailsResponse(
    var id: Long,
    var name: String,
    var usesTechnology: Set<CandidateInfo>
)
