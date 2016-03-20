package com.example.administrator;

public class FitConsts {

    public static final boolean DEBUG = false;

    private static final String HOST_TEST = "http://b2.waibao.help/fit_test/index.php";
    private static final String HOST_RELEASE = "http://android.nixi.waibao58.com/fit/index.php";
    public static final String HOST =
            DEBUG ? HOST_TEST :
                    HOST_RELEASE;
    public static final String HOST_IMAGE = "http://android.nixi.waibao58.com/service_image/index.php";

    //------------------友盟统计分享-------------------
    private static final String UMENG_KEY_DEBUG = "56303ea3e0f55ab905001ed7";
    private static final String UMENG_KEY_RELEASE = "5630609267e58e2000005e3d";
    public static final String UMENG_APPKEY = DEBUG ? UMENG_KEY_DEBUG : UMENG_KEY_RELEASE;

    //------------------微信分享-------------------
    public static final String WX_ID = "wx027975c909c0604e";
    public static final String WX_SECRET = "0fa44d6e4ddb4c641742e6078c3b478b";
    public static final String WXPAY_KEY = "881310896b75ddf7bd544acaa9bc052e";

    //------------------支付宝支付-------------------
    public final static String ALI_PARTNER = "2088121142769816";
    public final static String ALI_SELLER = "bomojiaoyu@126.com";
    public final static String ALI_NOTIFY_URL = "http://andorid.nixi.waibao58.com/index.php/pay/WeiXinNotifyUrl";
    public final static String ALI_PRIVATE =
            "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAK2CA+mKDylZEwvDPNT7ekc1eY2dbhhfyux/ddrmT8tOhvAvToaw2hsePIzrhMWZqcAEIK2GGewwuNVZLRacLNeRbHplHvhSi7xCKXk/sIAc5UR9upYAiojv060teZ2SQRnBtA1zsCAaG94RQNSiKNI+u6Uyq3NrCUTfxICpZKYVAgMBAAECgYA2fN8Hp0CNpphxmDVxWSwUUrnCfE8HvoV2caysOqmSWi3MHb8WU1GbNIqlYo0GlPQXBfTRKYzYfJB/B4s+T3tRDotHJ3R9Nxz6FMM17Q0oPxJ81tAJp5sYXvxfyvAhLSKUEm+CNs4Vtvdw0rrT4bvi+ylVRtBeGrM6B3u+3G1g/QJBAOBmvKWHDwLlZNmpP2Bb+S/3dJLkpD4NxynfaKfNt7gpMUaO4oPsYBZdwAq/dCqyaGQP3IpLoSu5oFkAm0U2L7MCQQDF8KlT1E4ec9aMBaWgDb9U+0v6DLsYo/0d+Sin2pdV+RhR52B3+gag1BlYqsPbYpotgjIpGzxMZ6cUeB2P6a8XAkA+bHX3+g0z+gpG/mzx6kP0kvrrzgzeckjAHjTn0TNVWKgrf54FouDL+AJvOvke04h0pXDtS8Km/jlb6O5In50/AkBVGKzDRF+9SdGv6vGUiLR8BXlZa8W3xzCXhTmMSDaNmIRzGcTob44P8H9hFjETjSV5cSK9d18J/fnfm/AhobZLAkAMQ5SuwY5blr9PjcIDMsT9zupMpndc9bdQNu02ojT6ZkfziNJpHRVeFvg9bTBA4LKI++8hAqMKYagU+uHG/tes";


    //------------------服务协议--------------------
    public final static String SERVICE_AGREEMENTS_URL
            = "http://121.41.54.93/OverturnersAcademy/secret_agreement.html";
    //------------------分享链接--------------------
    public final static String SHARE_URL = "http://www.huancheclub.com/nixi/";
    //------------------新手指导--------------------
    public final static String GUIDE_URL = "http://121.43.193.226/html/user_instruct.html";

    //------------------日期格式字符串--------------------
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String CHAR_SET = "utf-8";

    //------------------食物种类--------------------
    public final static String FOOD_TYPE_CARBO = "carbohydrate";
    public final static String FOOD_TYPE_FAT = "fat";
    public final static String FOOD_TYPE_FRUIT = "fruit";
    public final static String FOOD_TYPE_PROTEIN = "protein";

    public final static String FIT_PWD_KEY = "vcar11";

    public final static int ACTREQ_CAMERA = 100;
    public final static int ACTREQ_PICK_SPORT = 101;
    public final static int ACTREQ_PICK_FOOD = 102;
    public final static int ACTREQ_CLIP_AVATAR = 103;
    public final static int ACTREQ_PICK_USER = 104;
    public final static int ACTREQ_COVER_IMG = 105;
    public static final int ACTREQ_GET_CONSIGNEE = 106;
    public final static int ACTREQ_ADDRESS_ADD = 107;
    public final static int ACTREQ_ADDRESS_EDIT = 108;
    public final static int ACTREQ_PICK_TAG = 109;
    public final static int ACTREQ_PICK_IMAGE = 110;
    public final static int ACTREQ_MAKE_REDPACK = 111;
    public final static int ACTREQ_MAKE_DASHANG = 112;

    public final static String EX_CHAT_SESSION = "chat_session";
    public final static String EX_CHATID = "chat_uuid";
    public final static String EX_USERID = "user_uuid";
    public final static String EX_NICKNAME = "user_nick";
    public final static String EX_USER_INFO = "user_info";
    public final static String EX_PLANID = "plan_uuid";
    public final static String EX_MSGID = "msg_uuid";
    public final static String EX_BOOL_END = "is_plan_end";
    public final static String EX_USER_LIST = "user_list";
    public final static String EX_PICK_INDEX = "pick_index";
    public final static String EX_GOODSID = "goods_id";
    public final static String EX_GOODS_INFO = "goods_info";
    public final static String EX_PAY_AMOUNT = "pay_amount";
    public final static String EX_NOTICE_ID = "dynamics_uuid";
    public final static String EX_COMMENT = "comment_vo";
    public final static String EX_CONSIGNEE_INFO = "consignee_info";
    public static final String EX_GOODS_TAG = "goods_tag";
    public final static String EX_ORDER_NUMBER = "order_number";
    public final static String EX_GOODS_NUM = "goods_num";
    public final static String EX_WATER_ML = "water_ml";
    public final static String EX_CREATE_TIME = "create_time";
    public final static String EX_TL_TAG = "timeline_tag";
    public final static String EX_FINANCE_FEE = "finance_fee";
    public final static String EX_FINANCE_FEN = "finance_fen";
    public final static String EX_REDPACK = "multi_rand";
    public final static String EX_DASHANG = "single_pack";

    public final static String DISC_ITEM = "disc_item";
    public final static String ITEM_DETAIL = "item_detail";
    public final static String DEAN_UUID = "df1ebefeef7d0d32b957274b40a8a973";// 院长的uuid

    public final static String BREAKFAST_EN = "breakfast";
    public final static String LUNCH_EN = "lunch";
    public final static String DINNER_EN = "dinner";
    public final static String SNACK_EN = "snack";

    public final static String BREAKFAST_CH = "早餐";
    public final static String LUNCH_CH = "中餐";
    public final static String DINNER_CH = "晚餐";
    public final static String SNACK_CH = "加餐";

    public final static String DEFAULT_ADDRESS = "default_address";


}
