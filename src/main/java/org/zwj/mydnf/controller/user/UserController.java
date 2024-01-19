package org.zwj.mydnf.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zwj.mydnf.entity.User;
import org.zwj.mydnf.service.user.IUserService;
import org.zwj.mydnf.vo.ResultVO;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public ResultVO<List<User>> getUserList() {
        return ResultVO.success(iUserService.users());
    }

    @GetMapping("/page")
    public ResultVO<Page<User>> getUserPage(Page<User> page) {
        return ResultVO.success(iUserService.users(page));
    }

    @GetMapping("/{id}")
    public ResultVO<User> getUser(@PathVariable Long id) {
        return ResultVO.success(iUserService.getUserById(id));
    }

    @PostMapping("/")
    public ResultVO addUser(@RequestBody User user) {
        iUserService.addUser(user);
        return ResultVO.success();
    }

    @PutMapping("/")
    public ResultVO updateUser(@RequestBody User user) {
        iUserService.updateUser(user);
        return ResultVO.success();
    }

    @PostMapping("/uploadAvatar")
    public ResultVO uploadAvatar(@RequestParam(required = false) MultipartFile file, @RequestParam(required = false) Long id) throws IOException {
        User user = iUserService.getUserById(id);
        user.setAvatar(file.getBytes());
        iUserService.updateUser(user);
        return ResultVO.success();
    }


    @DeleteMapping("/{id}")
    public ResultVO deleteUser(@PathVariable Long id) {
        iUserService.deleteUser(id);
        return ResultVO.success();
    }

}
