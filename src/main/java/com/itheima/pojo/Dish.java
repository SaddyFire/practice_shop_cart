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
@TableName("dish")
public class Dish {
    private Long id;            //主键
    private String name;        //菜品名称
    @TableField("category_id")
    private Long categoryId;    //菜品分类id
    private Integer price;      //菜品价格
    private String code;        //商品码
    private String image;       //图片
    private String description; //描述信息
    private Integer status;     //0 停售 1 起售
    private Integer sort;       //顺序
    @TableField("create_time")
    private Date createTime;    //创建时间
}
