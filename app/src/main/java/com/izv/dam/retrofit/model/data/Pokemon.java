package com.izv.dam.retrofit.model.data;

public class Pokemon {

    private long id;
    private String name;
    private long idtype;
    private float height;
    private float weight;
    private String ability;

    public long getId() {
        return id;
    }

    public Pokemon setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pokemon setName(String name) {
        this.name = name;
        return this;
    }

    public long getIdtype() {
        return idtype;
    }

    public Pokemon setIdtype(long idtype) {
        this.idtype = idtype;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public Pokemon setHeight(float height) {
        this.height = height;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public Pokemon setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public String getAbility() {
        return ability;
    }

    public Pokemon setAbility(String ability) {
        this.ability = ability;
        return this;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idtype=" + idtype +
                ", height=" + height +
                ", weight=" + weight +
                ", ability='" + ability + '\'' +
                '}';
    }
}
