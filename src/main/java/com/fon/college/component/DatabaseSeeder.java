package com.fon.college.component;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fon.college.domain.*;
import com.fon.college.repository.*;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final DepartmentRepository _departmentRepository;
    private final SubjectRepository _subjectRepository;
    private final MemberRepository _memberRepository;
    private final AcademicTitleRepository _academicTitleRepository;
    private final EducationTitleRepository _educationTitleRepository;
    private final ScientificFieldRepository _scientificFieldRepository;
    private final AcademicTitleHistoryRepository _academicTitleHistoryRepository;
    private final DepartmentManagerHistoryRepository _departmentManagerHistoryRepository;
    private final DepartmentSecretaryHistoryRepository _departmentSecretaryHistoryRepository;

    public DatabaseSeeder(DepartmentRepository departmentRepository,
                          SubjectRepository subjectRepository,
                          MemberRepository memberRepository,
                          AcademicTitleRepository academicTitleRepository,
                          EducationTitleRepository educationTitleRepository,
                          ScientificFieldRepository scientificFieldRepository,
                          AcademicTitleHistoryRepository academicTitleHistoryRepository,
                          DepartmentManagerHistoryRepository departmentManagerHistoryRepository,
                          DepartmentSecretaryHistoryRepository departmentSecretaryHistoryRepository) {
        _departmentRepository = departmentRepository;
        _subjectRepository = subjectRepository;
        _memberRepository = memberRepository;
        _academicTitleRepository = academicTitleRepository;
        _educationTitleRepository = educationTitleRepository;
        _scientificFieldRepository = scientificFieldRepository;
        _academicTitleHistoryRepository = academicTitleHistoryRepository;
        _departmentManagerHistoryRepository = departmentManagerHistoryRepository;
        _departmentSecretaryHistoryRepository = departmentSecretaryHistoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // seed department
        Department department = _departmentRepository.save(new Department(null, "Department 1",
                "Dept 1"));

        // seed subjects
        _subjectRepository.save(new Subject(null, "Subject 1", 6, department));
        _subjectRepository.save(new Subject(null, "Subject 2", 8, department));

        // seed academic titles
        AcademicTitle academicTitle1 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 1"));
        AcademicTitle academicTitle2 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 2"));

        // seed education titles
        EducationTitle educationTitle1 = _educationTitleRepository.save(new EducationTitle(null, "Education title 1"));
        EducationTitle educationTitle2 = _educationTitleRepository.save(new EducationTitle(null, "Education title 2"));

        // seed scientific fields
        ScientificField scientificField1 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 1"));
        ScientificField scientificField2 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 1"));

        // seed members
        Member member1 = _memberRepository.save(new Member(null, "John", "Doe", department,
                academicTitle1, educationTitle1, scientificField1));
        Member member2 = _memberRepository.save(new Member(null, "Angel", "Higgins", department,
                academicTitle2, educationTitle2, scientificField2));

        // seed academic title history
        Date currentDate = new Date();

        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member1, academicTitle1,
                scientificField1, currentDate, null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member2, academicTitle2,
                scientificField2, currentDate, null));

        // set department's manager and secretary

        department.setCurrentManager(member1);
        department.setCurrentSecretary(member2);

        _departmentRepository.save(department);

        // seed department manager history
        _departmentManagerHistoryRepository.save(new DepartmentManagerHistory(null, member1, department,
                currentDate, null));

        // seed department secretary history
        _departmentSecretaryHistoryRepository.save(new DepartmentSecretaryHistory(null, member2, department,
                currentDate, null));
    }
}
