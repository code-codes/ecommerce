package com.ecommerce.ecommerce.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer roleId;

    //Enum is by default stored as an integer (ordinal) in the database. To store it as a string, we use @Enumerated(EnumType.STRING)
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(length = 20, name="role_name")
    private AppRole roleName;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }
}
