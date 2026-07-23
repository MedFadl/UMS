CREATE TABLE app_user
(
    id            BIGINT AUTO_INCREMENT  NOT NULL,
    email         VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    `role`        VARCHAR(255) NOT NULL,
    is_active     BIT(1)   DEFAULT 1 NULL,
    created_at    datetime DEFAULT NOW() NULL,
    CONSTRAINT pk_app_user PRIMARY KEY (id)
);

CREATE TABLE course
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    department_id BIGINT       NOT NULL,
    code          VARCHAR(50)  NOT NULL,
    name          VARCHAR(255) NOT NULL,
    credits       INT          NOT NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);

CREATE TABLE course_offering
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    course_id    BIGINT NOT NULL,
    semester_id  BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,
    capacity     INT    NOT NULL,
    CONSTRAINT pk_course_offering PRIMARY KEY (id)
);

CREATE TABLE department
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE enrollment
(
    id          BIGINT AUTO_INCREMENT  NOT NULL,
    student_id  BIGINT   NOT NULL,
    offering_id BIGINT   NOT NULL,
    status      LONGTEXT NOT NULL,
    final_grade FLOAT NULL,
    created_at  datetime DEFAULT NOW() NULL,
    CONSTRAINT pk_enrollment PRIMARY KEY (id)
);

CREATE TABLE major
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    department_id      BIGINT       NOT NULL,
    name               VARCHAR(255) NOT NULL,
    graduation_credits INT          NOT NULL,
    CONSTRAINT pk_major PRIMARY KEY (id)
);

CREATE TABLE semester
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    academic_year INT      NOT NULL,
    term          LONGTEXT NOT NULL,
    start_date    date NULL,
    end_date      date NULL,
    is_active     BIT(1) DEFAULT 0 NULL,
    CONSTRAINT pk_semester PRIMARY KEY (id)
);

CREATE TABLE staff
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    user_id         BIGINT       NOT NULL,
    employee_number VARCHAR(50)  NOT NULL,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    department_id   BIGINT NULL,
    CONSTRAINT pk_staff PRIMARY KEY (id)
);

CREATE TABLE student
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    user_id         BIGINT       NOT NULL,
    university_id   VARCHAR(50)  NOT NULL,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    enrollment_date date NULL,
    major_id        BIGINT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);