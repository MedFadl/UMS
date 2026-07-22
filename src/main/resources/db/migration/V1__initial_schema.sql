
CREATE TABLE app_user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password_hash VARCHAR(255) NOT NULL,
                          role ENUM('Student', 'Professor', 'Admin') NOT NULL,
                          is_active BOOLEAN DEFAULT TRUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE department (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE major (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       department_id BIGINT NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       graduation_credits INT NOT NULL,
                       CONSTRAINT fk_major_department FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        department_id BIGINT NOT NULL,
                        code VARCHAR(50) NOT NULL UNIQUE,
                        name VARCHAR(255) NOT NULL,
                        credits INT NOT NULL,
                        CONSTRAINT fk_course_department FOREIGN KEY (department_id) REFERENCES department(id)
);


CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT NOT NULL UNIQUE,
                         university_id VARCHAR(50) NOT NULL UNIQUE,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         enrollment_date DATE,
                         major_id BIGINT,
                         CONSTRAINT fk_student_user FOREIGN KEY (user_id) REFERENCES app_user(id),
                         CONSTRAINT fk_student_major FOREIGN KEY (major_id) REFERENCES major(id)
);

CREATE TABLE staff (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_id BIGINT NOT NULL UNIQUE,
                       employee_number VARCHAR(50) NOT NULL UNIQUE,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,
                       department_id BIGINT,
                       CONSTRAINT fk_staff_user FOREIGN KEY (user_id) REFERENCES app_user(id),
                       CONSTRAINT fk_staff_department FOREIGN KEY (department_id) REFERENCES department(id)
);


CREATE TABLE semester (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          academic_year INT NOT NULL,
                          term ENUM('Fall', 'Winter', 'Spring', 'Summer') NOT NULL,
                          start_date DATE,
                          end_date DATE,
                          is_active BOOLEAN DEFAULT FALSE,
                          CONSTRAINT uk_semester UNIQUE (academic_year, term)
);

CREATE TABLE course_offering (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 course_id BIGINT NOT NULL,
                                 semester_id BIGINT NOT NULL,
                                 professor_id BIGINT NOT NULL,
                                 capacity INT NOT NULL,
                                 CONSTRAINT fk_offering_course FOREIGN KEY (course_id) REFERENCES course(id),
                                 CONSTRAINT fk_offering_semester FOREIGN KEY (semester_id) REFERENCES semester(id),
                                 CONSTRAINT fk_offering_professor FOREIGN KEY (professor_id) REFERENCES staff(id)
);

CREATE TABLE enrollment (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            student_id BIGINT NOT NULL,
                            offering_id BIGINT NOT NULL,
                            status ENUM('Registered', 'Dropped', 'Completed') NOT NULL,
                            final_grade FLOAT,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            CONSTRAINT fk_enrollment_student FOREIGN KEY (student_id) REFERENCES student(id),
                            CONSTRAINT fk_enrollment_offering FOREIGN KEY (offering_id) REFERENCES course_offering(id),
                            CONSTRAINT uk_student_offering UNIQUE (student_id, offering_id)
);