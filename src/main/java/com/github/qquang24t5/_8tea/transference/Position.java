package com.github.qquang24t5._8tea.transference;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
public class Position {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Employee> employees;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Permission_Position",
            joinColumns = {@JoinColumn(name = "position")},
            inverseJoinColumns = {@JoinColumn(name = "permission")})
    @ToString.Exclude
    private List<Permission> permissions;

    @NotNull
    private Boolean disabled;
}
