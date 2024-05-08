package org.zwj.mydnf.controller.dungeons;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zwj.mydnf.entity.Dungeon;
import org.zwj.mydnf.service.dungeons.IDungeonsService;
import org.zwj.mydnf.vo.ResultVO;
import org.zwj.mydnf.vo.dungeon.DungeonTypeVo;

import java.util.List;

@RestController
@RequestMapping("/dungeons")
public class DungeonsController {

    @Autowired
    private IDungeonsService dungeonService;

    @GetMapping("/type")
    public ResultVO<List<DungeonTypeVo>> dungeonsType() {
        return ResultVO.success(dungeonService.dungeonsType());
    }


    @GetMapping("/")
    public ResultVO<List<Dungeon>> dungeons() {
        return ResultVO.success(dungeonService.listTree());
    }

    @GetMapping("/page")
    public ResultVO<Page<Dungeon>> getDungeonPage(Page<Dungeon> page) {
        return ResultVO.success(dungeonService.pageTree(page));
    }

    @GetMapping("/{id}")
    public ResultVO<Dungeon> dungeons(@PathVariable Long id) {
        return ResultVO.success(dungeonService.get(id));
    }

    @PostMapping("/")
    public ResultVO<?> addDungeon(@RequestBody Dungeon dungeons) {
        dungeonService.insert(dungeons);
        return ResultVO.success();
    }

    @PutMapping("/")
    public ResultVO<?> updateDungeon(@RequestBody Dungeon dungeons) {
        dungeonService.update(dungeons);
        return ResultVO.success();
    }

    @DeleteMapping("/{id}")
    public ResultVO<?> deleteDungeon(@PathVariable Long id) {
        dungeonService.delete(id);
        return ResultVO.success();
    }

}
