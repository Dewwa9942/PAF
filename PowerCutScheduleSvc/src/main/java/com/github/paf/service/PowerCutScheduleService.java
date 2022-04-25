package com.github.paf.service;

import com.github.paf.model.PowerCutSchedule;
import com.github.paf.repository.DBConnection;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PowerCutScheduleService {
    private DBConnection connection = new DBConnection();

    public Response addPowerCutSchedule(PowerCutSchedule powercutschedule) {
        int insertedId = -99;
        try {
            Connection con = connection.getConnection();
            if (con == null) return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("DataBase connectivity Error")
                    .build();

            String query = "INSERT INTO powercutschedule(zone, date, time, totalHours) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, powercutschedule.getZone());
            preparedStmt.setString(2, powercutschedule.getDate());
            preparedStmt.setString(3, powercutschedule.getTime());
            preparedStmt.setString(4, powercutschedule.getTotalHours());

            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()){
                insertedId  = Integer.parseInt(rs.getString(1));
            }
            con.close();

            powercutschedule.setId(insertedId);
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity(powercutschedule)
                .build();
    }

    public Response getPowerCutSchedulers() {
        List<PowerCutSchedule> powercutschedules = new ArrayList<PowerCutSchedule> ();

        try {
            Connection con = connection.getConnection();
            if (con == null) return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("DataBase connectivity Error")
                    .build();

            String query = "select * from powercutschedule";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String zone = rs.getString("zone");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String totalHours = rs.getString("totalHours");
                PowerCutSchedule powercutschedule = new PowerCutSchedule(zone, date, time, totalHours);
                powercutschedule.setId(id);
                powercutschedules.add(powercutschedule);

            }
            con.close();

        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(powercutschedules)
                .build();
    }

    public Response getPowerCutScheduleById(Integer powercutscheduleid) {
        PowerCutSchedule powercutschedule = null;

        try {
            Connection con = connection.getConnection();
            if (con == null) return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("DataBase connectivity Error")
                    .build();

            String query = "select * from powercutschedule where id = " + powercutscheduleid;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String zone = rs.getString("zone");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String totalHours = rs.getString("totalHours");
                powercutschedule = new PowerCutSchedule(zone, date, time, totalHours);
                powercutschedule.setId(id);
            }
            con.close();

        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(powercutschedule)
                .build();
    }

    public Response deletePowerCutSchedule(Integer powercutscheduleid) {
        try {
            Connection con = connection.getConnection();
            if (con == null) return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("DataBase connectivity Error")
                    .build();

            String query = "DELETE from powercutschedule WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, powercutscheduleid);

            preparedStmt.execute();
            con.close();

        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity("Power Cut Schedule deleted successfully")
                .build();
    }

    public Response updatePowerCutSchedule(PowerCutSchedule powercutschedule) {
        try
        {
            Connection con = connection.getConnection();
            if (con == null) return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("DataBase connectivity Error")
                    .build();

            String query = "UPDATE powercutschedule SET zone=?, date=?, time=?, totalHours=? WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, powercutschedule.getZone());
            preparedStmt.setString(2, powercutschedule.getDate());
            preparedStmt.setString(3, powercutschedule.getTime());
            preparedStmt.setString(4, powercutschedule.getTotalHours());
            preparedStmt.setInt(5, powercutschedule.getId());

            preparedStmt.execute();
            con.close();
        }
        catch (Exception e)
        {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while updating the Power Cut Schedule")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity(powercutschedule)
                .build();
    }

}
