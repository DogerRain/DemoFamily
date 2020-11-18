DROP TABLE IF EXISTS t_user_hellocoder;
CREATE TABLE `t_user_hellocoder` (
  `id` int(11) NOT NULL,
  `name` varchar(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `test`.`t_user_hellocoder`(`id`, `name`, `description`, `create_time`) VALUES (1, '我是HaC', '一枚混迹于互联网的程序猿', '2020-06-04 21:47:35');
