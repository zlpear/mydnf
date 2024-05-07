package org.zwj.mydnf.service.role.sort;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.parser.JsqlParserFunction;
import org.zwj.mydnf.entity.Role;

import java.util.HashMap;
import java.util.Map;

public class RoleSortMap {

    public static Map<String, SFunction<Role, Object>> map = new HashMap<>();

    static {
        map.put("id", Role::getId);
        map.put("name", Role::getName);
        map.put("careerId", Role::getCareerId);
        map.put("renown", Role::getRenown);
        map.put("userId", Role::getUserId);
    }

    public static SFunction<Role, Object> get(String sortField) {
        return map.get(sortField);
    }
}