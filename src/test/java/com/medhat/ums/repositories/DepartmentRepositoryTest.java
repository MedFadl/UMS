package com.medhat.ums.repositories;

import com.medhat.ums.entities.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void shouldSaveAndFindDepartment(){
        Department department = Department.builder()
                .name("Computer Science")
                .build();

        Department savedDepartment = departmentRepository.save(department);

        assertThat(savedDepartment.getId()).isNotNull();
        assertThat(savedDepartment.getName()).isEqualTo("Computer Science");

        Department foundDepartment = departmentRepository.findById(savedDepartment.getId()).orElse(null);

        assertThat(foundDepartment).isNotNull();
        assertThat(foundDepartment.getName()).isEqualTo("Computer Science");


    }


}
