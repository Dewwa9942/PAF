package com.github.paf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8030
 *http://localhost:8030/api/v1/user/*
 */
@Path("/api/v1/user")
public class UserController {
    private final Client client;
    private final String BASE_SERVICE_URI;

    public UserController(String baseUri) {
        this.client = ClientBuilder.newClient();
        this.BASE_SERVICE_URI = baseUri + "/user/";
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(HashMap<String, ?> userData) {
        Entity<HashMap<String, ?>> entity = Entity.entity(userData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(HashMap<String, ?> userData, @PathParam("userId") Integer userId) {
        Entity<HashMap<String, ?>> entity = Entity.entity(userData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI + userId)
                .request(MediaType.APPLICATION_JSON)
                .put(entity, Response.class);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @GET
    @Path("/{userId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") Integer userId) {
        return client.target(BASE_SERVICE_URI + userId)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @DELETE
    @Path("/{userId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("userId") Integer userId) {
        return client.target(BASE_SERVICE_URI + userId)
                .request(MediaType.APPLICATION_JSON)
                .delete(Response.class);
    }
}
