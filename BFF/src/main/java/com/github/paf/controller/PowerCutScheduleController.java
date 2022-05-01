package com.github.paf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8070
 *http://localhost:8070/api/v1/powercutschedule/*
 */
@Path("/api/v1/powercutschedule")
public class PowerCutScheduleController {
    private final Client client;
    private final String BASE_SERVICE_URI;

    public PowerCutScheduleController(String baseUri) {
        this.client = ClientBuilder.newClient();
        this.BASE_SERVICE_URI = baseUri + "/powercutschedule/";
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPowerCutSchedule(HashMap<String, ?> powercutscheduleData) {
        Entity<HashMap<String, ?>> entity = Entity.entity(powercutscheduleData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
    }

    @PUT
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePowerCutSchedule(HashMap<String, ?> powercutscheduleData, @PathParam("powercutscheduleId") Integer powercutscheduleId) {
        Entity<HashMap<String, ?>> entity = Entity.entity(powercutscheduleData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI + powercutscheduleId)
                .request(MediaType.APPLICATION_JSON)
                .put(entity, Response.class);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPowerCutSchedules() {
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @GET
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPowerCutScheduleById(@PathParam("powercutscheduleId") Integer powercutscheduleId) {
        return client.target(BASE_SERVICE_URI + powercutscheduleId)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @DELETE
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("powercutscheduleId") Integer powercutscheduleId) {
        return client.target(BASE_SERVICE_URI + powercutscheduleId)
                .request(MediaType.APPLICATION_JSON)
                .delete(Response.class);
    }
}

