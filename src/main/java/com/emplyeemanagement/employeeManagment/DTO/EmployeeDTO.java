package com.emplyeemanagement.employeeManagment.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private long id;

    private String firstName;

    private String lastName;

    private String emailId;
}
