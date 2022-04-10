package com.github.paf.controller;

import com.github.paf.model.Feedback;
import com.github.paf.service.FeedbackService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8060
 *http://localhost:8060/api/v1/feedback/*
 */
@Path("/api/v1/feedback")
public class FeedbackController {

    private Feedback feedback;
    private final FeedbackService feedbackService = new FeedbackService();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFeedback(HashMap<String, ?> feedbackData) {
        String nic = (String) feedbackData.get("nic");
        String category = (String) feedbackData.get("category");
        String location = (String) feedbackData.get("location");
        String message = (String) feedbackData.get("message");
        feedback = new Feedback(nic, category, location, message);

        return feedbackService.addFeedback(feedback);
    }

    @PUT
    @Path("/{feedbackId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFeedback(HashMap<String, ?> feedbackData, @PathParam("feedbackId") Integer feedbackId) {
        String nic = (String) feedbackData.get("nic");
        String category = (String) feedbackData.get("category");
        String location = (String) feedbackData.get("location");
        String message = (String) feedbackData.get("message");
        feedback = new Feedback(nic, category, location, message);
        feedback.setId(feedbackId);

        return feedbackService.updateFeedback(feedback);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbacks() {
        return feedbackService.getFeedbacks();
    }

    @GET
    @Path("/{feedbackId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbackById(@PathParam("feedbackId") Integer feedbackId) {
        return feedbackService.getFeedbackById(feedbackId);
    }

    @DELETE
    @Path("/{feedbackId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("feedbackId") Integer feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }
}
