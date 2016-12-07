package com.atguigu.catmovie.utils;

/**
 * 请求网络接口
 */
public class ConstantsUtils {
    /**
     * •热映界面
     */
    //    -ViewPager
    public static final String HOT_IAMGE_URL = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=11&version=6.8.0&new=0&app=movie&clienttp=android&uuid=FCFAB9D8DD339645D629C8372A29A2C6AD16F9C9E87AF9AC0D656B29DD5AC6DE&devid=866641027400542&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=qq&utm_medium=android&utm_term=6.8.0&utm_content=866641027400542&ci=1&net=255&dModel=HM%20NOTE%201LTETD&lat=40.100855&lng=116.378273&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463730432992&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=01f9c5c0-eb56-4e19-92fb-b86b16ad79da&__skcy=5K8wRR%2FKYAZDTgmAzbhrXi%2FomzU%3D";
    // ListView
    public static final String HOT_LIST_URL = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";
    /**
     * 待映页面
     */
    public static final String HOT_WAIT_PALY_URL = "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    //近期最受期待
    public static final String HOT_WAIT_RECENT_RESPECT = "http://api.maoyan.com/mmdb/movie/v1/list/wish/order/coming.json?offset=0&limit=50&ci=1";
    public static final String HOT_WAIT_YUGAO = "http://api.maoyan.com/mmdb/movie/lp/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=049083902299318&ci=1&net=255&dModel=CHM-TL00H&uuid=8E4A27B48E15CBEC74730E4EC5C1634A6BC841ED6E8D6F76964077E87B18D2F3&refer=%2FWelcome";
    /**
     * 找片页面
     */
    public static final String TAG_URL = "http://api.maoyan.com/mmdb/search/movie/tag/types.json?token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    public static final String ALL_PRIZE_URL = "http://api.maoyan.com/mmdb/movie/winning/film/2016-12-02/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20forx86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    public static final String PRIZE_URL = "http://api.maoyan.com/mmdb/movieboard/fixedboard/v1/hot/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome%E3%80%81";


    /**
     * 影院-
     */
    public static final String CINIMA_URL = "http://m.maoyan.com/cinemas.json";

    public static final String FIND_HEAD_URL = "http://api.maoyan.com/sns/v2/buttons.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=android&utm_term=7.6.0&utm_content=865479028905735&ci=1&net=255&dModel=MX4&uuid=F02F61DCB963FEAF421EF2B0673996706BABCBA6FA9412580E90681C52CB9B11&lat=40.10077&lng=116.378582&__reqTraceID=3549463187063305748&refer=%2FWelcome&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480832640407&__skua=32bcf146c756ecefe7535b95816908e3&__skno=f9b222bf-f57d-4c18-ac19-52c3bd199905&__skcy=rSQm2Bkrgr%2BJHs31LsskUzU0FT8%3D";
    /**
     * 发现-页面
     */
    public static final String FIND_LIST_URL = "http://api.maoyan.com/sns/v5/feed.json?";

    /**
     * 发现--周边商城
     */
    public static final String BASE_URL_MALL_VIEWPAGER = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=15&version=6.8.0&new=0&app=movie&clienttp=android&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&devid=000000000000000&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463727759502&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=c5c010cf-df8d-4cf3-b201-ff77d589a7d8&__skcy=aGeWnSUqiW22CW4JJ7%2FVZzJVKtI%3D";
    //Retrofit---get中后面的url

    public static final String SHOP_MALL_JSON = "{\n" +
            "    \"data\": {\n" +
            "        \"list\": [\n" +
            "            {\n" +
            "                \"dealid\": 38292972,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/36aba8e808faa11da5e015add2d0c1b2139888.jpg@60q\",\n" +
            "                \"price\": 35,\n" +
            "                \"title\": \"GetD魔兽电影主题3D眼镜（预售）\",\n" +
            "                \"value\": 99\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38330793,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\n" +
            "                \"price\": 89,\n" +
            "                \"title\": \"愤怒的小鸟毛绒玩具 大电影儿童公仔玩具\",\n" +
            "                \"value\": 119\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38319221,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/e09ae917fa6e238237cab5e7570c933f410487.jpg@60q\",\n" +
            "                \"price\": 68,\n" +
            "                \"title\": \"愤怒的小鸟经典常规款公仔 30cm\",\n" +
            "                \"value\": 78\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38319215,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\n" +
            "                \"price\": 88,\n" +
            "                \"title\": \"愤怒的小鸟经典款大号公仔 37CM\",\n" +
            "                \"value\": 98\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38319224,\n" +
            "                \"pic\": \"http://p1.meituan.net/348.348/movie/2fea2c8ac8b3c090c699c4421cdd8f32355332.jpg@60q\",\n" +
            "                \"price\": 48,\n" +
            "                \"title\": \"愤怒的小鸟经典款小公仔 22cm\",\n" +
            "                \"value\": 60\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38319228,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/dfa76dd2a59ca7fdb3738b726bfd439d366839.jpg@60q\",\n" +
            "                \"price\": 28,\n" +
            "                \"title\": \"愤怒的小鸟系列经典款迷你公仔3件包邮！\",\n" +
            "                \"value\": 38\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38330823,\n" +
            "                \"pic\": \"http://p1.meituan.net/348.348/movie/55ea6ecf7d045450c80dedbe0da85d4f44402.jpg@60q\",\n" +
            "                \"price\": 199,\n" +
            "                \"title\": \"《魔兽世界》正版模型 洛萨之剑\",\n" +
            "                \"value\": 209\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38330820,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/1b5b9c6814b1268c047f2da9073eef5050289.jpg@60q\",\n" +
            "                \"price\": 199,\n" +
            "                \"title\": \"《魔兽世界》 杜隆坦之斧升级版\",\n" +
            "                \"value\": 209\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38330819,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/a174a9391c38afd0320c8c6164706e3130991.jpg@60q\",\n" +
            "                \"price\": 39,\n" +
            "                \"title\": \"《魔兽世界》正版3D眼镜联盟款\",\n" +
            "                \"value\": 69\n" +
            "            },\n" +
            "            {\n" +
            "                \"dealid\": 38330818,\n" +
            "                \"pic\": \"http://p0.meituan.net/348.348/movie/ec71dc9533a98f9a1045eeb252f517af23998.jpg@60q\",\n" +
            "                \"price\": 39,\n" +
            "                \"title\": \"《魔兽世界》正版3D眼镜部落款\",\n" +
            "                \"value\": 69\n" +
            "            }\n" +
            "        ],\n" +
            "        \"total\": 823\n" +
            "    }\n" +
            "}";

    public static final String SHOP_TEJIA = "{\"data\": {\"list\":[{\"goods\": [{\"desc\": \"我们终会相遇\",\"pic\": \"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg\",\"title\": \"你的名字\"},{\"desc\": \"电影珍藏原著\",\"pic\": \"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg\",\"title\": \"佩小姐的奇幻城堡\"},{\"desc\": \"士兵有信仰，战场拒拿枪\",\"pic\": \"http://p0.meituan.net/165.220/movie/8b22149c2cdf2fd57108f2a1718ae085464061.jpg\",\"title\": \"血战钢锯岭\"}]},{\"goods\": [{\"desc\": \"冬升携老怪，千仗无一败\",\"pic\": \"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg\",\"title\": \"三少爷的剑\"},{\"desc\": \"五军战饕餮，中国魂不灭\",\"pic\": \"http://p0.meituan.net/165.220/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg\",\"title\": \"长城\"},{\"desc\": \"航海家后代，征程向大海\",\"pic\": \"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg\",\"title\": \"海洋奇缘\"}]},{\"goods\": [{\"desc\": \"飞机遇意外，机长险被害\",\"pic\": \"http://p1.meituan.net/165.220/movie/946e6e4182042c1e94feacb0dc93e7e3229652.jpg\",\"title\": \"萨利机长\"},{\"desc\": \"快递藏国宝，爆笑接力跑\",\"pic\": \"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png\",\"title\": \"超级快递\"},{\"desc\": \"哭成小笨蛋，笑回长大前\",\"pic\": \"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg\",\"title\": \"28岁未成年\"}]}],\"total\": 823}}";

}
