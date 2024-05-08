package org.zwj.mydnf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Dungeon {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer type;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String picUrl;
    private String videoUrl;
    private Long parentId;

    @TableField(exist = false)
    private String typeStr;
    @TableField(exist = false)
    private List<Dungeon> children;
}
