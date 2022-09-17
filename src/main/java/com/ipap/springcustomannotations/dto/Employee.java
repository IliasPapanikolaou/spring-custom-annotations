package com.ipap.springcustomannotations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ipap.springcustomannotations.validation.ValidateEmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    // It should be auto generated
    private int empId;

    @NotBlank(message = "firstName shouldn't be null or empty")
    private String firstName;

    @NotBlank(message = "lastName shouldn't be null or empty")
    private String lastName;

    @Past(message = "start shouldn't be before current date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date doj;

    @NotNull(message = "department shouldn't be null")
    @NotEmpty(message = "firstName shouldn't be null or empty")
    private String dept;

    @Email(message = "invalid email format")
    private String email;

    // Custom validator annotation
    @ValidateEmployeeType
    private String employeeType;
}
