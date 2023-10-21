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
    fun getAllTechnologies() =
        technologyService.getAllTechnologies()

    @GetMapping(value = ["/fetchDetails/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getTechnologyDetailsById(@PathVariable id: Long) =
        technologyService.getTechnologyDetails(id)

    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addTechnology(@RequestBody request: TechnologyRequest) =
        technologyService.addTechnology(request)

    @PutMapping(value = ["/update/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateTechnology(@PathVariable id: Long, @RequestBody technologyRequest: TechnologyRequest) =
        technologyService.updateTechnology(id, technologyRequest)

    @DeleteMapping(value = ["/delete/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun deleteTechnology(@PathVariable id: Long) =
        technologyService.deleteTechnology(id)
}