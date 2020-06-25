
 CREATE TABLE `login` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(256) NOT NULL DEFAULT '' COMMENT '创建者',
  `update_user` varchar(256) NOT NULL DEFAULT '' COMMENT '更新者',
  `available` tinyint(2) NOT NULL DEFAULT '1' COMMENT '用于表示记录的可用性;1表示可用,2表示不可用;',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表示登录用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '表示登录用户名的密码',
  `login_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录的UNIX时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录表';




