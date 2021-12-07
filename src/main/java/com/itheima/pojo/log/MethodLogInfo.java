package com.itheima.pojo.log;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("method_log_info")
public class MethodLogInfo {
    private Long id;            //主键

    @TableField("user_id")
    private Long userId;        //用户id(外键)

    private String method;      //访问方法

    @TableField("method_time")
    private Long methodTime; //访问所需时间(单位毫秒)

    @TableField("method_start")
    private Date methodStart;   //方法开始时间

    @TableField("method_end")
    private Date methodEnd;     //方法结束时间

    private String ip;          //访问用户Ip

}
