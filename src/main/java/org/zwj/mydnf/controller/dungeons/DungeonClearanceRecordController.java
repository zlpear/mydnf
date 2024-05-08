package org.zwj.mydnf.controller.dungeons;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zwj.mydnf.entity.DungeonClearanceRecord;
import org.zwj.mydnf.service.dungeons.DungeonClearanceRecordService;
import org.zwj.mydnf.vo.ResultVO;

import java.util.List;

@RestController
@RequestMapping("/dungeonClearanceRecord")
public class DungeonClearanceRecordController {

    @Autowired
    private DungeonClearanceRecordService dungeonClearanceRecordService;

    @GetMapping("/")
    public ResultVO<List<DungeonClearanceRecord>> dungeonClearanceRecords() {
        return ResultVO.success(dungeonClearanceRecordService.list());
    }

    @GetMapping("/page")
    public ResultVO<Page<DungeonClearanceRecord>> getDungeonClearanceRecordPage(Page<DungeonClearanceRecord> page) {
        return ResultVO.success(dungeonClearanceRecordService.pageTree(page));
    }

    @GetMapping("/{id}")
    public ResultVO<DungeonClearanceRecord> dungeonClearanceRecord(@PathVariable Long id) {
        return ResultVO.success(dungeonClearanceRecordService.getById(id));
    }

    @PostMapping("/")
    public ResultVO<?> addDungeonClearanceRecord(@RequestBody DungeonClearanceRecord dungeonClearanceRecord) {
        dungeonClearanceRecordService.save(dungeonClearanceRecord);
        return ResultVO.success();
    }

    @PutMapping("/")
    public ResultVO<?> updateDungeonClearanceRecord(@RequestBody DungeonClearanceRecord dungeonClearanceRecord) {
        dungeonClearanceRecordService.updateById(dungeonClearanceRecord);
        return ResultVO.success();
    }

    @DeleteMapping("/{id}")
    public ResultVO<?> deleteDungeonClearanceRecord(@PathVariable Long id) {
        dungeonClearanceRecordService.removeById(id);
        return ResultVO.success();
    }

}