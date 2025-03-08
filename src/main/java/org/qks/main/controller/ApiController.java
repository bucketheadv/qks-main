package org.qks.main.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.qks.main.dao.po.UserPo;
import org.qks.main.service.UserService;

@Path("/api")
public class ApiController {
    @Inject
    UserService userService;

    @GET
    @Path("/user")
    public UserPo user(@QueryParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GET
    @Path("ok")
    public String ok() {
        return "ok";
    }
}
