package org.zwj.mydnf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer careerId;
    private Integer renown;
    private byte[] avatar;
    private Long userId;
    private Integer status; // 1:正常 0:隐藏
    private Date createTime;
    private Date updateTime;


}
