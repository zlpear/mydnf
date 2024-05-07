package org.zwj.mydnf.enums;

import java.util.Arrays;

public enum CareerEnum {

    GHOST_SWORDSMAN_MALE(1, "鬼剑士﹒男", 0),
    SWORD_SOUL(101, "剑魂", 1),
    DEVIL_MAY_CRY(102, "鬼泣", 1),
    BERSERKER(103, "狂战士", 1),
    ASURA(104, "阿修罗", 1),
    SWORD_SHADOW(105, "剑影", 1),
    GHOST_SWORDSMAN_FEMALE(2, "鬼剑士﹒女", 0),
    DRIVE_SWORDSMAN(201, "驭剑士", 2),
    DARK_TEMPLE_KNIGHT(202, "暗殿骑士", 2),
    DEVIL_CONTRACTOR(203, "契魔者", 2),
    WANDERING_SAMURAI(204, "流浪武士", 2),
    BLADE_SHADOW(205, "刃影", 2),
    FIGHTER_MALE(3, "格斗家﹒男", 0),
    QIGONG_MASTER_MALE(301, "气功师﹒男", 3),
    SANDA_MALE(302, "散打﹒男", 3),
    STREET_FIGHTER_MALE(303, "街霸﹒男", 3),
    JUDOKA_MALE(304, "柔道家﹒男", 3),
    FIGHTER_FEMALE(4, "格斗家﹒女", 0),
    QIGONG_MASTER_FEMALE(401, "气功师﹒女", 4),
    SANDA_FEMALE(402, "散打﹒女", 4),
    STREET_FIGHTER_FEMALE(403, "街霸﹒女", 4),
    JUDOKA_FEMALE(404, "柔道家﹒女", 4),
    SHARPSHOOTER_MALE(5, "神枪手﹒男", 0),
    ROAMING_GUNNER_MALE(501, "漫游枪手﹒男", 5),
    GUNNERY_DIVISION_MALE(502, "枪炮师﹒男", 5),
    MECHANIC_MALE(503, "机械师﹒男", 5),
    AMMUNITION_EXPERT_MALE(504, "弹药专家﹒男", 5),
    ALLOY_WARRIOR_MALE(505, "合金战士", 5),
    SHARPSHOOTER_FEMALE(6, "神枪手﹒女", 0),
    ROAMING_GUNNER_FEMALE(601, "漫游枪手﹒男", 6),
    GUNNERY_DIVISION_FEMALE(602, "枪炮师﹒男", 6),
    MECHANIC_FEMALE(603, "机械师﹒男", 6),
    AMMUNITION_EXPERT_FEMALE(604, "弹药专家﹒男", 6),
    MAGICIAN_MALE(7, "魔法师﹒男", 0),
    ELEMENTAL_EXPLOSIVE(701, "元素爆破师", 7),
    ICE_MASTER(702, "冰结师", 7),
    SCARLET_MAGE(703, "猩红法师", 7),
    WIND_CHASER(704, "逐风者", 7),
    DIMENSION_WALKER(705, "次元行者", 7),
    MAGICIAN_FEMALE(8, "魔法师﹒女", 0),
    ELEMENTALIST(801, "元素师", 8),
    SUMMONER(802, "召唤师", 8),
    BATTLE_MAGE(803, "战斗法师", 8),
    MAGIC_SCHOLAR(804, "魔道学者", 8),
    LITTLE_WITCH(805, "小魔女", 8),
    PRIEST_MALE(9, "光职者﹒男", 0),
    BRIGHT_KNIGHT_MALE(901, "光明骑士﹒男", 9),
    BLUE_FIST_HOLY_MESSENGER(902, "蓝拳圣使", 9),
    EXORCIST(903, "驱魔师", 9),
    PUNISHER(904, "惩戒者", 9),
    PRIEST_FEMALE(10, "光职者﹒女", 0),
    BRIGHT_KNIGHT_FEMALE(1001, "光明骑士﹒女", 10),
    RIGHTEOUS_JUDGE(1002, "正义审判者", 10),
    miko(1003, "巫女", 10),
    THE_ONE_WHO_DESTROYS_EVIL(1004, "除恶者", 10),
    NIGHTBRINGER(11, "暗夜使者", 0),
    DARK_STAR(1101, "暗星", 11),
    NIGHT_WARLOCK(1102, "黑夜术士", 11),
    NINJA(1103, "忍者", 11),
    SHADOWDANCER(1104, "影舞者", 11),
    PROTECTOR(12, "守护者", 0),
    DRAGON_KNIGHT(1201, "龙骑士", 12),
    ELF_KNIGHT(1202, "精灵骑士", 12),
    PALATINE(1203, "帕拉丁", 12),
    CHAOS_SPIRIT(1204, "混沌魔灵", 12),
    MAGIC_LANCER(13, "魔枪士", 0),
    CONQUEROR(1301, "征战者", 13),
    THE_DECISIVE_BATTLER(1302, "决战者", 13),
    HUNTER(1303, "狩猎者", 13),
    DARK_GUNSLINGER(1304, "暗枪士", 13),
    SPEAR_SWORDSMAN(14, "枪剑士", 0),
    DARK_BLADE(1401, "暗刃", 14),
    AGENT(1402, "特工", 14),
    BATTLEFRONT_MERCENARIES(1403, "战线佣兵", 14),
    ENERGY_EXPERT(1404, "源能专家", 14),
    GAIDEN_CAREER(15, "外传职业", 0),
    DARK_WARRIOR(1501, "黑暗武士", 15),
    FOUNDER(1502, "缔造者", 15),

    ;

    private int id;
    private String name;
    private Integer parentId;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getParentId() {
        return parentId;
    }

    CareerEnum(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public static boolean isParent(CareerEnum careerEnum) {
        return careerEnum.getParentId() == 0;
    }

    public static CareerEnum getById(int id) {
        return Arrays.stream(CareerEnum.values())
                .filter(careerEnum -> careerEnum.getId() == id)
                .findFirst().orElse(null);
    }

}
