package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("shopping_cart")
public class ShoppingCart {
    private Long id;        //主键
    private String name;    //名称
    private String image;   //图片
    @TableField("user_id")
    private Long userId;    //用户id
    @TableField("dish_id")
    private Long dishId;    //菜品id
    @TableField("setmeal_id")
    private Long setmealId; //套餐id
    @TableField("dish_flavor")
    private String dishFlavor;//口味
    private Integer number;     //数量
    private Integer amount;    //金额

    @TableField("create_time")
    private Date createTime;    //创建时间
}
