package com.enn.lesson_test.entity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String  email;
    private Integer gender ;
    private Integer isDelete;

}
