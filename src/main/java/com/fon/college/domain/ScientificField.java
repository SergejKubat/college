package com.fon.college.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field", length = 100)
    private String field;

    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Member> members = new HashSet<>();

    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<AcademicTitleHistory> academicTitleHistories = new HashSet<>();

    public ScientificField() {
    }

    public ScientificField(Long id, String field) {
        this.id = id;
        this.field = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members.addAll(members);
    }

    public Set<AcademicTitleHistory> getAcademicTitleHistories() {
        return academicTitleHistories;
    }

    public void setAcademicTitleHistories(Set<AcademicTitleHistory> academicTitleHistories) {
        this.academicTitleHistories.addAll(academicTitleHistories);
    }
}
