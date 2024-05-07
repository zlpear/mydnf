package org.zwj.mydnf.service.role;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.zwj.mydnf.controller.role.request.RolePageRequest;
import org.zwj.mydnf.entity.Role;
import org.zwj.mydnf.vo.role.RoleVo;

import java.util.List;

public interface IRoleService extends IService<Role> {

    List<RoleVo> getRoleList();

    IPage<RoleVo> getRolePage(RolePageRequest request);

}
