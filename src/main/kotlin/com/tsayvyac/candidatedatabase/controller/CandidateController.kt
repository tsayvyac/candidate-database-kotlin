package com.tsayvyac.candidatedatabase.controller

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.service.CandidateService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/api/candidate")
class CandidateController(
    private val candidateService: CandidateService
) {

    @GetMapping(value = ["/fetchAll"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getAllCandidates() = candidateService.getAllCandidates()

    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addCandidate(@RequestBody request: CandidateRequest) = candidateService.addCandidate(request)

}

