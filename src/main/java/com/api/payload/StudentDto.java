package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentDto {
    @NotEmpty
    @Size(min = 2, message = "should be 2 character")
    private String name;
    @Email
    private String email;
    @Size(min = 10, max = 10, message = "mobile should be 10 digit")
    private String mobile;

}