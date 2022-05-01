package com.github.paf.model;

import jakarta.persistence.*;

@Entity
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "month")
    private String month;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "date")
    private String date;
    @Basic
    @Column(name = "method")
    private String method;

    public Payment(String month, String price, String date, String method) {
        this.month = month;
        this.price = price;
        this.date = date;
        this.method = method;
    }

    public Payment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != payment.id) return false;
        if (month != null ? !month.equals(payment.month) : payment.month != null) return false;
        if (price != null ? !price.equals(payment.price) : payment.price != null) return false;
        if (date != null ? !date.equals(payment.date) : payment.date != null) return false;
        if (method != null ? !method.equals(payment.method) : payment.method != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }
}
