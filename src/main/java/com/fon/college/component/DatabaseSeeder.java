package com.fon.college.component;

import com.fon.college.domain.*;
import com.fon.college.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final DepartmentRepository _departmentRepository;
    private final SubjectRepository _subjectRepository;
    private final MemberRepository _memberRepository;
    private final AcademicTitleRepository _academicTitleRepository;
    private final EducationTitleRepository _educationTitleRepository;
    private final ScientificFieldRepository _scientificFieldRepository;
    private final AcademicTitleHistoryRepository _AcademicTitleHistoryRepository;
    private final DepartmentManagerHistoryRepository _DepartmentManagerHistoryRepository;
    private final DepartmentSecretaryHistoryRepository _DepartmentSecretaryHistoryRepository;

    public DatabaseSeeder(DepartmentRepository departmentRepository,
                          SubjectRepository subjectRepository,
                          MemberRepository memberRepository,
                          AcademicTitleRepository academicTitleRepository,
                          EducationTitleRepository educationTitleRepository,
                          ScientificFieldRepository scientificFieldRepository,
                          AcademicTitleHistoryRepository AcademicTitleHistoryRepository,
                          DepartmentManagerHistoryRepository DepartmentManagerHistoryRepository,
                          DepartmentSecretaryHistoryRepository DepartmentSecretaryHistoryRepository) {
        _departmentRepository = departmentRepository;
        _subjectRepository = subjectRepository;
        _memberRepository = memberRepository;
        _academicTitleRepository = academicTitleRepository;
        _educationTitleRepository = educationTitleRepository;
        _scientificFieldRepository = scientificFieldRepository;
        _AcademicTitleHistoryRepository = AcademicTitleHistoryRepository;
        _DepartmentManagerHistoryRepository = DepartmentManagerHistoryRepository;
        _DepartmentSecretaryHistoryRepository = DepartmentSecretaryHistoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // seed academic titles
        AcademicTitle academicTitle1 = new AcademicTitle();
        AcademicTitle academicTitle2 = new AcademicTitle();

        academicTitle1.setTitle("Academic title 1");
        academicTitle2.setTitle("Academic title 2");

        _academicTitleRepository.save(academicTitle1);
        _academicTitleRepository.save(academicTitle2);

        // seed education titles
        EducationTitle educationTitle1 = new EducationTitle();
        EducationTitle educationTitle2 = new EducationTitle();

        educationTitle1.setTitle("Education title 1");
        educationTitle2.setTitle("Education title 2");

        _educationTitleRepository.save(educationTitle1);
        _educationTitleRepository.save(educationTitle2);

        // seed scientific fields
        ScientificField scientificField1 = new ScientificField();
        ScientificField scientificField2 = new ScientificField();

        scientificField1.setField("Scientific field 1");
        scientificField2.setField("Scientific field 2");

        _scientificFieldRepository.save(scientificField1);
        _scientificFieldRepository.save(scientificField2);

//        // seed members
//        Member member1 = new Member();
//        Member member2 = new Member();
//
//        member1.setFirstName("John");
//        member1.setLastName("Doe");
//        member1.setAcademicTitle(academicTitle1);
//        member1.setEducationTitle(educationTitle1);
//        member1.setScientificField(scientificField1);
//
//        member2.setFirstName("Angel");
//        member2.setLastName("Higgins");
//        member2.setAcademicTitle(academicTitle2);
//        member2.setEducationTitle(educationTitle2);
//        member2.setScientificField(scientificField2);
//
//        // seed department
//        Department department = new Department();
//
//        department.setName("Department 1");
//        department.setShortName("Dept 1");
//        department.setCurrentManager(member1);
//        department.setCurrentSecretary(member2);
//
//        member1.setDepartment(department);
//        member2.setDepartment(department);
//
//        _memberRepository.save(member1);
//        _memberRepository.save(member2);
//
//        _departmentRepository.save(department);
    }
}
