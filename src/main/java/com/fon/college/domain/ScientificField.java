package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Member> members = new HashSet<>();
    @OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<AcademicTitleHistory> academicTitleHistories = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "field", length = 100)
    private String field;

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
