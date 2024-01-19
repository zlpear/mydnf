package org.zwj.mydnf.service.user.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.entity.User;
import org.zwj.mydnf.mapper.UserMapper;
import org.zwj.mydnf.service.user.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> users() {
        return userMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public Page<User> users(Page<User> page) {
        return userMapper.selectPage(page, Wrappers.emptyWrapper());
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }
}
