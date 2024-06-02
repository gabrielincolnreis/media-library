package com.bluegravitystudio.config.validation;

public class ErroFormDto {
    private String field;
    private String error;

    public ErroFormDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
