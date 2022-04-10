package com.github.paf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8040
 *http://localhost:8040/api/v1/payment/*
 */
@Path("/api/v1/payment")
public class PaymentController {
    private final Client client;
    private final String BASE_SERVICE_URI;

    public PaymentController(String baseUri) {
        this.client = ClientBuilder.newClient();
        this.BASE_SERVICE_URI = baseUri + "/payment/";
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(HashMap<String, ?> paymentData) {
        Entity<HashMap<String, ?>> entity = Entity.entity(paymentData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
    }

    @PUT
    @Path("/{paymentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(HashMap<String, ?> paymentData, @PathParam("paymentId") Integer paymentId) {
        Entity<HashMap<String, ?>> entity = Entity.entity(paymentData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI + paymentId)
                .request(MediaType.APPLICATION_JSON)
                .put(entity, Response.class);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayments() {
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @GET
    @Path("/{paymentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("paymentId") Integer paymentId) {
        return client.target(BASE_SERVICE_URI + paymentId)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @DELETE
    @Path("/{paymentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("paymentId") Integer paymentId) {
        return client.target(BASE_SERVICE_URI + paymentId)
                .request(MediaType.APPLICATION_JSON)
                .delete(Response.class);
    }
}
