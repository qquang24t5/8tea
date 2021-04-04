package com.github.qquang24t5._8tea.transference;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
public class Employee {

    public Employee() {
        id = null;
        mobile = null;
        password = null;
        passwordHash = null;
        position = null;
        name = null;
        dateOfBirth = null;
        gender = null;
        disabled = null;
    }

    public Employee(Integer id, String mobile, String password, String passwordHash, Position position, String name, LocalDate dateOfBirth, Gender gender, Boolean disabled) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.passwordHash = passwordHash;
        this.position = position;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.disabled = disabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String mobile;

    @Transient
    private String password;

    @NotNull
    @Column(unique = true, nullable = false)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Position position;

    private String name;

    private LocalDate dateOfBirth;

    public enum Gender { MALE, FEMALE }
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private Boolean disabled;
}
