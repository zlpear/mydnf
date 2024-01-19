package org.zwj.mydnf.entity;

import lombok.Data;

@Data
public class Role {

    private Long id;
    private String name;
    private String career;
    private String avatar;
    private Long userId;
    private String createTime;
    private String updateTime;


}
