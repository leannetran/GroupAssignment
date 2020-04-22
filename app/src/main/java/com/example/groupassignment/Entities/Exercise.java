package com.example.groupassignment.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exercise implements Serializable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    private final static long serialVersionUID = 4627459112500958928L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Exercise() {
    }

    /**
     *
     * @param next
     * @param previous
     * @param count
     * @param results
     */
    public Exercise(int count, Object next, Object previous, List<Result> results) {
        super();
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Exercise withCount(int count) {
        this.count = count;
        return this;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Exercise withNext(Object next) {
        this.next = next;
        return this;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Exercise withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Exercise withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}