package com.fon.college.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ManagerHistory> managerHistories;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SecretaryHistory> secretaryHistories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "academic_title_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AcademicTitle academicTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_title_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EducationTitle educationTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scientific_field_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ScientificField scientificField;

    @OneToOne(mappedBy = "member")
    private Department managerDepartment;

    @OneToOne(mappedBy = "member")
    private Department secretaryDepartment;

    public Member() {
    }

    public Member(Long id,
                  String firstName,
                  String lastName,
                  Set<ManagerHistory> managerHistories,
                  Set<SecretaryHistory> secretaryHistories,
                  Department department,
                  AcademicTitle academicTitle,
                  EducationTitle educationTitle,
                  ScientificField scientificField,
                  Department managerDepartment,
                  Department secretaryDepartment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
        this.department = department;
        this.academicTitle = academicTitle;
        this.educationTitle = educationTitle;
        this.scientificField = scientificField;
        this.managerDepartment = managerDepartment;
        this.secretaryDepartment = secretaryDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(AcademicTitle academicTitle) {
        this.academicTitle = academicTitle;
    }

    public EducationTitle getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(EducationTitle educationTitle) {
        this.educationTitle = educationTitle;
    }

    public ScientificField getScientificField() {
        return scientificField;
    }

    public void setScientificField(ScientificField scientificField) {
        this.scientificField = scientificField;
    }

    public Department getManagerDepartment() {
        return managerDepartment;
    }

    public void setManagerDepartment(Department managerDepartment) {
        this.managerDepartment = managerDepartment;
    }

    public Department getSecretaryDepartment() {
        return secretaryDepartment;
    }

    public void setSecretaryDepartment(Department secretaryDepartment) {
        this.secretaryDepartment = secretaryDepartment;
    }
}
