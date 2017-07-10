package com.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by za-wangshenhua on 2017/6/10.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String userName;
    private String loginName;
    private String password;
    private Integer age;
    private String mobile;
    private String cardid;
    private Date createDate;
    private Long version;
}
