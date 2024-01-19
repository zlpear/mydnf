package org.zwj.mydnf.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.zwj.mydnf.entity.User;

import java.util.List;

public interface IUserService {

    List<User> users();

    Page<User> users(Page<User> page);

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    int deleteUser(Long id);

}
