package com.github.paf.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nic")
    private String nic;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "message")
    private String message;

    public Feedback(String nic, String category, String location, String message) {
        this.nic = nic;
        this.category = category;
        this.location = location;
        this.message = message;
    }

    public Feedback() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (id != feedback.id) return false;
        if (nic != null ? !nic.equals(feedback.nic) : feedback.nic != null) return false;
        if (category != null ? !category.equals(feedback.category) : feedback.category != null) return false;
        if (location != null ? !location.equals(feedback.location) : feedback.location != null) return false;
        if (message != null ? !message.equals(feedback.message) : feedback.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nic != null ? nic.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
