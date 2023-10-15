package com.tsayvyac.candidatedatabase.controller

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyRequest
import com.tsayvyac.candidatedatabase.service.TechnologyService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tech")
class TechnologyController(
    private val technologyService: TechnologyService
) {

    @GetMapping(value = ["/fetchAll"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllTechnologies() = technologyService.getAllTechnologies()

    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addTechnology(@RequestBody request: TechnologyRequest) = technologyService.addTechnology(request)


}