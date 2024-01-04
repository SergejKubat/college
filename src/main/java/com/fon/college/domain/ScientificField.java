package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "scientific_field", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    public ScientificField() {
    }

    public ScientificField(Long id, String name, Set<Member> members) {
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
