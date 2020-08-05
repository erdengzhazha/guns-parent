use guns_rest
-- 运营后台用户模块表
CREATE TABLE mooc_backend_user_t(
   UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
   user_name VARCHAR(50) COMMENT '用户账号',
   user_pwd VARCHAR(50) COMMENT '用户密码',
   user_phone VARCHAR(50) COMMENT '用户手机号'
) COMMENT '后台用户表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;