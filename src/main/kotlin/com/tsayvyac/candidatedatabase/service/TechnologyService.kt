package com.tsayvyac.candidatedatabase.service

import com.tsayvyac.candidatedatabase.dto.technology.TechnologyDetailsResponse
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyRequest
import com.tsayvyac.candidatedatabase.dto.technology.TechnologyResponse
import com.tsayvyac.candidatedatabase.model.Technology

interface TechnologyService {

    /**
     * Deletes the technology with ID from the database.
     * @param id ID of the technology to be deleted.
     */
    fun deleteTechnology(id: Long)

    /**
     * Updates the information of the technology with ID using the provided technology request data.
     *
     * @param id              ID of the technology to be updated.
     * @param technologyRequest The technology request object containing the updated information.
     */
    fun updateTechnology(id: Long, technologyRequest: TechnologyRequest): Technology

    /**
     * Retrieves detailed information about the technology with ID.
     *
     * @param id ID of the technology for which details are to be retrieved.
     * @return An object {@link TechnologyDetailsResponse} representing response that contains the detailed information about the technology.
     */
    fun getTechnologyDetails(id: Long): TechnologyDetailsResponse

    /**
     * Retrieves all technologies stores in the database.
     *
     * @return A list of {@link TechnologyResponse} objects representing the technologies.
     */
    fun getAllTechnologies(): List<TechnologyResponse>

    /**
     * Adds a new technology to the database using the provided technology request data.
     *
     * @param technologyRequest The technology request object containing the technology's information.
     */
    fun addTechnology(technologyRequest: TechnologyRequest): Technology

}