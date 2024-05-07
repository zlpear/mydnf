package org.zwj.mydnf.controller.role;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zwj.mydnf.controller.role.request.RolePageRequest;
import org.zwj.mydnf.entity.Role;
import org.zwj.mydnf.service.role.IRoleService;
import org.zwj.mydnf.vo.ResultVO;
import org.zwj.mydnf.vo.role.RoleVo;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @GetMapping
    public ResultVO<List<RoleVo>> roles() {
        return ResultVO.success(iRoleService.getRoleList());
    }

    @GetMapping("/page")
    public ResultVO<IPage<RoleVo>> getRolePage(RolePageRequest request) {
        return ResultVO.success(iRoleService.getRolePage(request));
    }

    @GetMapping("/{id}")
    public ResultVO<Role> role(@PathVariable Long id) {
        return ResultVO.success(iRoleService.getById(id));
    }

    @PostMapping
    public ResultVO<?> addUser(@RequestBody Role Role) {
        iRoleService.save(Role);
        return ResultVO.success();
    }

    @PutMapping
    public ResultVO<?> updateUser(@RequestBody Role role) {
        iRoleService.updateById(role);
        return ResultVO.success();
    }

    @PostMapping("/uploadAvatar")
    public ResultVO<?> uploadAvatar(@RequestParam(required = false) MultipartFile file, @RequestParam(required = false) Long id) throws IOException {
        Role role = iRoleService.getById(id);
        role.setAvatar(file.getBytes());
        iRoleService.updateById(role);
        return ResultVO.success();
    }


    @DeleteMapping("/{id}")
    public ResultVO<?> deleteUser(@PathVariable Long id) {
        iRoleService.removeById(id);
        return ResultVO.success();
    }

}
