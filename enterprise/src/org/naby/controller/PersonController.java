package org.naby.controller;

import org.naby.common.JSON;
import org.naby.common.ErrorHandler;
import org.naby.model.entity.Person;
import org.naby.model.service.PersonService;

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

    @Produces("application/json")
    @GET
    @Path("/save")
    public String save(@QueryParam("name") String name, @QueryParam("family") String family, @QueryParam("phone") String phone) throws Exception {
        try {
            return PersonService
                    .getInstance()
                    .save(new Person().setName(name).setFamily(family).setPhone(phone));
        } catch (Exception e) {
            return ErrorHandler.getError(e).toString();
        }
    }

    @Produces("application/json")
    @GET
    @Path("/update")
    public String update(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("family") String family, @QueryParam("phone") String phone) throws Exception {
        try {
            return PersonService
                    .getInstance()
                    .update(new Person().setId(Long.parseLong(id)).setName(name).setFamily(family).setPhone(phone));
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/remove")
    public String remove(@QueryParam("id") String id) throws Exception {
        try {
            return PersonService
                    .getInstance()
                    .remove(new Person().setId(Long.parseLong(id)));
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }
}