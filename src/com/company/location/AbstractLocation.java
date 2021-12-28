package com.company.location;

import java.util.Objects;

public abstract class AbstractLocation {
    private LocationTypes type;

    public AbstractLocation(LocationTypes type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if(getClass()!=o.getClass()){return false;}
        AbstractLocation that = (AbstractLocation) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "Локация " + type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public LocationTypes getType() {
        return type;
    }

    public void setType(LocationTypes type) {
        this.type = type;
    }

}