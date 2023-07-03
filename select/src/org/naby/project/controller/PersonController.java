package org.naby.project.controller;

import org.naby.project.common.json.JSON;
import org.naby.project.common.wrapper.ErrorHandler;
import org.naby.project.model.entity.Person;
import org.naby.project.model.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/person")
public class PersonController {

    @Produces("application/json")
    @GET
    @Path("/findOne")
    public String findOne(@QueryParam("id") String id) throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .findOne(new Person().setId(Long.parseLong(id))));
        } catch (Exception e) {
            return ErrorHandler.getError(e).toString();
        }
    }
}