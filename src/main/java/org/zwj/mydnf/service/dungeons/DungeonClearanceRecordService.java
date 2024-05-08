package org.zwj.mydnf.service.dungeons;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.zwj.mydnf.entity.DungeonClearanceRecord;

public interface DungeonClearanceRecordService extends IService<DungeonClearanceRecord> {
    Page<DungeonClearanceRecord> pageTree(Page<DungeonClearanceRecord> page);
}