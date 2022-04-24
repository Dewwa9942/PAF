package com.github.paf.controller;

import com.github.paf.model.PowerCutSchedule;
import com.github.paf.service.PowerCutScheduleService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 8070
 *http://localhost:8070/api/v1/powercutschedule/*
 */
@Path("/api/v1/powercutschedule")
public class PowerCutScheduleController {

    private PowerCutSchedule powercutschedule;
    private final PowerCutScheduleService powercutscheduleService = new PowerCutScheduleService();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPowerCutSchedule(HashMap<String, ?> powercutscheduleData) {
        String zone = (String) powercutscheduleData.get("zone");
        String date = (String) powercutscheduleData.get("date");
        String time = (String) powercutscheduleData.get("time");
        String totalHours = (String) powercutscheduleData.get("totalHours");
        powercutschedule = new PowerCutSchedule(zone, date, time, totalHours);

        return powercutscheduleService.addPowerCutSchedule(powercutschedule);
    }

    @PUT
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePowerCutSchedule(HashMap<String, ?> powercutscheduleData, @PathParam("powercutscheduleId") Integer powercutscheduleId) {
        String zone = (String) powercutscheduleData.get("zone");
        String date = (String) powercutscheduleData.get("date");
        String time = (String) powercutscheduleData.get("time");
        String totalHours = (String) powercutscheduleData.get("totalHours");
        powercutschedule = new PowerCutSchedule(zone, date, time, totalHours);
        powercutschedule.setId(powercutscheduleId);

        return powercutscheduleService.updatePowerCutSchedule(powercutschedule);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPowerCutSchedules() {
        return powercutscheduleService.getPowerCutSchedulers();
    }

    @GET
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPowerCutScheduleById(@PathParam("powercutscheduleId") Integer powercutscheduleId) {
        return powercutscheduleService.getPowerCutScheduleById(powercutscheduleId);
    }

    @DELETE
    @Path("/{powercutscheduleId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("powercutscheduleId") Integer powercutscheduleId) {
        return powercutscheduleService.deletePowerCutSchedule(powercutscheduleId);
    }
}

