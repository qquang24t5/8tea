package com.github.qquang24t5._8tea.transference;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
public class Employee {
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
