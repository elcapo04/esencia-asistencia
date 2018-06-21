package com.esencia.esencia.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    FILE("file");

    private String type;

    private Type(String type) {
        this.type = type;
    }

    @JsonValue
    public String value() {
        return this.type;
    }
}
