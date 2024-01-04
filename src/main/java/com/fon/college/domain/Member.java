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

    @OneToOne(mappedBy = "currentManager")
    private Department managerDepartment;

    @OneToOne(mappedBy = "currentSecretary")
    private Department secretaryDepartment;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentManagerHistory> managerHistories;

    @OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentSecretaryHistory> secretaryHistories;

    public Member() {
    }

    public Member(Long id,
                  String firstName,
                  String lastName,
                  Department department,
                  AcademicTitle academicTitle,
                  EducationTitle educationTitle,
                  ScientificField scientificField,
                  Set<DepartmentManagerHistory> managerHistories,
                  Set<DepartmentSecretaryHistory> secretaryHistories,
                  Department managerDepartment,
                  Department secretaryDepartment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.academicTitle = academicTitle;
        this.educationTitle = educationTitle;
        this.scientificField = scientificField;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
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
