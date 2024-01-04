package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "academic_title")
public class AcademicTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @OneToMany(mappedBy = "academicTitle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    @OneToMany(mappedBy = "academicTitle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcademicTitleHistory> academicTitleHistories;

    public AcademicTitle() {
    }

    public AcademicTitle(Long id, String title, Set<Member> members, Set<AcademicTitleHistory> academicTitleHistories) {
        this.id = id;
        this.title = title;
        this.members = members;
        this.academicTitleHistories = academicTitleHistories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
