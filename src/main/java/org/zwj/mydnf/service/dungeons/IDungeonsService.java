package org.zwj.mydnf.service.dungeons;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.zwj.mydnf.entity.Dungeon;
import org.zwj.mydnf.service.base.IBaseService;
import org.zwj.mydnf.vo.dungeon.DungeonTypeVo;

import java.util.List;

public interface IDungeonsService extends IBaseService<Dungeon> {

    List<DungeonTypeVo> dungeonsType();

    Page<Dungeon> pageTree(Page<Dungeon> page);

    List<Dungeon> selectByParentId(Long parentId);

    List<Dungeon> listTree();
}
