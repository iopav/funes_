package com.demo.floatwindowdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Data {
    private Data() {
    }

    public static String map = "";
    public static List<String> possibleMaps = new ArrayList<>();
    public static String killer_born = "";
    public static final String H = "_human";
    public static final String K = "_killer";
    public static AtomicBoolean INIT = new AtomicBoolean(false);
    public static final String[] enMaps = {"military_factory", "red_church", "hospital", "village", "moon_river", "rio_memory", "town","chinese_street","yin"};
    public static final String[] cnMaps = {"选择地图", "军工厂", "红教堂", "圣心医院", "湖景村", "月亮河", "冰工厂", "永眠镇","唐人街"};

    public static final String[] military_factory = {"changfangzuoce", "damenfeixu", "muwuchuangkou", "muwuyouce", "xiaomen", "xiaomenfeixu"};
    public static final String[] red_church = {"datui", "hongditanzuo", "jiaotangnei", "mudidijiaodian", "mudikaojiaotang", "mudiyizipang"};
    public static final String[] hospital = {"nvshenxiangfeixu", "yiyuanzhengmenerlou", "zhengmenfeixu", "muwufeixu", "wudifeixu", "nvshenxiang"};
    public static final String[] village = {"dachuan", "damenliangban", "haibian", "muwufengche", "shuangshiyi", "xiaochuanhouliangban", "yumidi"};
    public static final String[] moon_river = {"guiwu", "guiwufeixu", "guiwuqiaoshang", "guiwuqiaozuo", "huaimuma", "maxituan", "sanlianfeixu"};
    public static final String[] rio_memory = {"dafang", "dafangchuangkouzuo", "dafangjiaoluo", "jizhuangxiang", "muwuchuangkou", "muwurukou", "shengdanmen", "youguanfujin", "yueliangmenfeixu"};
    public static final String[] town = {"damen", "hongdieqiao", "jiamen", "jiamenfeixu", "jiaoluolou", "mudirukou", "xiaomen"};
    public static final String[] chinese_street = {"caifengpu", "gushujuchang", "yujingxuan", "zahuodian", "zaochadian","zuifangting"};

    public static final String[] rio_memory_cn = {"大房", "大房窗口左", "大房角落", "集装箱", "木屋窗口", "木屋入口", "圣诞门", "油罐附近", "月亮门废墟"};
    public static final String[] town_cn = {"大门", "红蝶桥", "假门", "假门废墟", "角落楼", "墓地入口", "小门"};
    public static final String[] chinese_street_cn = {"裁缝铺", "古树剧场", "御景轩", "杂货店", "早茶店"};
    public static final String[] military_factory_cn = {"厂房左侧", "大门废墟", "木屋窗口", "木屋右侧", "小门", "小门废墟"};
    public static final String[] red_church_cn = {"大推", "红地毯左", "教堂内", "墓地地窖点", "墓地靠教堂", "墓地椅子旁"};
    public static final String[] hospital_cn = {"女神像废墟", "医院正门二楼", "正门废墟", " 木屋废墟", "无敌废墟", "女神像"};
    public static final String[] village_cn = {"大船", "大门两板", "海边", "木屋风车", "双十一", "小船后两板", "玉米地"};
    public static final String[] moon_river_cn = {"鬼屋", "鬼屋废墟", "鬼屋桥上", "鬼屋桥左", "坏木马", "马戏团", "三连废墟"};

    public static final String[] military_factory_changfangzuoce = {"木屋", "木屋", "大门", "小门"};
    public static final String[] military_factory_damenfeixu = {"木屋", "木屋", "中场", "厂房"};
    public static final String[] military_factory_muwuchuangkou = {"厂房", "中场", "大门", "木屋"};
    public static final String[] military_factory_muwuyouce = {"木屋", "中场", "小门", "厂房"};
    public static final String[] military_factory_xiaomen = {"木屋", "中场", "厂房", "厂房", "备注：均匀分布中场反弧形"};
    public static final String[] military_factory_xiaomenfeixu = {"小门", "中场", "厂房", "厂房", "备注：厂房外 附近分布同，均匀分布正弧形"};

    public static final String[] hospital_nvshenxiangfeixu = {"无敌废墟", "无敌废墟", "医院", "三板"};
    public static final String[] hospital_yiyuanzhengmenerlou = {"女神像", "无敌废墟", "木屋", "小树林"};
    public static final String[] hospital_zhengmenfeixu = {"木屋", "小门", "鸟笼", "医院"};
    public static final String[] hospital_muwufeixu = {"女神像", "医院", "医院", "正门废墟"};
    public static final String[] hospital_wudifeixu = {"木屋", "木屋", "医院", "医院"};
    public static final String[] hospital_nvshenxiang = {"医院", "三板", "小树林", "木屋"};

    public static final String[] moon_river_guiwu = {"双滑梯", "坏木马", "三站台", "好木马"};
    public static final String[] moon_river_guiwufeixu = {"鬼屋桥", "月亮河", "坏木马", "三连废墟"};
    public static final String[] moon_river_guiwuqiaoshang = {"鬼屋废墟", "三站台", "坏木马", "二站台"};
    public static final String[] moon_river_guiwuqiaozuo = {"马戏团", "人皇桥", "鬼屋", "三连废墟"};
    public static final String[] moon_river_huaimuma = {"马戏团", "双滑梯", "鬼屋桥", "鬼屋"};
    public static final String[] moon_river_maxituan = {"终点站", "好木马", "鬼屋", "人皇桥"};
    public static final String[] moon_river_sanlianfeixu = {"鬼屋", "好木马", "人皇桥", "双滑梯"};

    public static final String[] red_church_datui = {"小推", "中推", "教堂", "红地毯"};
    public static final String[] red_church_hongditanzuo = {"中推", "小推", "教堂", "墓地"};
    public static final String[] red_church_jiaotangnei = {"木屋", "小门废墟", "墓地废墟", "大推"};
    public static final String[] red_church_mudidijiaodian = {"大推", "教堂", "木屋", "墓地废墟"};
    public static final String[] red_church_mudikaojiaotang = {"小门废墟", "木屋", "小推", "大推"};
    public static final String[] red_church_mudiyizipang = {"小门废墟", "墓地废墟", "教堂", "大门"};

    public static final String[] village_dachuan = {"海边废墟", "厕所", "小船", "中场"};
    public static final String[] village_damenliangban = {"船头", "厕所", "小船", "双十一"};
    public static final String[] village_haibian = {"木屋", "玉米地", "小船", "大船"};
    public static final String[] village_muwufengche = {"双十一", "中场", "大船", "船尾"};
    public static final String[] village_shuangshiyi = {"木屋废墟", "玉米地", "中场", "大船"};
    public static final String[] village_xiaochuanhouliangban = {"玉米地", "厕所", "中场", "大门废墟"};
    public static final String[] village_yumidi = {"双十一", "中场", "大门废墟", "大船"};

    public static final String[] rio_memory_dafang = {"中场", "两板一窗", "两车", "雪人"};
    public static final String[] rio_memory_dafangchuangkouzuo = {"月亮门", "中场", "集装箱", "集装箱"};
    public static final String[] rio_memory_dafangjiaoluo = {"月亮门", "油罐", "中场", "南门"};
    public static final String[] rio_memory_jizhuangxiang = {"木屋", "圣诞树", "南门", "大门"};
    public static final String[] rio_memory_muwuchuangkou = {"月亮门废墟", "油罐", "大房", "两板一窗"};
    public static final String[] rio_memory_muwurukou = {"月亮门废墟", "月亮门", "楼梯", "两板一窗"};
    public static final String[] rio_memory_shengdanmen = {"木屋", "中场", "两板一窗", "大房"};
    public static final String[] rio_memory_youguanfujin = {"圣诞树", "中场", "大房", "大房角落"};
    public static final String[] rio_memory_yueliangmenfeixu = {"木屋", "中场", "楼梯", "两车"};

    public static final String[] town_damen = {"一版一窗", "红蝶楼", "四站房", "三站"};
    public static final String[] town_hongdieqiao = {"大门废墟", "三板废墟", "四站房", "红蝶楼"};
    public static final String[] town_jiamen = {"居酒屋", "人皇机", "红蝶楼", "墓地"};
    public static final String[] town_jiamenfeixu = {"人皇机", "湖边废墟", " 湖边两板一窗", "三站"};
    public static final String[] town_jiaoluolou = {"四站房", "假门房", "红蝶楼", "饰伞屋"};
    public static final String[] town_mudirukou = {"假门房", "湖边废墟", "人皇机", "红蝶楼"};
    public static final String[] town_xiaomen = {"假门房", "三板废墟", "二站", "红蝶桥"};

    public static final String[] chinese_street_caifengpu = {"花店", "御景轩", "剧场", "雨伞门"};
    public static final String[] chinese_street_gushujuchang = {"御景轩", "洗浴", "醉芳庭", "酒楼"};
    public static final String[] chinese_street_yujingxuan = {"裁缝铺", "花店", "醉芳庭", "烧饼铺"};
    public static final String[] chinese_street_zahuodian = {"关公像", "狮子楼", "酒楼", "一窗一板"};
    public static final String[] chinese_street_zaochadian = {"狮子楼", "御景轩", "古树", "醉芳庭"};
};
