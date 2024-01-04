package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "education_title")
public class EducationTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "education_title", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    public EducationTitle() {
    }

    public EducationTitle(Long id, String name, Set<Member> members) {
        this.id = id;
        this.name = name;
        this.members = members;
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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
