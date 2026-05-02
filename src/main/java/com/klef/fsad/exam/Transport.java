package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    private String type;
    private double cost;

    // Default Constructor ṁ
    public Transport() {}

    // Parameterized Constructor
    public Transport(String name, Date date, String status, String type, double cost) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.type = type;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}