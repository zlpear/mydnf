package org.zwj.mydnf.service.dungeons.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.zwj.mydnf.entity.DungeonClearanceRecord;
import org.zwj.mydnf.mapper.DungeonClearanceRecordMapper;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.service.dungeons.DungeonClearanceRecordService;

@Service
public class DungeonCleazranceRecordServiceImpl extends ServiceImpl<DungeonClearanceRecordMapper, DungeonClearanceRecord> implements DungeonClearanceRecordService {
    @Override
    public Page<DungeonClearanceRecord> pageTree(Page<DungeonClearanceRecord> page) {
         return page(page, Wrappers.emptyWrapper());
    }
}