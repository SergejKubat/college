package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Subject> subjects = new HashSet<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Member> members = new HashSet<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<DepartmentManagerHistory> managerHistories = new HashSet<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<DepartmentSecretaryHistory> secretaryHistories = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "short_name", length = 50)
    private String shortName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "current_manager_id", referencedColumnName = "id")
    private Member currentManager;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "current_secretary_id", referencedColumnName = "id")
    private Member currentSecretary;

    public Department() {
    }

    public Department(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Member getCurrentManager() {
        return currentManager;
    }

    public void setCurrentManager(Member currentManager) {
        this.currentManager = currentManager;
    }

    public Member getCurrentSecretary() {
        return currentSecretary;
    }

    public void setCurrentSecretary(Member currentSecretary) {
        this.currentSecretary = currentSecretary;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members.addAll(members);
    }

    public Set<DepartmentManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(Set<DepartmentManagerHistory> managerHistories) {
        this.managerHistories.addAll(managerHistories);
    }

    public Set<DepartmentSecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(Set<DepartmentSecretaryHistory> secretaryHistories) {
        this.secretaryHistories.addAll(secretaryHistories);
    }
}
