package com.portfolio.backend.payload.request;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank
    private String newuser;

    @NotBlank
    @Email
    private String newemail;

    private Set<String> role;

    @NotBlank
    private String newpassword;
}
