-- Example on how to disable FK checks
SET FOREIGN_KEY_CHECKS = 0;

ALTER TABLE `gti_record_keeping`.`address` 
CHANGE COLUMN `address_id` `address_id` INT NOT NULL AUTO_INCREMENT ;

SET FOREIGN_KEY_CHECKS = 1;

