package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field", length = 100)
    private String field;

    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcademicTitleHistory> academicTitleHistories;

    public ScientificField() {
    }

    public ScientificField(Long id, String field, Set<Member> members, Set<AcademicTitleHistory> academicTitleHistories) {
        this.id = id;
        this.field = field;
        this.members = members;
        this.academicTitleHistories = academicTitleHistories;
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
        this.members = members;
    }

    public Set<AcademicTitleHistory> getAcademicTitleHistories() {
        return academicTitleHistories;
    }

    public void setAcademicTitleHistories(Set<AcademicTitleHistory> academicTitleHistories) {
        this.academicTitleHistories = academicTitleHistories;
    }
}
