package org.zwj.mydnf.entity;

import java.sql.Timestamp;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DungeonClearanceRecord {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long dungeonId;
    private Long roleId;
    private Long duration;
    private Timestamp createTime;
    private Timestamp updateTime;

    private List<DungeonClearanceRecord> children;
}