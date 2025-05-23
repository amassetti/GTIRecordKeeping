# ROLES
INSERT INTO `gti_record_keeping_v2`.`role` (`role_id`, `role_code`, `role_description`) VALUES ('1', 'ROLE_ADMIN', 'Administrator');
INSERT INTO `gti_record_keeping_v2`.`role` (`role_id`, `role_code`, `role_description`) VALUES ('2', 'ROLE_TEACHER', 'Teacher');

# CITIES
INSERT INTO `gti_record_keeping_v2`.`city` (`city_id`, `city_name`, `county`) VALUES ('1', 'Galway', 'Galway');
INSERT INTO `gti_record_keeping_v2`.`city` (`city_id`, `city_name`, `county`) VALUES ('2', 'Dublin', 'Dublin');
INSERT INTO `gti_record_keeping_v2`.`city` (`city_id`, `city_name`, `county`) VALUES ('3', 'Sligo', 'Sligo');
INSERT INTO `gti_record_keeping_v2`.`city` (`city_id`, `city_name`, `county`) VALUES ('4', 'Mayo', 'Mayo');
INSERT INTO `gti_record_keeping_v2`.`city` (`city_id`, `city_name`, `county`) VALUES ('5', 'Foxford', 'Mayo');

# GENDERS
INSERT INTO `gti_record_keeping_v2`.`gender` (`gender_id`, `gender`) VALUES ('1', 'Female');
INSERT INTO `gti_record_keeping_v2`.`gender` (`gender_id`, `gender`) VALUES ('2', 'Male');
INSERT INTO `gti_record_keeping_v2`.`gender` (`gender_id`, `gender`) VALUES ('3', 'Other');

# Addresses
INSERT INTO `gti_record_keeping_v2`.`address` (`address_id`, `city_id`, `address_line_1`, `address_line_2`, `eir_code`) VALUES ('1','1','63 Shantalla Road','Galway','H91YQF7');
INSERT INTO `gti_record_keeping_v2`.`address` (`address_id`, `city_id`, `address_line_1`, `address_line_2`, `eir_code`) VALUES ('2','2','1 Dublin road','Dublin','H77H91');
INSERT INTO `gti_record_keeping_v2`.`address` (`address_id`, `city_id`, `address_line_1`, `address_line_2`, `eir_code`) VALUES ('3','3','1 Dublin road','Sligo','H66H91');
INSERT INTO `gti_record_keeping_v2`.`address` (`address_id`, `city_id`, `address_line_1`, `address_line_2`, `eir_code`) VALUES ('4','4','10 Some road','Mayo','H55H91');

# STUDENTS
INSERT INTO `gti_record_keeping_v2`.`student` (`student_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('1', '1', '1', 'Marie', 'Smith', 'msmith@xmail.com', '1234567BA');
INSERT INTO `gti_record_keeping_v2`.`student` (`student_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('2', '2', '2', 'Paul', 'Fahy', 'pfahy@xmail.com', '7654321AB');


# TEACHERS
INSERT INTO `gti_record_keeping_v2`.`teacher` (`teacher_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('1', '1', '1', 'Una', 'Keary', 'ukeary@xmail.com', '4352617AB');
INSERT INTO `gti_record_keeping_v2`.`teacher` (`teacher_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('2', '2', '2', 'Marck', 'Shaw', 'mshaw@xmail.com', '1112223AB');

# ADMINS
INSERT INTO `gti_record_keeping_v2`.`admin` (`admin_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('1', '3', '2', 'Ariel', 'Massetti', 'amassetti@xmail.com', '9352617AB');
INSERT INTO `gti_record_keeping_v2`.`admin` (`admin_id`, `address_id`, `gender_id`, `first_name`, `last_name`, `email`, `ppsn`) VALUES ('2', '4', '1', 'Paula', 'Mantel', 'pmantel@xmail.com', '9112223AB');

# USERS

INSERT INTO `gti_record_keeping_v2`.`user` (`username`, `password`, `admin_id`, `role_id`) VALUES ('asd', 'asd', '1', '1');
INSERT INTO `gti_record_keeping_v2`.`user` (`username`, `password`, `teacher_id`, `role_id`) VALUES ('ukeary', 'password', '1', '2');
INSERT INTO `gti_record_keeping_v2`.`user` (`username`, `password`, `teacher_id`, `role_id`) VALUES ('mshaw', 'password', '2', '2');
INSERT INTO `gti_record_keeping_v2`.`user` (`username`, `password`, `admin_id`, `role_id`) VALUES ('amassetti', 'asd123', '1', '1');
INSERT INTO `gti_record_keeping_v2`.`user` (`username`, `password`, `admin_id`, `role_id`) VALUES ('pmantel', 'password', '2', '1');

# DEPARTMENTS
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('1', 'IT & Computing', 'Information Technologies ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('2', 'Sport', 'Sport description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('3', 'Art & Design', 'Art & Design description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('4', 'Applied Health Sciences', 'Applied Health Sciences description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('5', 'Business and Law', 'Business and Law description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('6', 'Fashion', 'Fashion description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('7', 'Hairdressing & Beauty', 'Hairdressing & Beauty description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('8', 'Media', 'Media description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('9', 'Technology, Design & Engineering', 'Technology, Design & Engineering description ...');
INSERT INTO `gti_record_keeping_v2`.`department` (`department_id`, `name`, `description`) VALUES ('10', 'Arts and Social Sciences', 'Arts and Social Sciences description ...');

# COURSE TYPES
INSERT INTO `gti_record_keeping_v2`.`course_type` (`course_type_id`, `description`) VALUES ('1', 'Full Time');
INSERT INTO `gti_record_keeping_v2`.`course_type` (`course_type_id`, `description`) VALUES ('2', 'Part Time');

# COURSE
INSERT INTO `gti_record_keeping_v2`.`course` (`course_id`, `department_id`, `course_type_id`, `course_code`, `name`, `description`, `certification`) VALUES ('1', '1', '1', 'ACSD', 'Advance Certificate in Software Development', 'Advance Certificate in Software Development', '6');
INSERT INTO `gti_record_keeping_v2`.`course` (`course_id`, `department_id`, `course_type_id`, `course_code`, `name`, `description`, `certification`) VALUES ('2', '1', '1', '5M0529', 'Programming and Software Development with Cyber Security', 'Programming and Software Development with Cyber Security', '5');
