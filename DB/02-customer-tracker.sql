CREATE DATABASE IF NOT EXISTS `web_customer_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_customer_tracker`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name`  varchar(45) DEFAULT NULL,
    `email`      varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` (id, first_name, last_name, email)
VALUES (1, 'David', 'Adams', 'david@ya.com'),
       (2, 'John', 'Doe', 'john@ya.com'),
       (3, 'Ajay', 'Rao', 'ajay@ya.com'),
       (4, 'Mary', 'Public', 'mary@ya.com'),
       (5, 'Maxwell', 'Dixon', 'max@ya.com');

UNLOCK TABLES;
