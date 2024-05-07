package org.zwj.mydnf.service.user.impl;

import org.springframework.stereotype.Service;
import org.zwj.mydnf.entity.User;
import org.zwj.mydnf.mapper.UserMapper;
import org.zwj.mydnf.service.base.impl.BaseServiceImpl;
import org.zwj.mydnf.service.user.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements IUserService {


}
