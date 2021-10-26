CREATE TABLE IF NOT EXISTS `User` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `email` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC),
    INDEX `customer_index` (`email` ASC, `password` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
