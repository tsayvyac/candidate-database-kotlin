package com.tsayvyac.candidatedatabase.controller

import com.tsayvyac.candidatedatabase.dto.candidate.CandidateRequest
import com.tsayvyac.candidatedatabase.dto.candidate.CandidateTechnologyRequest
import com.tsayvyac.candidatedatabase.service.CandidateService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun getAllCandidates() =
        candidateService.getAllCandidates()

    @GetMapping(value = ["/fetchDetails/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getCandidateDetailsById(@PathVariable id: Long) =
        candidateService.getCandidateDetails(id)

    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addCandidate(@RequestBody request: CandidateRequest) =
        candidateService.addCandidate(request)

    @PutMapping(value = ["/addTech/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun addNewCandidateTechnology(
        @PathVariable id: Long,
        @RequestBody candidateTechnologyRequest: List<CandidateTechnologyRequest>
    ) = candidateService.addNewCandidateTechnology(id, candidateTechnologyRequest)

    @PutMapping(value = ["/update/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateCandidate(@PathVariable id: Long, @RequestBody candidateRequest: CandidateRequest) =
        candidateService.updateCandidate(id, candidateRequest)

    @DeleteMapping(value = ["/delete/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun deleteCandidate(@PathVariable id: Long) =
        candidateService.deleteCandidate(id)
}

