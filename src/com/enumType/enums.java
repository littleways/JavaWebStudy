package com.enumType;

public class enums {
    public enum REGISTER_ERROR_CORD {
        //成功
        SUCCESS(0),
        //用户注册参数缺少
        USER_NAME_LESS(1),
        //用户密码参数缺少
        USER_PASSWD_LESS(2),
        //用户重复密码参数缺少
        USER_REPASSWD_LESS(3),
        //用户邮箱参数缺少
        USER_EMIL_LESS(4),
        //两次输入密码不正确
        RE_PASSWD_ERROR(5),
        ;


        private Integer errorNums;

        REGISTER_ERROR_CORD(int codeNums) {
            this.errorNums = codeNums;
        }

        public static REGISTER_ERROR_CORD getByValue(int value) {
            REGISTER_ERROR_CORD[] values = values();
            for (REGISTER_ERROR_CORD cord : values) {
                if (cord.ordinal() == value) {
                    return cord;
                }
            }
            throw new IllegalArgumentException("REGISTER_ERROR_CORD is not exists:" + value);
        }
    }

    public enum LOGIN_ERROR_CORD {
        //成功
        SUCCESS(0),
        //用户注册参数缺少
        USER_NAME_ERROR(1),
        //用户密码参数缺少
        USER_PASS_WORD_ERROR(2),
        ;


        private Integer errorNums;

        LOGIN_ERROR_CORD(int codeNums) {
            this.errorNums = codeNums;
        }

        public static LOGIN_ERROR_CORD getByValue(int value) {
            LOGIN_ERROR_CORD[] values = values();
            for (LOGIN_ERROR_CORD cord : values) {
                if (cord.ordinal() == value) {
                    return cord;
                }
            }
            throw new IllegalArgumentException("LOGIN_ERROR_CORD is not exists:" + value);
        }
    }
}
