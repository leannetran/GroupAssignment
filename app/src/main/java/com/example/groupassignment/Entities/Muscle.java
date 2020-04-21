package com.example.groupassignment.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Muscle implements Serializable
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
    private final static long serialVersionUID = -1745620041856427879L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Muscle() {
    }

    /**
     *
     * @param next
     * @param previous
     * @param count
     * @param results
     */
    public Muscle(int count, Object next, Object previous, List<Result> results) {
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

    public Muscle withCount(int count) {
        this.count = count;
        return this;
    }

    public Object getNext() {

        return next;
    }

    public void setNext(Object next) {

        this.next = next;
    }

    public Muscle withNext(Object next) {
        this.next = next;
        return this;
    }

    public Object getPrevious() {

        return previous;
    }

    public void setPrevious(Object previous) {

        this.previous = previous;
    }

    public Muscle withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    public List<Result> getResults() {

        return results;
    }

    public void setResults(List<Result> results) {

        this.results = results;
    }

    public Muscle withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}