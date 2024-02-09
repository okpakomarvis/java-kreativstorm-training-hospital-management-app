package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HMS.USERS")
public class Users  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private String name;
    private String title;
    private String info;

    //@Column(nullable = true)
    @ManyToMany(targetEntity = Department.class)
    @JoinTable(
            name = "patient_department",
            joinColumns ={ @JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private List<Department> patiensDepartments;

    //@Column(nullable = true)
    @ManyToMany(targetEntity = Department.class)
    @JoinTable(
            name = "staff_department",
            joinColumns ={ @JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private List<Department> staffDepartments;

    //return list of authorities granted or roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
