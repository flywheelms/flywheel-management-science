CREATE TABLE `FlywheelCadence` (
  `_id` CHAR(40) NOT NULL,
  `row_timestamp` BIGINT(14) NOT NULL DEFAULT 0,
  `headline` VARCHAR(256) NOT NULL,
  `FiscalYear__id` CHAR(40) NOT NULL,
  `sequence` INT(11) NULL,
  `scheduled_start_date` BIGINT(14) NOT NULL DEFAULT 0,
  `scheduled_end_date` BIGINT(14) NOT NULL DEFAULT 0,
  PRIMARY KEY (`_id`),
  CONSTRAINT `fk_Cadence_FiscalYear`
    FOREIGN KEY (`FiscalYear__id`)
    REFERENCES `FiscalYear` (`_id`) );