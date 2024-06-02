package com.bluegravitystudio.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDto {
    @NotBlank(message = "email cannot be null")
    private String email;
    @NotBlank(message = "password cannot be null")
    private String password;

    public LoginUserDto() {
    }

    public LoginUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

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
}
