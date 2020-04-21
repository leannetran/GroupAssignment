package com.example.groupassignment.Entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_front")
    @Expose
    private boolean isFront;
    private final static long serialVersionUID = 6527828862509597338L;

    /**
     * No args constructor for use in serialization
     */
    public Result() {
    }

    /**
     * @param isFront
     * @param name
     * @param id
     */
    public Result(int id, String name, boolean isFront) {
        super();
        this.id = id;
        this.name = name;
        this.isFront = isFront;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result withName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getIsFront() {
        return isFront;
    }

    public void setIsFront(Boolean isFront) {
        this.isFront = isFront;
    }

    public Result withIsFront(Boolean isFront) {
        this.isFront = isFront;
        return this;
    }
}