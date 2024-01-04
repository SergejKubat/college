package com.fon.college.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "education_title")
public class EducationTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @OneToMany(mappedBy = "educationTitle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Member> members;

    public EducationTitle() {
    }

    public EducationTitle(Long id, String title, Set<Member> members) {
        this.id = id;
        this.title = title;
        this.members = members;
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
}
