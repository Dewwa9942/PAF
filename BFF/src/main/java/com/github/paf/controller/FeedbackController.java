package com.github.paf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8060
 *http://localhost:8060/api/v1/feedback/*
 */
@Path("/api/v1/feedback")
public class FeedbackController {
    private final Client client;
    private final String BASE_SERVICE_URI;

    public FeedbackController(String baseUri) {
        this.client = ClientBuilder.newClient();
        this.BASE_SERVICE_URI = baseUri + "/feedback/";
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFeedback(HashMap<String, ?> feedbackData) {
        Entity<HashMap<String, ?>> entity = Entity.entity(feedbackData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
    }

    @PUT
    @Path("/{feedbackId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFeedback(HashMap<String, ?> feedbackData, @PathParam("feedbackId") Integer feedbackId) {
        Entity<HashMap<String, ?>> entity = Entity.entity(feedbackData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI + feedbackId)
                .request(MediaType.APPLICATION_JSON)
                .put(entity, Response.class);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbacks() {
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @GET
    @Path("/{feedbackId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbackById(@PathParam("feedbackId") Integer feedbackId) {
        return client.target(BASE_SERVICE_URI + feedbackId)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @DELETE
    @Path("/{feedbackId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("feedbackId") Integer feedbackId) {
        return client.target(BASE_SERVICE_URI + feedbackId)
                .request(MediaType.APPLICATION_JSON)
                .delete(Response.class);
    }
}
