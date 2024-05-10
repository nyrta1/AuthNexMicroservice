package com.nyrta1.authservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 4, max = 35,
            message = "The length of the username must be at least 8 characters and no more than 35 characters")
    private String name;

    @Column(nullable = false)
    @Size(min = 4, max = 35,
            message = "The length of the username must be at least 8 characters and no more than 35 characters")
    private String surname;

    @Column(unique = true,
            nullable = false)
    @Size(min = 4, max = 35,
            message = "The length of the username must be at least 8 characters and no more than 35 characters")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,
            nullable = false)
    @Size(min = 4, max = 35,
            message = "The length of the username must be at least 8 characters and no more than 35 characters")
    private String email;

    @Column(nullable = false)
    private boolean emailVerified = false;

    private LocalDateTime emailConfirmedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();
}
