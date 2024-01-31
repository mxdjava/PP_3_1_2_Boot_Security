package ru.kata.spring.boot_security.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;


    //    @ManyToMany(mappedBy = "roles")
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

}