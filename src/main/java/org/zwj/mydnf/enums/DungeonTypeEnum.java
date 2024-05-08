package org.zwj.mydnf.enums;

public enum DungeonTypeEnum {
    ADVANCED_DUNGEON(1, "高级地下城"),
    LEGION_DUNGEON(2, "军团地下城"),
    SPECIAL_DUNGEON(3, "特殊地下城"),
    TEAM_DUNGEON(4, "团队地下城"),
    OTHER_DUNGEON(5, "其他地下城");

    private Integer code;
    private String name;

    DungeonTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(Integer code) {
        for (DungeonTypeEnum dungeonTypeEnum : DungeonTypeEnum.values()) {
            if (dungeonTypeEnum.getCode().equals(code)) {
                return dungeonTypeEnum.getName();
            }
        }
        return null;
    }
}
