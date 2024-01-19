CREATE TABLE `mydnf`.`user`  (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `qq_number` varchar(10) NOT NULL,
    `avatar` blob NULL,
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 ROW_FORMAT = DYNAMIC;