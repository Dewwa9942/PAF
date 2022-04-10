package com.github.paf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8050
 *http://localhost:8050/api/v1/bill/*
 */
@Path("/api/v1/bill")
public class BillController {
    private final Client client;
    private final String BASE_SERVICE_URI;

    public BillController(String baseUri) {
        this.client = ClientBuilder.newClient();
        this.BASE_SERVICE_URI = baseUri + "/bill/";
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBill(HashMap<String, ?> billData) {
        Entity<HashMap<String, ?>> entity = Entity.entity(billData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
    }

    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBill(HashMap<String, ?> billData, @PathParam("billId") Integer billId) {
        Entity<HashMap<String, ?>> entity = Entity.entity(billData, MediaType.APPLICATION_JSON);
        return client.target(BASE_SERVICE_URI + billId)
                .request(MediaType.APPLICATION_JSON)
                .put(entity, Response.class);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBills() {
        return client.target(BASE_SERVICE_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @GET
    @Path("/{billId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillById(@PathParam("billId") Integer billId) {
        return client.target(BASE_SERVICE_URI + billId)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    @DELETE
    @Path("/{billId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("billId") Integer billId) {
        return client.target(BASE_SERVICE_URI + billId)
                .request(MediaType.APPLICATION_JSON)
                .delete(Response.class);
    }
}
