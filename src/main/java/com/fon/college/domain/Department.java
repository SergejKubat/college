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

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ManagerHistory> managerHistories;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SecretaryHistory> secretaryHistories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Member manager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secretary_id", referencedColumnName = "id")
    private Member secretary;

    public Department() {
    }

    public Department(Long id,
                      String name,
                      String shortName,
                      Set<Subject> subjects,
                      Set<Member> members,
                      Set<ManagerHistory> managerHistories,
                      Set<SecretaryHistory> secretaryHistories,
                      Member manager,
                      Member secretary) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.subjects = subjects;
        this.members = members;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
        this.manager = manager;
        this.secretary = secretary;
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

    public Member getManager() {
        return manager;
    }

    public void setManager(Member manager) {
        this.manager = manager;
    }

    public Member getSecretary() {
        return secretary;
    }

    public void setSecretary(Member secretary) {
        this.secretary = secretary;
    }

    public Set<ManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(Set<ManagerHistory> managerHistories) {
        this.managerHistories = managerHistories;
    }

    public Set<SecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(Set<SecretaryHistory> secretaryHistories) {
        this.secretaryHistories = secretaryHistories;
    }
}
