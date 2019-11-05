package com.izv.dam.retrofit.model.data;

public class Type {

    private long id;
    private String type;

    public Type() {
        this(0,"");
    }

    public Type(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public Type setId(long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Type setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}