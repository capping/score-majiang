USE `score`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` char(11) NOT NULL DEFAULT '' COMMENT '联系电话',
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT 'WeChat小程序openid',
  `unionid` varchar(32) NOT NULL DEFAULT '' COMMENT 'WeChat小程序unionid',
  `nick_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `avatar` text COMMENT '用户头像',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态: 0-正常, 1-删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
