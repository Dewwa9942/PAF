package com.github.paf.model;

import jakarta.persistence.*;

@Entity
public class PowerCutSchedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "zone")
    private String zone;
    @Basic
    @Column(name = "date")
    private String date;
    @Basic
    @Column(name = "time")
    private String time;
    @Basic
    @Column(name = "totalHours")
    private String totalHours;

    public PowerCutSchedule(String zone, String date, String time, String totalHours) {
        this.zone = zone;
        this.date = date;
        this.time= time;
        this.totalHours = totalHours;
    }

    public PowerCutSchedule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PowerCutSchedule powercutschedule = (PowerCutSchedule) o;

        if (id != powercutschedule.id) return false;
        if (zone != null ? !zone.equals(powercutschedule.zone) : powercutschedule.zone != null) return false;
        if (date != null ? !date.equals(powercutschedule.date) : powercutschedule.date != null) return false;
        if (time != null ? !date.equals(powercutschedule.time) : powercutschedule.time != null) return false;
        if (totalHours != null ? !totalHours.equals(powercutschedule.totalHours) : powercutschedule.totalHours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (totalHours != null ? totalHours.hashCode() : 0);
        return result;
    }
}

