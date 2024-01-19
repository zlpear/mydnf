package org.zwj.mydnf.service.role.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.entity.Role;
import org.zwj.mydnf.mapper.RoleMapper;
import org.zwj.mydnf.service.role.IRoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> roles() {
        return roleMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public Page<Role> roles(Page<Role> page) {
        return roleMapper.selectPage(page, Wrappers.emptyWrapper());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public int deleteRole(Long id) {
        return roleMapper.deleteById(id);
    }
}
