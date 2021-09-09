package com.whitebear.web.request;

import com.whitebear.common.validation.EmailValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotBlank(message = "EMAIL NOT BLANK")
    @Email(message = "EMAIL INVALID")
    @EmailValid(message = "EMAIL EXISTS!")
    private String email;

    @NotBlank(message = "PASSWORD NOT BLANK")
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank(message = "USENAME NOT BLANK")
    private String username;
}
