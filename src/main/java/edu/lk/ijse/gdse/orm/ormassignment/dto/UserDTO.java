package edu.lk.ijse.gdse.orm.ormassignment.dto;

import edu.lk.ijse.gdse.orm.ormassignment.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO {

    private int id;

    private String username;
    private String password;

    private String role;




}
