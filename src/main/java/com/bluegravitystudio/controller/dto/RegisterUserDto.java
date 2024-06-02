package com.bluegravitystudio.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterUserDto {
    @NotBlank(message = "email cannot be null")
    private String email;
    @NotBlank(message = "password cannot be null")
    private String password;
    @NotBlank(message = "fullName cannot be null")
    private String fullName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
