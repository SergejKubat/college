package com.fon.college.component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        Department department1 = _departmentRepository.save(new Department(null, "Department 1",
                "Dept 1"));
        Department department2 = _departmentRepository.save(new Department(null, "Department 2",
                "Dept 2"));

        // seed subjects
        _subjectRepository.save(new Subject(null, "Subject 1", 6, department1));
        _subjectRepository.save(new Subject(null, "Subject 2", 8, department1));
        _subjectRepository.save(new Subject(null, "Subject 3", 6, department2));
        _subjectRepository.save(new Subject(null, "Subject 4", 8, department2));

        // seed academic titles
        AcademicTitle academicTitle1 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 1"));
        AcademicTitle academicTitle2 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 2"));
        AcademicTitle academicTitle3 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 3"));
        AcademicTitle academicTitle4 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 4"));
        AcademicTitle academicTitle5 = _academicTitleRepository.save(new AcademicTitle(null, "Academic title 5"));

        // seed education titles
        EducationTitle educationTitle1 = _educationTitleRepository.save(new EducationTitle(null, "Education title 1"));
        EducationTitle educationTitle2 = _educationTitleRepository.save(new EducationTitle(null, "Education title 2"));
        EducationTitle educationTitle3 = _educationTitleRepository.save(new EducationTitle(null, "Education title 3"));
        EducationTitle educationTitle4 = _educationTitleRepository.save(new EducationTitle(null, "Education title 4"));
        EducationTitle educationTitle5 = _educationTitleRepository.save(new EducationTitle(null, "Education title 5"));

        // seed scientific fields
        ScientificField scientificField1 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 1"));
        ScientificField scientificField2 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 2"));
        ScientificField scientificField3 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 3"));
        ScientificField scientificField4 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 4"));
        ScientificField scientificField5 = _scientificFieldRepository.save(new ScientificField(null, "Scientific field 5"));

        // seed members
        Member member1 = _memberRepository.save(new Member(null, "John", "Doe", department1,
                academicTitle1, educationTitle1, scientificField2));
        Member member2 = _memberRepository.save(new Member(null, "Angel", "Higgins", department1,
                academicTitle2, educationTitle1, scientificField2));
        Member member3 = _memberRepository.save(new Member(null, "Dylan", "Johnson", department1,
                academicTitle1, educationTitle2, scientificField3));
        Member member4 = _memberRepository.save(new Member(null, "Luke", "Walsh", department1,
                academicTitle3, educationTitle3, scientificField1));
        Member member5 = _memberRepository.save(new Member(null, "Lena", "Robles", department2,
                academicTitle4, educationTitle4, scientificField5));
        Member member6 = _memberRepository.save(new Member(null, "Dennis", "Weeks", department2,
                academicTitle1, educationTitle4, scientificField3));
        Member member7 = _memberRepository.save(new Member(null, "Alexander", "Gallegos", department2,
                academicTitle3, educationTitle5, scientificField1));
        Member member8 = _memberRepository.save(new Member(null, "Juliana", "Gibson", department2,
                academicTitle5, educationTitle2, scientificField4));

        // seed academic title history
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member1, academicTitle1, scientificField2,
                new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member2, academicTitle2, scientificField2,
                new GregorianCalendar(2019, Calendar.APRIL, 2).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member3, academicTitle1, scientificField3,
                new GregorianCalendar(2017, Calendar.AUGUST, 24).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member4, academicTitle3, scientificField1,
                new GregorianCalendar(2022, Calendar.JULY, 16).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member5, academicTitle4, scientificField5,
                new GregorianCalendar(2021, Calendar.JANUARY, 28).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member6, academicTitle1, scientificField3,
                new GregorianCalendar(2020, Calendar.OCTOBER, 9).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member7, academicTitle3, scientificField1,
                new GregorianCalendar(2019, Calendar.MARCH, 14).getTime(), null));
        _academicTitleHistoryRepository.save(new AcademicTitleHistory(null, member8, academicTitle5, scientificField4,
                new GregorianCalendar(2021, Calendar.MAY, 5).getTime(), null));

        // set department's manager and secretary
        department1.setCurrentManager(member1);
        department1.setCurrentSecretary(member2);

        _departmentRepository.save(department1);

        department2.setCurrentManager(member5);
        department2.setCurrentSecretary(member6);

        _departmentRepository.save(department2);

        // seed department manager history
        _departmentManagerHistoryRepository.save(new DepartmentManagerHistory(null, member1, department1,
                new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime(), null));
        _departmentManagerHistoryRepository.save(new DepartmentManagerHistory(null, member5, department2,
                new GregorianCalendar(2019, Calendar.JUNE, 19).getTime(), null));

        // seed department secretary history
        _departmentSecretaryHistoryRepository.save(new DepartmentSecretaryHistory(null, member2, department1,
                new GregorianCalendar(2023, Calendar.DECEMBER, 25).getTime(), null));
        _departmentSecretaryHistoryRepository.save(new DepartmentSecretaryHistory(null, member6, department2,
                new GregorianCalendar(2022, Calendar.JANUARY, 8).getTime(), null));
    }
}
