package org.zwj.mydnf.service.dungeons.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.entity.Dungeon;
import org.zwj.mydnf.enums.DungeonTypeEnum;
import org.zwj.mydnf.mapper.DungeonsMapper;
import org.zwj.mydnf.service.base.impl.BaseServiceImpl;
import org.zwj.mydnf.service.dungeons.IDungeonsService;
import org.zwj.mydnf.vo.dungeon.DungeonTypeVo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DungeonsServiceImpl extends BaseServiceImpl<Dungeon, DungeonsMapper> implements IDungeonsService {
    @Override
    public List<DungeonTypeVo> dungeonsType() {
        return Arrays.stream(DungeonTypeEnum.values())
                .map(this::toVo)
                .collect(Collectors.toList());
    }

    private DungeonTypeVo toVo(DungeonTypeEnum dungeonTypeEnum) {
        return DungeonTypeVo.builder()
                .code(dungeonTypeEnum.getCode())
                .name(dungeonTypeEnum.getName())
                .build();
    }

    @Override
    public Page<Dungeon> pageTree(Page<Dungeon> page) {
        LambdaQueryWrapper<Dungeon> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Dungeon::getParentId, 0);
        Page<Dungeon> pageTree = mapper.selectPage(page, queryWrapper);
        pageTree.getRecords().forEach(dungeons -> {
            dungeons.setTypeStr(DungeonTypeEnum.getNameByCode(dungeons.getType()));
            List<Dungeon> children = selectByParentId(dungeons.getId());
            if (CollectionUtils.isNotEmpty(children)) {
                children.forEach(child -> {
                    child.setTypeStr(DungeonTypeEnum.getNameByCode(child.getType()));
                });
                dungeons.setChildren(children);
            }
        });
        return pageTree;
    }

    @Override
    public List<Dungeon> selectByParentId(Long parentId) {
        LambdaQueryWrapper<Dungeon> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Dungeon::getParentId, parentId);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Dungeon> listTree() {
        LambdaQueryWrapper<Dungeon> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Dungeon::getParentId, 0);
        List<Dungeon> listTree = mapper.selectList(queryWrapper);
        listTree.forEach(dungeons -> {
            dungeons.setTypeStr(DungeonTypeEnum.getNameByCode(dungeons.getType()));
            List<Dungeon> children = selectByParentId(dungeons.getId());
            if (CollectionUtils.isNotEmpty(children)) {
                children.forEach(child -> {
                    child.setTypeStr(DungeonTypeEnum.getNameByCode(child.getType()));
                });
                dungeons.setChildren(children);
            }
        });
        return listTree;
    }
}
