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
//    public static final String FIND_LIST_URL = "http://api.maoyan.com/sns/v5/feed.json?offset=0&limit=10&timestamp=0&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=android&utm_term=7.6.0&utm_content=865479028905735&ci=1&net=255&dModel=MX4&uuid=F02F61DCB963FEAF421EF2B0673996706BABCBA6FA9412580E90681C52CB9B11&lat=40.10073&lng=116.378531&__reqTraceID=3794605830477992064&refer=%2FWelcome&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480832259196&__skua=32bcf146c756ecefe7535b95816908e3&__skno=d6ffcde9-1bd6-43a1-b7fc-5d1ff82c5263&__skcy=dcyxucdqjeiCUw1w8jrOVpb%2B%2FSg%3D";
//    private static int i = 0;
//    private static int page = 0 + 10 * i;
//    public static  String FIND_LIST_URL = "http://api.maoyan.com/sns/v5/feed.json?offset=" + page + "&limit=10&timestamp=0&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=android&utm_term=7.6.0&utm_content=865479028905735&ci=1&net=255&dModel=MX4&uuid=F02F61DCB963FEAF421EF2B0673996706BABCBA6FA9412580E90681C52CB9B11&lat=40.10073&lng=116.378531&__reqTraceID=3794605830477992064&refer=%2FWelcome&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480832259196&__skua=32bcf146c756ecefe7535b95816908e3&__skno=d6ffcde9-1bd6-43a1-b7fc-5d1ff82c5263&__skcy=dcyxucdqjeiCUw1w8jrOVpb%2B%2FSg%3D";
//
//    public void setNum(int num) {
//        this.i = num;
//    }
    public static final String FIND_LIST_URL = "http://api.maoyan.com/sns/v5/feed.json?";


}
