package org.zwj.mydnf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dungeons {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer type;
    private String description;
    private String createTime;
    private String updateTime;
    private Integer status;
    private String picUrl;
    private String videoUrl;

}
