package com.example.StudentCrud.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String timeAndDate;
    private int weight;
    private String body_measurements;
    private int heartRate;

    public Student() {

    }
    public Student(Long id, String name, String timeAndDate,int weight,String body_measurements,int heartRate) {

        this.id = id;
        this.name = name;
        this.timeAndDate = timeAndDate;
        this.weight=weight;
        this.body_measurements= body_measurements;
        this.heartRate=heartRate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(String timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBody_measurements() {
        return body_measurements;
    }

    public void setBody_measurements(String body_measurements) {
        this.body_measurements = body_measurements;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
}
