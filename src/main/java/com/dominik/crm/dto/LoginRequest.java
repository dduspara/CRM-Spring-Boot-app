package com.dominik.crm.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Username je obavezan.")
    private String username;
    @NotBlank(message = "Password je obavezan.")
    private String password;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
