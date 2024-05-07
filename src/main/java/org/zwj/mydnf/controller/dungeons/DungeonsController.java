package org.zwj.mydnf.controller.dungeons;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zwj.mydnf.entity.Dungeons;
import org.zwj.mydnf.service.dungeons.IDungeonsService;
import org.zwj.mydnf.vo.ResultVO;

import java.util.List;

@RestController
@RequestMapping("/dungeons")
public class DungeonsController {

    @Autowired
    private IDungeonsService dungeonService;

    @GetMapping("/")
    public ResultVO<List<Dungeons>> dungeons() {
        return ResultVO.success(dungeonService.list());
    }

    @GetMapping("/page")
    public ResultVO<Page<Dungeons>> getDungeonPage(Page<Dungeons> page) {
        return ResultVO.success(dungeonService.page(page));
    }

    @GetMapping("/{id}")
    public ResultVO<Dungeons> dungeons(@PathVariable Long id) {
        return ResultVO.success(dungeonService.get(id));
    }

    @PostMapping("/")
    public ResultVO<?> addDungeon(@RequestBody Dungeons dungeons) {
        dungeonService.insert(dungeons);
        return ResultVO.success();
    }

    @PutMapping("/")
    public ResultVO<?> updateDungeon(@RequestBody Dungeons dungeons) {
        dungeonService.update(dungeons);
        return ResultVO.success();
    }

    @DeleteMapping("/{id}")
    public ResultVO<?> deleteDungeon(@PathVariable Long id) {
        dungeonService.delete(id);
        return ResultVO.success();
    }

}
