package org.zwj.mydnf.vo.role;

import lombok.Data;

@Data
public class RoleVo {

    private Long id;
    private String name;
    private Integer careerId;
    private String career;
    private Integer renown;
    private byte[] avatar;
    private Long userId;
    private String username;

}
