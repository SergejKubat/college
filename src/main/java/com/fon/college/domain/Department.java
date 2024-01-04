package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "short_name", unique = true, length = 50)
    private String shortName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_manager_id", referencedColumnName = "id")
    private Member currentManager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_secretary_id", referencedColumnName = "id")
    private Member currentSecretary;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentManagerHistory> managerHistories;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentSecretaryHistory> secretaryHistories;

    public Department() {
    }

    public Department(Long id,
                      String name,
                      String shortName,
                      Member currentManager,
                      Member currentSecretary,
                      Set<Subject> subjects,
                      Set<Member> members,
                      Set<DepartmentManagerHistory> managerHistories,
                      Set<DepartmentSecretaryHistory> secretaryHistories) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.currentManager = currentManager;
        this.currentSecretary = currentSecretary;
        this.subjects = subjects;
        this.members = members;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
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
        this.subjects = subjects;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<DepartmentManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(Set<DepartmentManagerHistory> managerHistories) {
        this.managerHistories = managerHistories;
    }

    public Set<DepartmentSecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(Set<DepartmentSecretaryHistory> secretaryHistories) {
        this.secretaryHistories = secretaryHistories;
    }
}
