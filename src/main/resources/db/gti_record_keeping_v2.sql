-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gti_record_keeping_v2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gti_record_keeping_v2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gti_record_keeping_v2` ;
USE `gti_record_keeping_v2` ;

-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`city` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`city` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(50) NULL,
  `county` VARCHAR(50) NULL,
  PRIMARY KEY (`city_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`address` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `address_line_1` VARCHAR(100) NULL,
  `address_line_2` VARCHAR(100) NULL,
  `eir_code` VARCHAR(10) NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_address_city_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_city`
    FOREIGN KEY (`city_id`)
    REFERENCES `gti_record_keeping_v2`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`gender` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT,
  `gender` VARCHAR(40) NULL,
  PRIMARY KEY (`gender_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`teacher` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`teacher` (
  `teacher_id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `gender_id` INT NOT NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `ppsn` VARCHAR(20) NULL,
  `phone_number` VARCHAR(50) NULL,
  `date_of_birth` VARCHAR(45) NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `fk_teacher_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_teacher_gender1_idx` (`gender_id` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gti_record_keeping_v2`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping_v2`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`student` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `gender_id` INT NOT NULL,
  `student_code` VARCHAR(50) NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `ppsn` VARCHAR(20) NULL,
  `phone_number` VARCHAR(50) NULL,
  `date_of_birth` VARCHAR(45) NULL,
  PRIMARY KEY (`student_id`),
  INDEX `fk_student_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_student_gender1_idx` (`gender_id` ASC) VISIBLE,
  UNIQUE INDEX `student_code_UNIQUE` (`student_code` ASC) VISIBLE,
  CONSTRAINT `fk_student_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gti_record_keeping_v2`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping_v2`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`department` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`department` (
  `department_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(80) NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
COMMENT = 'Department:\n- Sports\n- IT & Computing\n- Media\n- Fashion\netc etc';


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`course_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`course_type` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`course_type` (
  `course_type_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`course_type_id`))
ENGINE = InnoDB
COMMENT = 'Course Type:\nPart time\nFull time';


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`course` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `department_id` INT NOT NULL,
  `course_type_id` INT NOT NULL,
  `course_code` VARCHAR(45) NULL,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(100) NULL,
  `certification` INT NULL,
  `fee` VARCHAR(45) NULL,
  PRIMARY KEY (`course_id`),
  INDEX `fk_course_course_category1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_course_course_type1_idx` (`course_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `gti_record_keeping_v2`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_course_type1`
    FOREIGN KEY (`course_type_id`)
    REFERENCES `gti_record_keeping_v2`.`course_type` (`course_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`subject` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `subject_code` VARCHAR(40) NULL,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(80) NULL,
  PRIMARY KEY (`subject_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`role` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_code` VARCHAR(45) NULL,
  `role_description` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`admin` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `gender_id` INT NOT NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `ppsn` VARCHAR(45) NULL,
  PRIMARY KEY (`admin_id`),
  INDEX `fk_admin_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_admin_gender1_idx` (`gender_id` ASC) VISIBLE,
  CONSTRAINT `fk_admin_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gti_record_keeping_v2`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admin_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping_v2`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`user` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `teacher_id` INT NULL,
  `student_id` INT NULL,
  `admin_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_teacher1_idx` (`teacher_id` ASC) VISIBLE,
  INDEX `fk_user_student1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_user_role1_idx` (`role_id` ASC) VISIBLE,
  INDEX `fk_user_admin1_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_teacher1`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `gti_record_keeping_v2`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `gti_record_keeping_v2`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `gti_record_keeping_v2`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_admin1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `gti_record_keeping_v2`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`subject_course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`subject_course` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`subject_course` (
  `subject_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `registration_date` DATE NULL,
  PRIMARY KEY (`subject_id`, `course_id`),
  INDEX `fk_subject_has_course_course1_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_subject_has_course_subject1_idx` (`subject_id` ASC) VISIBLE,
  CONSTRAINT `fk_subject_has_course_subject1`
    FOREIGN KEY (`subject_id`)
    REFERENCES `gti_record_keeping_v2`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `gti_record_keeping_v2`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`student_course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`student_course` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`student_course` (
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `registration_id` INT NULL AUTO_INCREMENT,
  `registration_date` DATETIME NULL,
  `payment_ok` TINYINT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `fk_student_has_course_course1_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_student_has_course_student1_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `gti_record_keeping_v2`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `gti_record_keeping_v2`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`teacher_has_subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`teacher_has_subject` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`teacher_has_subject` (
  `teacher_teacher_id` INT NOT NULL,
  `subject_subject_id` INT NOT NULL,
  `registration_date` VARCHAR(45) NULL,
  PRIMARY KEY (`teacher_teacher_id`, `subject_subject_id`),
  INDEX `fk_teacher_has_subject_subject1_idx` (`subject_subject_id` ASC) VISIBLE,
  INDEX `fk_teacher_has_subject_teacher1_idx` (`teacher_teacher_id` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_has_subject_teacher1`
    FOREIGN KEY (`teacher_teacher_id`)
    REFERENCES `gti_record_keeping_v2`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_has_subject_subject1`
    FOREIGN KEY (`subject_subject_id`)
    REFERENCES `gti_record_keeping_v2`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping_v2`.`grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping_v2`.`grades` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping_v2`.`grades` (
  `assesment_result_id` INT NOT NULL AUTO_INCREMENT,
  `student_student_id` INT NOT NULL,
  `subject_subject_id` INT NOT NULL,
  `assesment_1` DECIMAL NULL,
  `assesment_2` DECIMAL NULL,
  `assesment_3` DECIMAL NULL,
  `final_exam` DECIMAL NULL,
  `overall` VARCHAR(45) NULL,
  PRIMARY KEY (`assesment_result_id`),
  INDEX `fk_assesment_result_student1_idx` (`student_student_id` ASC) VISIBLE,
  INDEX `fk_assesment_result_subject1_idx` (`subject_subject_id` ASC) VISIBLE,
  CONSTRAINT `fk_assesment_result_student1`
    FOREIGN KEY (`student_student_id`)
    REFERENCES `gti_record_keeping_v2`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assesment_result_subject1`
    FOREIGN KEY (`subject_subject_id`)
    REFERENCES `gti_record_keeping_v2`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
