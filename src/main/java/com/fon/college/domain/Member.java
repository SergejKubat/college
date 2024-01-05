package com.fon.college.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

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
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "academic_title_id", nullable = false)
    private AcademicTitle academicTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_title_id", nullable = false)
    private EducationTitle educationTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scientific_field_id", nullable = false)
    private ScientificField scientificField;

    @OneToOne(mappedBy = "currentManager", fetch = FetchType.LAZY)
    private Department managerDepartment;

    @OneToOne(mappedBy = "currentSecretary", fetch = FetchType.LAZY)
    private Department secretaryDepartment;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<AcademicTitleHistory> academicTitleHistories = new HashSet<>();

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<DepartmentManagerHistory> managerHistories = new HashSet<>();

    @OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<DepartmentSecretaryHistory> secretaryHistories = new HashSet<>();

    public Member() {
    }

    public Member(Long id,
                  String firstName,
                  String lastName,
                  Department department,
                  AcademicTitle academicTitle,
                  EducationTitle educationTitle,
                  ScientificField scientificField) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.academicTitle = academicTitle;
        this.educationTitle = educationTitle;
        this.scientificField = scientificField;
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

    public Set<AcademicTitleHistory> getAcademicTitleHistories() {
        return academicTitleHistories;
    }

    public void setAcademicTitleHistories(Set<AcademicTitleHistory> academicTitleHistories) {
        this.academicTitleHistories.addAll(academicTitleHistories);
    }

    public Set<DepartmentManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(Set<DepartmentManagerHistory> managerHistories) {
        this.managerHistories.addAll(managerHistories);
    }

    public Set<DepartmentSecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(Set<DepartmentSecretaryHistory> secretaryHistories) {
        this.secretaryHistories.addAll(secretaryHistories);
    }
}
