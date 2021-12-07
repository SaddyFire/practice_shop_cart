package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    private Long id;            //主键
    private String name;        //姓名
    private String phone;       //手机号
    private String sex;         //性别
    @TableField("id_number")
    private String idNumber;    //身份证号
    private String avatar;      //头像
    private Integer status;     //状态 0:禁用，1:正常
}
