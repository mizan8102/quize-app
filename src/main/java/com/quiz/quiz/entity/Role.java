package com.quiz.quiz.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    public Role() {

    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "role") // lazy when we need then we call then it come
    private Set<UserRole> userRoles= new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;
}
