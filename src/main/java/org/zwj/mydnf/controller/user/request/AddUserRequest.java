package org.zwj.mydnf.controller.user.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.zwj.mydnf.entity.User;

import java.io.IOException;
import java.util.Date;

@Data
public class AddUserRequest {

    private String name;
    private String qqNumber;
    private MultipartFile avatar;
    private Date createTime;
    private Date updateTime;

    public User toUser() throws IOException {
        User user = new User();
        user.setName(name);
        user.setQqNumber(qqNumber);
        user.setAvatar(avatar.getBytes());
        user.setCreateTime(createTime);
        user.setUpdateTime(updateTime);
        return user;
    }

}
