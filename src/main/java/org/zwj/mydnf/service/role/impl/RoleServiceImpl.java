package org.zwj.mydnf.service.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.parser.JsqlParserFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.controller.role.request.RolePageRequest;
import org.zwj.mydnf.entity.Role;
import org.zwj.mydnf.entity.User;
import org.zwj.mydnf.enums.CareerEnum;
import org.zwj.mydnf.mapper.RoleMapper;
import org.zwj.mydnf.service.role.IRoleService;
import org.zwj.mydnf.service.role.sort.RoleSortMap;
import org.zwj.mydnf.service.user.IUserService;
import org.zwj.mydnf.vo.role.RoleVo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private IUserService iUserService;

    @Override
    public List<RoleVo> getRoleList() {
        List<Role> roleList = this.list();
        List<Long> userIds = roleList.stream().map(Role::getUserId).collect(Collectors.toList());
        List<User> userList = iUserService.selectBatchIds(userIds);
        return roleList.stream().map(role -> {
            RoleVo roleVo = new RoleVo();
            roleVo.setId(role.getId());
            roleVo.setName(role.getName());
            roleVo.setCareerId(role.getCareerId());
            roleVo.setCareer(CareerEnum.getById(role.getCareerId()).getName());
            roleVo.setRenown(role.getRenown());
            roleVo.setUserId(role.getUserId());
            roleVo.setUsername(userList.stream().filter(user -> user.getId().equals(role.getUserId())).findFirst().get().getName());
            return roleVo;
        }).collect(Collectors.toList());
    }

    @Override
    public IPage<RoleVo> getRolePage(RolePageRequest request) {
        Page<Role> page = new Page<>(request.getCurrent(), request.getSize());
        LambdaQueryWrapper<Role> query = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(request.getOrderBy())) {
            SFunction<Role, Object> sortFunction = RoleSortMap.get(request.getOrderBy());
            if (request.isAsc()) {
                query.orderByAsc(sortFunction);
            } else {
                query.orderByDesc(sortFunction);
            }
        }
        page = this.page(page, query);
        List<Role> roleList = page.getRecords();
        List<Long> userIds = roleList.stream().map(Role::getUserId).collect(Collectors.toList());
        List<User> userList = iUserService.selectBatchIds(userIds);
        return page.convert(role -> {
            RoleVo roleVo = new RoleVo();
            roleVo.setId(role.getId());
            roleVo.setName(role.getName());
            roleVo.setCareerId(role.getCareerId());
            roleVo.setCareer(CareerEnum.getById(role.getCareerId()).getName());
            roleVo.setRenown(role.getRenown());
            roleVo.setUserId(role.getUserId());
            roleVo.setUsername(userList.stream().filter(user -> user.getId().equals(role.getUserId())).findFirst().get().getName());
            return roleVo;
        });
    }
}
