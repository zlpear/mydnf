package org.zwj.mydnf.service.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.zwj.mydnf.entity.Role;
import org.zwj.mydnf.entity.User;

import java.util.List;

public interface IRoleService {

    List<Role> roles();

    Page<Role> roles(Page<Role> page);

    Role getRoleById(Long id);

    void addRole(Role role);

    void updateRole(Role role);

    int deleteRole(Long id);

}
