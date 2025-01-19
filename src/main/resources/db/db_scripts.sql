-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gti_record_keeping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gti_record_keeping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gti_record_keeping` ;
USE `gti_record_keeping` ;

-- -----------------------------------------------------
-- Table `gti_record_keeping`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`city` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`city` (
  `city_id` INT NOT NULL,
  `city_name` VARCHAR(50) NULL,
  `county` VARCHAR(50) NULL,
  PRIMARY KEY (`city_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`address` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`address` (
  `address_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  `address_line_1` VARCHAR(100) NULL,
  `address_line_2` VARCHAR(100) NULL,
  `eir_code` VARCHAR(10) NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_address_city_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_city`
    FOREIGN KEY (`city_id`)
    REFERENCES `gti_record_keeping`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`gender` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT,
  `gender` VARCHAR(40) NULL,
  PRIMARY KEY (`gender_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`teacher` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`teacher` (
  `teacher_id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `gender_id` INT NOT NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `ppsn` VARCHAR(20) NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `fk_teacher_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_teacher_gender1_idx` (`gender_id` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gti_record_keeping`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`student` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `gender_id` INT NOT NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `ppsn` VARCHAR(20) NULL,
  PRIMARY KEY (`student_id`),
  INDEX `fk_student_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_student_gender1_idx` (`gender_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gti_record_keeping`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`department` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`department` (
  `department_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(80) NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
COMMENT = 'Department:\n- Sports\n- IT & Computing\n- Media\n- Fashion\netc etc';


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`course_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`course_type` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`course_type` (
  `course_type_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`course_type_id`))
ENGINE = InnoDB
COMMENT = 'Course Type:\nPart time\nFull time';


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`course` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `department_id` INT NOT NULL,
  `course_type_id` INT NOT NULL,
  `course_code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(100) NULL,
  `certification` INT NULL,
  PRIMARY KEY (`course_id`),
  INDEX `fk_course_course_category1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_course_course_type1_idx` (`course_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `gti_record_keeping`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_course_type1`
    FOREIGN KEY (`course_type_id`)
    REFERENCES `gti_record_keeping`.`course_type` (`course_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`subject` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `subject_code` VARCHAR(40) NULL,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(80) NULL,
  PRIMARY KEY (`subject_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`role` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_code` VARCHAR(45) NULL,
  `role_description` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`admin` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`admin` (
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
    REFERENCES `gti_record_keeping`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admin_gender1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gti_record_keeping`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gti_record_keeping`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gti_record_keeping`.`user` ;

CREATE TABLE IF NOT EXISTS `gti_record_keeping`.`user` (
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
    REFERENCES `gti_record_keeping`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `gti_record_keeping`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `gti_record_keeping`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_admin1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `gti_record_keeping`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
