DROP TABLE IF EXISTS t_user_hellocoder;
CREATE TABLE `t_user_hellocoder` (
  `id` int(11) NOT NULL,
  `name` VARCHAR(11) DEFAULT NULL,
  `description` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  ;



INSERT INTO `test`.`t_user_hellocoder`(`id`, `name`, `description`) VALUES (1, ''我是HaC'', ''一枚混迹于互联网的程序猿'');