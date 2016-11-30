package com.atguigu.catmovie.movie.bean;

import java.util.List;

/**
 * 电影--热映的bean类
 */
public class HotPlayBean {

    /**
     * expires : 1800
     */

    private ControlBean control;
    /**
     * hasNext : false
     * movies : [{"3d":true,"cat":"冒险,奇幻,家庭","cnms":0,"dir":"大卫·叶茨","dur":133,"id":248918,"imax":true,"img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","late":false,"nm":"神奇动物在哪里","pn":236,"preSale":0,"rt":"2016-11-25上映","sc":9,"scm":"神奇动物城，法师显超能","showDate":"","showInfo":"今天158家影院放映1994场","sn":0,"snum":107198,"src":"","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","time":"","vd":"","ver":"3D/IMAX 3D/中国巨幕","wish":130686},{"3d":false,"cat":"剧情,爱情,动画","cnms":0,"dir":"新海诚","dur":107,"id":344881,"imax":false,"img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","late":false,"nm":"你的名字。","pn":166,"preSale":1,"rt":"本周五上映","sc":0,"scm":"寻君千里行，心系君之名","showDate":"","showInfo":"今天63家影院放映70场","sn":0,"snum":18377,"src":"","star":"上白石萌音,神木隆之介,长泽雅美","time":"","vd":"","ver":"2D","wish":264840},{"3d":false,"cat":"爱情,动作,战争","cnms":0,"dir":"罗伯特·泽米吉斯","dur":124,"id":346564,"imax":false,"img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","late":false,"nm":"间谍同盟","pn":210,"preSale":0,"rt":"本周三上映","sc":8.4,"scm":"夫妇皆仇敌，枕边藏杀机","showDate":"","showInfo":"今天151家影院放映937场","sn":0,"snum":30836,"src":"","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","time":"","vd":"","ver":"2D/中国巨幕","wish":42631},{"3d":true,"cat":"动画,动作,冒险","cnms":0,"dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","dur":107,"id":246222,"imax":false,"img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","late":false,"nm":"海洋奇缘","pn":128,"preSale":0,"rt":"2016-11-25上映","sc":9.2,"scm":"航海家后代，征程向大海","showDate":"","showInfo":"今天154家影院放映933场","sn":0,"snum":32991,"src":"","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","time":"","vd":"","ver":"2D/3D/中国巨幕/全景声","wish":42849},{"3d":false,"cat":"剧情,喜剧","cnms":0,"dir":"冯小刚","dur":140,"id":341749,"imax":false,"img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","late":false,"nm":"我不是潘金莲","pn":211,"preSale":0,"rt":"2016-11-18上映","sc":7.9,"scm":"金莲戏中戏，官场局中局","showDate":"","showInfo":"今天150家影院放映807场","sn":0,"snum":184894,"src":"","star":"范冰冰,郭涛,董成鹏","time":"","vd":"","ver":"2D/中国巨幕/全景声","wish":185572},{"3d":true,"cat":"冒险,奇幻","cnms":0,"dir":"蒂姆·波顿","dur":126,"id":246373,"imax":false,"img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","late":false,"nm":"佩小姐的奇幻城堡","pn":107,"preSale":1,"rt":"本周五上映","sc":0,"scm":"异能桃花源，穿越时光圈","showDate":"","showInfo":"今天36家影院放映36场","sn":0,"snum":1823,"src":"","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","time":"","vd":"","ver":"2D/3D/中国巨幕/全景声","wish":100909},{"3d":true,"cat":"剧情,动作,武侠","cnms":0,"dir":"尔冬升","dur":107,"id":79088,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","late":false,"nm":"三少爷的剑","pn":115,"preSale":1,"rt":"本周五上映","sc":0,"scm":"冬升携老怪，千仗无一败","showDate":"","showInfo":"今天19家影院放映19场","sn":0,"snum":1255,"src":"","star":"林更新,何润东,蒋梦婕","time":"","vd":"","ver":"3D/中国巨幕","wish":96095},{"3d":false,"cat":"动画,悬疑","cnms":0,"dir":"静野孔文","dur":112,"id":344073,"imax":false,"img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","late":false,"nm":"名侦探柯南：纯黑的恶梦","pn":80,"preSale":0,"rt":"2016-11-25上映","sc":8.8,"scm":"美女有异瞳，黑暗再行动","showDate":"","showInfo":"今天106家影院放映304场","sn":0,"snum":20398,"src":"","star":"高山南,天海佑希,林原惠美","time":"","vd":"","ver":"2D","wish":43219},{"3d":false,"cat":"喜剧,动作,冒险","cnms":0,"dir":"宋啸","dur":91,"id":343866,"imax":false,"img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","late":false,"nm":"超级快递","pn":143,"preSale":1,"rt":"本周五上映","sc":0,"scm":"中法韩跑男，为夺宝闯关","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":1749,"src":"","star":"陈赫,宋智孝,大卫·贝利","time":"","vd":"","ver":"2D/中国巨幕","wish":45597},{"3d":true,"cat":"动作,冒险,奇幻","cnms":0,"dir":"斯科特·德瑞克森","dur":115,"id":246124,"imax":true,"img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","late":false,"nm":"奇异博士","pn":534,"preSale":0,"rt":"2016-11-04上映","sc":9,"scm":"车祸手迟钝，修炼成神棍","showDate":"","showInfo":"今天70家影院放映189场","sn":0,"snum":338898,"src":"","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","time":"","vd":"","ver":"3D/IMAX 3D/中国巨幕/全景声","wish":205273},{"3d":false,"cat":"剧情,动作,悬疑","cnms":0,"dir":"林岭东,钱文锜","dur":100,"id":341529,"imax":false,"img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","late":false,"nm":"冲天火","pn":188,"preSale":0,"rt":"2016-11-25上映","sc":7.1,"scm":"血清三路抢，大火吞真相","showDate":"","showInfo":"今天67家影院放映137场","sn":0,"snum":21637,"src":"","star":"吴彦祖,张孝全,张若昀","time":"","vd":"","ver":"2D","wish":29674},{"3d":true,"cat":"剧情,战争","cnms":0,"dir":"李安","dur":113,"id":247736,"imax":false,"img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","late":false,"nm":"比利·林恩的中场战事","pn":281,"preSale":0,"rt":"2016-11-11上映","sc":8.3,"scm":"半场无战事，少年初长时","showDate":"","showInfo":"今天43家影院放映111场","sn":0,"snum":55536,"src":"","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","time":"","vd":"","ver":"3D/中国巨幕","wish":33615},{"3d":true,"cat":"动作,惊悚","cnms":0,"dir":"埃兰·克里维","dur":88,"id":336835,"imax":false,"img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","late":false,"nm":"极速之巅","pn":90,"preSale":1,"rt":"本周五上映","sc":0,"scm":"舍命战毒枭，为爱去狂飙","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":109,"src":"","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","time":"","vd":"","ver":"2D/中国巨幕/3D","wish":20559},{"3d":false,"cat":"剧情,战争","cnms":0,"dir":"梅尔·吉布森","dur":139,"id":338349,"imax":false,"img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","late":false,"nm":"血战钢锯岭","pn":98,"preSale":1,"rt":"下周四上映","sc":0,"scm":"士兵有信仰，战场拒拿枪","showDate":"","showInfo":"2016-12-08 下周四上映","sn":0,"snum":267,"src":"","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","time":"","vd":"","ver":"2D/中国巨幕","wish":14198},{"3d":false,"cat":"剧情,爱情","cnms":0,"dir":"谢云鹏,杜昌博","dur":92,"id":345529,"imax":false,"img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","late":false,"nm":"爱你的人","pn":265,"preSale":0,"rt":"本周四上映","sc":0,"scm":"女孩遭性侵，山村来打拼","showDate":"","showInfo":"今天27家影院放映61场","sn":0,"snum":73,"src":"","star":"郑昊,张墨锡,王佳琦","time":"","vd":"","ver":"2D","wish":2201},{"3d":false,"cat":"恐怖,惊悚,科幻","cnms":0,"dir":"李凯","dur":94,"id":1132403,"imax":false,"img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","late":false,"nm":"食人岛","pn":47,"preSale":1,"rt":"本周五上映","sc":0,"scm":"驴友去探险，误闯食人岛","showDate":"","showInfo":"2016-12-02 本周五上映","sn":0,"snum":150,"src":"","star":"娄淇,杨凯迪,谢波","time":"","vd":"","ver":"2D","wish":7355},{"3d":false,"cat":"剧情,动作,灾难","cnms":0,"dir":"彼得·博格","dur":108,"id":248675,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","late":false,"nm":"深海浩劫","pn":228,"preSale":0,"rt":"2016-11-15上映","sc":8.3,"scm":"海上遇井喷，英勇救同伴","showDate":"","showInfo":"今天13家影院放映32场","sn":0,"snum":31180,"src":"","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","time":"","vd":"","ver":"2D/中国巨幕","wish":26131},{"3d":false,"cat":"喜剧,爱情,奇幻","cnms":0,"dir":"张末","dur":109,"id":343413,"imax":false,"img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","late":false,"nm":"28岁未成年","pn":140,"preSale":1,"rt":"下周五上映","sc":9.2,"scm":"哭成小笨蛋，笑回长大前","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":77,"src":"","star":"倪妮,霍建华,马苏","time":"","vd":"","ver":"2D","wish":92563},{"3d":false,"cat":"爱情,悬疑,犯罪","cnms":0,"dir":"周隼","dur":0,"id":1187526,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","late":false,"nm":"那年夏天你去了哪里","pn":52,"preSale":1,"rt":"下周五上映","sc":0,"scm":"绑架十二年，归家惹事端","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":769,"src":"","star":"胡歌,宋佳,颜卓灵","time":"","vd":"","ver":"2D","wish":31254},{"3d":false,"cat":"喜剧,爱情","cnms":0,"dir":"马侃","dur":91,"id":345105,"imax":false,"img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","late":false,"nm":"最萌身高差","pn":72,"preSale":0,"rt":"2016-11-25上映","sc":7.9,"scm":"身高有差距，恋爱零距离","showDate":"","showInfo":"今天21家影院放映28场","sn":0,"snum":5868,"src":"","star":"高以翔,王水林,秦晓飞","time":"","vd":"","ver":"2D","wish":40251},{"3d":false,"cat":"动作,犯罪,剧情","cnms":0,"dir":"林超贤","dur":124,"id":338391,"imax":false,"img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","late":false,"nm":"湄公河行动","pn":296,"preSale":0,"rt":"2016-09-30上映","sc":9.3,"scm":"商船藏毒品，冤屈难洗清","showDate":"","showInfo":"今天16家影院放映23场","sn":0,"snum":823086,"src":"","star":"张涵予,彭于晏,冯文娟","time":"","vd":"","ver":"2D/中国巨幕","wish":57407},{"3d":false,"cat":"悬疑,剧情","cnms":0,"dir":"孙亮","dur":102,"id":343082,"imax":false,"img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","late":false,"nm":"判我有罪","pn":88,"preSale":0,"rt":"2016-05-06上映","sc":6.5,"scm":"医生有武器，心计和身体","showDate":"","showInfo":"今天4家影院放映21场","sn":0,"snum":1348,"src":"","star":"吴镇宇,戴立忍,李昕芸","time":"","vd":"","ver":"2D","wish":5709},{"3d":false,"cat":"动画,冒险","cnms":0,"dir":"宫元宏彰","dur":121,"id":344902,"imax":false,"img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","late":false,"nm":"航海王之黄金城","pn":108,"preSale":0,"rt":"2016-11-11上映","sc":9.1,"scm":"热血海贼王，冒险新起航","showDate":"","showInfo":"今天12家影院放映20场","sn":0,"snum":97036,"src":"","star":"田中真弓,大谷育江,冈村明美","time":"","vd":"","ver":"2D","wish":118442},{"3d":false,"cat":"剧情,喜剧","cnms":0,"dir":"周申,刘露","dur":111,"id":410612,"imax":false,"img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","late":false,"nm":"驴得水","pn":157,"preSale":0,"rt":"2016-10-28上映","sc":8.5,"scm":"谎言圆不上，人比驴荒唐","showDate":"","showInfo":"今天10家影院放映19场","sn":0,"snum":136178,"src":"","star":"任素汐,大力,刘帅良","time":"","vd":"","ver":"2D","wish":29385},{"3d":false,"cat":"恐怖,惊悚,悬疑","cnms":0,"dir":"周广兴","dur":89,"id":1182756,"imax":false,"img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","late":false,"nm":"怨灵地下室","pn":33,"preSale":0,"rt":"2016-11-25上映","sc":3.4,"scm":"夫人突暴毙，地下藏玄机","showDate":"","showInfo":"今天17家影院放映19场","sn":0,"snum":2206,"src":"","star":"那威,倪新宇,陈美行","time":"","vd":"","ver":"2D","wish":17215},{"3d":false,"cat":"剧情,爱情,悬疑","cnms":0,"dir":"林浩然","dur":95,"id":337195,"imax":false,"img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","late":false,"nm":"夏威夷之恋","pn":39,"preSale":0,"rt":"2016-11-25上映","sc":7.3,"scm":"只是被车撞，生活却变样","showDate":"","showInfo":"今天16家影院放映18场","sn":0,"snum":610,"src":"","star":"陈妍希,杰克逊·拉斯波恩,成康","time":"","vd":"","ver":"2D","wish":11823},{"3d":false,"cat":"剧情,爱情","cnms":0,"dir":"陈兵","dur":90,"id":344437,"imax":false,"img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","late":false,"nm":"我是处女座","pn":70,"preSale":0,"rt":"2016-11-25上映","sc":7.8,"scm":"处女爱处男，结局并不惨","showDate":"","showInfo":"今天9家影院放映11场","sn":0,"snum":1611,"src":"","star":"安宰贤,安以轩,方中信","time":"","vd":"","ver":"2D","wish":20845},{"3d":false,"cat":"剧情,喜剧,家庭","cnms":0,"dir":"安兵基","dur":103,"id":342427,"imax":false,"img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","late":false,"nm":"外公芳龄38","pn":166,"preSale":0,"rt":"2016-11-11上映","sc":8.3,"scm":"主播有点烦，儿孙太能缠","showDate":"","showInfo":"今天6家影院放映9场","sn":0,"snum":37313,"src":"","star":"佟大为,陈妍希,吕云骢","time":"","vd":"","ver":"2D","wish":39153},{"3d":false,"cat":"剧情,传记","cnms":0,"dir":"克林特·伊斯特伍德","dur":96,"id":342003,"imax":true,"img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","late":false,"nm":"萨利机长","pn":79,"preSale":1,"rt":"下周五上映","sc":0,"scm":"飞机遇意外，机长险被害","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":197,"src":"","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","time":"","vd":"","ver":"2D/IMAX 2D/中国巨幕","wish":12855},{"3d":false,"cat":"喜剧,爱情","cnms":0,"dir":"亚瑟·本扎昆","dur":101,"id":346365,"imax":false,"img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","late":false,"nm":"阿拉丁与神灯","pn":76,"preSale":0,"rt":"2016-11-18上映","sc":7.4,"scm":"穷人爱公主，神灯来帮助","showDate":"","showInfo":"今天3家影院放映5场","sn":0,"snum":11257,"src":"","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","time":"","vd":"","ver":"2D","wish":19648},{"3d":true,"cat":"动作,冒险,奇幻","cnms":0,"dir":"马蒂亚斯·霍恩","dur":108,"id":248637,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","late":false,"nm":"勇士之门","pn":212,"preSale":0,"rt":"2016-11-18上映","sc":6.4,"scm":"异世来相逢，勇者得重生","showDate":"","showInfo":"今天3家影院放映3场","sn":0,"snum":19401,"src":"","star":"赵又廷,倪妮,尤赖亚·谢尔顿","time":"","vd":"","ver":"2D/3D/中国巨幕","wish":23294},{"3d":false,"cat":"恐怖,惊悚,悬疑","cnms":0,"dir":"钟萱","dur":94,"id":1187417,"imax":false,"img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","late":false,"nm":"白云桥","pn":50,"preSale":0,"rt":"2016-11-18上映","sc":5.9,"scm":"神秘白云桥，阴阳交界处","showDate":"","showInfo":"今天3家影院放映3场","sn":0,"snum":2387,"src":"","star":"钟萱,温兆伦,刘宇珽","time":"","vd":"","ver":"2D","wish":4173},{"3d":false,"cat":"历史,战争,动作","cnms":0,"dir":"宁海强","dur":102,"id":346759,"imax":false,"img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","late":false,"nm":"勇士","pn":134,"preSale":0,"rt":"2016-10-14上映","sc":8.8,"scm":"夜奔百余里，行军创奇迹","showDate":"","showInfo":"今天2家影院放映2场","sn":0,"snum":17440,"src":"","star":"李东学,聂远,于小伟","time":"","vd":"","ver":"2D/中国巨幕","wish":10456},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"蒋钦民","dur":96,"id":345494,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","late":false,"nm":"不离不弃","pn":35,"preSale":0,"rt":"2016-11-04上映","sc":7.3,"scm":"新郎要逃婚，中了大陷阱","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":829,"src":"","star":"袁成杰,曹云金,江若琳","time":"","vd":"","ver":"2D","wish":16812},{"3d":false,"cat":"剧情","cnms":0,"dir":"刘雨霖","dur":110,"id":345216,"imax":false,"img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","late":false,"nm":"一句顶一万句","pn":176,"preSale":0,"rt":"2016-11-04上映","sc":7.7,"scm":"婚后无话讲，与谁诉短长","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":6804,"src":"","star":"毛孩,李倩,刘蓓","time":"","vd":"","ver":"2D","wish":11050},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"张坚庭","dur":96,"id":336061,"imax":false,"img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","late":false,"nm":"贫穷富爸爸","pn":61,"preSale":0,"rt":"2016-11-10上映","sc":8.1,"scm":"育儿新绝招，假装被破产","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":1946,"src":"","star":"郑嘉颖,小小彬,李呈媛","time":"","vd":"","ver":"2D","wish":16655},{"3d":false,"cat":"爱情,惊悚,悬疑","cnms":0,"dir":"摩撒利","dur":88,"id":346546,"imax":false,"img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","late":false,"nm":"聊斋新编之画皮新娘","pn":34,"preSale":0,"rt":"2016-11-11上映","sc":5.1,"scm":"东方魔幻书，怪力乱神出","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":4441,"src":"","star":"殷果儿,丁汇宇,刘小奇","time":"","vd":"","ver":"2D","wish":17879},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"郭翔","dur":96,"id":246674,"imax":false,"img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","late":false,"nm":"越囧","pn":77,"preSale":0,"rt":"2016-11-25上映","sc":0,"scm":"不惑未婚男，追女赴越南","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":252,"src":"","star":"马德钟,王大治,刘力扬","time":"","vd":"","ver":"2D","wish":3016},{"3d":false,"cat":"剧情,战争","cnms":0,"dir":"崔志敏","dur":90,"id":1189305,"imax":false,"img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","late":false,"nm":"热土悲歌","pn":7,"preSale":0,"rt":"2016-11-25上映","sc":0,"scm":"燕赵大地上，鬼子无处藏","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":8,"src":"","star":"邹德江,章宇,卢倩文","time":"","vd":"","ver":"2D","wish":7},{"3d":false,"cat":"剧情,爱情,冒险","cnms":0,"dir":"李柯","dur":94,"id":1197460,"imax":false,"img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","late":false,"nm":"沙漠之心","pn":68,"preSale":1,"rt":"本周五上映","sc":0,"scm":"沙漠越野赛，飙车为求爱","showDate":"","showInfo":"2016-12-02 本周五上映","sn":0,"snum":17,"src":"","star":"隋咏良,尤靖茹,薛祺","time":"","vd":"","ver":"2D","wish":3070},{"3d":false,"cat":"剧情","cnms":0,"dir":"万玛才旦","dur":120,"id":337708,"imax":false,"img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","late":false,"nm":"塔洛","pn":44,"preSale":1,"rt":"下周五上映","sc":0,"scm":"牧羊人进城，打碎纯真梦","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":433,"src":"","star":"西德尼玛,杨秀措,扎西","time":"","vd":"","ver":"2D","wish":2164},{"3d":false,"cat":"剧情,悬疑","cnms":0,"dir":"毕赣","dur":113,"id":342073,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","late":false,"nm":"路边野餐","pn":95,"preSale":0,"rt":"2016-07-15上映","sc":8.1,"scm":"离家把侄寻，帮人带书信","showDate":"","showInfo":"今天暂无场次","sn":0,"snum":6053,"src":"","star":"陈永忠,郭月,余世学","time":"","vd":"","ver":"2D","wish":5647},{"3d":false,"cat":"战争,历史,剧情","cnms":0,"dir":"刘星,胡明钢,于兰","dur":94,"id":1189048,"imax":false,"img":"http://p0.meituan.net/165.220/movie/91b3eb5fd8ea1f15e6a4a6c35842f63389899.jpg","late":false,"nm":"遵义会议","pn":0,"preSale":0,"rt":"2016-10-10上映","sc":0,"scm":"红军历万难，决战生死间","showDate":"","showInfo":"今天暂无场次","sn":0,"snum":443,"src":"","star":"佟瑞欣,郭伟华,马晓伟","time":"","vd":"","ver":"2D","wish":331}]
     */

    private DataBean data;
    /**
     * control : {"expires":1800}
     * data : {"hasNext":false,"movies":[{"3d":true,"cat":"冒险,奇幻,家庭","cnms":0,"dir":"大卫·叶茨","dur":133,"id":248918,"imax":true,"img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","late":false,"nm":"神奇动物在哪里","pn":236,"preSale":0,"rt":"2016-11-25上映","sc":9,"scm":"神奇动物城，法师显超能","showDate":"","showInfo":"今天158家影院放映1994场","sn":0,"snum":107198,"src":"","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","time":"","vd":"","ver":"3D/IMAX 3D/中国巨幕","wish":130686},{"3d":false,"cat":"剧情,爱情,动画","cnms":0,"dir":"新海诚","dur":107,"id":344881,"imax":false,"img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","late":false,"nm":"你的名字。","pn":166,"preSale":1,"rt":"本周五上映","sc":0,"scm":"寻君千里行，心系君之名","showDate":"","showInfo":"今天63家影院放映70场","sn":0,"snum":18377,"src":"","star":"上白石萌音,神木隆之介,长泽雅美","time":"","vd":"","ver":"2D","wish":264840},{"3d":false,"cat":"爱情,动作,战争","cnms":0,"dir":"罗伯特·泽米吉斯","dur":124,"id":346564,"imax":false,"img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","late":false,"nm":"间谍同盟","pn":210,"preSale":0,"rt":"本周三上映","sc":8.4,"scm":"夫妇皆仇敌，枕边藏杀机","showDate":"","showInfo":"今天151家影院放映937场","sn":0,"snum":30836,"src":"","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","time":"","vd":"","ver":"2D/中国巨幕","wish":42631},{"3d":true,"cat":"动画,动作,冒险","cnms":0,"dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","dur":107,"id":246222,"imax":false,"img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","late":false,"nm":"海洋奇缘","pn":128,"preSale":0,"rt":"2016-11-25上映","sc":9.2,"scm":"航海家后代，征程向大海","showDate":"","showInfo":"今天154家影院放映933场","sn":0,"snum":32991,"src":"","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","time":"","vd":"","ver":"2D/3D/中国巨幕/全景声","wish":42849},{"3d":false,"cat":"剧情,喜剧","cnms":0,"dir":"冯小刚","dur":140,"id":341749,"imax":false,"img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","late":false,"nm":"我不是潘金莲","pn":211,"preSale":0,"rt":"2016-11-18上映","sc":7.9,"scm":"金莲戏中戏，官场局中局","showDate":"","showInfo":"今天150家影院放映807场","sn":0,"snum":184894,"src":"","star":"范冰冰,郭涛,董成鹏","time":"","vd":"","ver":"2D/中国巨幕/全景声","wish":185572},{"3d":true,"cat":"冒险,奇幻","cnms":0,"dir":"蒂姆·波顿","dur":126,"id":246373,"imax":false,"img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","late":false,"nm":"佩小姐的奇幻城堡","pn":107,"preSale":1,"rt":"本周五上映","sc":0,"scm":"异能桃花源，穿越时光圈","showDate":"","showInfo":"今天36家影院放映36场","sn":0,"snum":1823,"src":"","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","time":"","vd":"","ver":"2D/3D/中国巨幕/全景声","wish":100909},{"3d":true,"cat":"剧情,动作,武侠","cnms":0,"dir":"尔冬升","dur":107,"id":79088,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","late":false,"nm":"三少爷的剑","pn":115,"preSale":1,"rt":"本周五上映","sc":0,"scm":"冬升携老怪，千仗无一败","showDate":"","showInfo":"今天19家影院放映19场","sn":0,"snum":1255,"src":"","star":"林更新,何润东,蒋梦婕","time":"","vd":"","ver":"3D/中国巨幕","wish":96095},{"3d":false,"cat":"动画,悬疑","cnms":0,"dir":"静野孔文","dur":112,"id":344073,"imax":false,"img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","late":false,"nm":"名侦探柯南：纯黑的恶梦","pn":80,"preSale":0,"rt":"2016-11-25上映","sc":8.8,"scm":"美女有异瞳，黑暗再行动","showDate":"","showInfo":"今天106家影院放映304场","sn":0,"snum":20398,"src":"","star":"高山南,天海佑希,林原惠美","time":"","vd":"","ver":"2D","wish":43219},{"3d":false,"cat":"喜剧,动作,冒险","cnms":0,"dir":"宋啸","dur":91,"id":343866,"imax":false,"img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","late":false,"nm":"超级快递","pn":143,"preSale":1,"rt":"本周五上映","sc":0,"scm":"中法韩跑男，为夺宝闯关","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":1749,"src":"","star":"陈赫,宋智孝,大卫·贝利","time":"","vd":"","ver":"2D/中国巨幕","wish":45597},{"3d":true,"cat":"动作,冒险,奇幻","cnms":0,"dir":"斯科特·德瑞克森","dur":115,"id":246124,"imax":true,"img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","late":false,"nm":"奇异博士","pn":534,"preSale":0,"rt":"2016-11-04上映","sc":9,"scm":"车祸手迟钝，修炼成神棍","showDate":"","showInfo":"今天70家影院放映189场","sn":0,"snum":338898,"src":"","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","time":"","vd":"","ver":"3D/IMAX 3D/中国巨幕/全景声","wish":205273},{"3d":false,"cat":"剧情,动作,悬疑","cnms":0,"dir":"林岭东,钱文锜","dur":100,"id":341529,"imax":false,"img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","late":false,"nm":"冲天火","pn":188,"preSale":0,"rt":"2016-11-25上映","sc":7.1,"scm":"血清三路抢，大火吞真相","showDate":"","showInfo":"今天67家影院放映137场","sn":0,"snum":21637,"src":"","star":"吴彦祖,张孝全,张若昀","time":"","vd":"","ver":"2D","wish":29674},{"3d":true,"cat":"剧情,战争","cnms":0,"dir":"李安","dur":113,"id":247736,"imax":false,"img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","late":false,"nm":"比利·林恩的中场战事","pn":281,"preSale":0,"rt":"2016-11-11上映","sc":8.3,"scm":"半场无战事，少年初长时","showDate":"","showInfo":"今天43家影院放映111场","sn":0,"snum":55536,"src":"","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","time":"","vd":"","ver":"3D/中国巨幕","wish":33615},{"3d":true,"cat":"动作,惊悚","cnms":0,"dir":"埃兰·克里维","dur":88,"id":336835,"imax":false,"img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","late":false,"nm":"极速之巅","pn":90,"preSale":1,"rt":"本周五上映","sc":0,"scm":"舍命战毒枭，为爱去狂飙","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":109,"src":"","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","time":"","vd":"","ver":"2D/中国巨幕/3D","wish":20559},{"3d":false,"cat":"剧情,战争","cnms":0,"dir":"梅尔·吉布森","dur":139,"id":338349,"imax":false,"img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","late":false,"nm":"血战钢锯岭","pn":98,"preSale":1,"rt":"下周四上映","sc":0,"scm":"士兵有信仰，战场拒拿枪","showDate":"","showInfo":"2016-12-08 下周四上映","sn":0,"snum":267,"src":"","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","time":"","vd":"","ver":"2D/中国巨幕","wish":14198},{"3d":false,"cat":"剧情,爱情","cnms":0,"dir":"谢云鹏,杜昌博","dur":92,"id":345529,"imax":false,"img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","late":false,"nm":"爱你的人","pn":265,"preSale":0,"rt":"本周四上映","sc":0,"scm":"女孩遭性侵，山村来打拼","showDate":"","showInfo":"今天27家影院放映61场","sn":0,"snum":73,"src":"","star":"郑昊,张墨锡,王佳琦","time":"","vd":"","ver":"2D","wish":2201},{"3d":false,"cat":"恐怖,惊悚,科幻","cnms":0,"dir":"李凯","dur":94,"id":1132403,"imax":false,"img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","late":false,"nm":"食人岛","pn":47,"preSale":1,"rt":"本周五上映","sc":0,"scm":"驴友去探险，误闯食人岛","showDate":"","showInfo":"2016-12-02 本周五上映","sn":0,"snum":150,"src":"","star":"娄淇,杨凯迪,谢波","time":"","vd":"","ver":"2D","wish":7355},{"3d":false,"cat":"剧情,动作,灾难","cnms":0,"dir":"彼得·博格","dur":108,"id":248675,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","late":false,"nm":"深海浩劫","pn":228,"preSale":0,"rt":"2016-11-15上映","sc":8.3,"scm":"海上遇井喷，英勇救同伴","showDate":"","showInfo":"今天13家影院放映32场","sn":0,"snum":31180,"src":"","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","time":"","vd":"","ver":"2D/中国巨幕","wish":26131},{"3d":false,"cat":"喜剧,爱情,奇幻","cnms":0,"dir":"张末","dur":109,"id":343413,"imax":false,"img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","late":false,"nm":"28岁未成年","pn":140,"preSale":1,"rt":"下周五上映","sc":9.2,"scm":"哭成小笨蛋，笑回长大前","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":77,"src":"","star":"倪妮,霍建华,马苏","time":"","vd":"","ver":"2D","wish":92563},{"3d":false,"cat":"爱情,悬疑,犯罪","cnms":0,"dir":"周隼","dur":0,"id":1187526,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","late":false,"nm":"那年夏天你去了哪里","pn":52,"preSale":1,"rt":"下周五上映","sc":0,"scm":"绑架十二年，归家惹事端","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":769,"src":"","star":"胡歌,宋佳,颜卓灵","time":"","vd":"","ver":"2D","wish":31254},{"3d":false,"cat":"喜剧,爱情","cnms":0,"dir":"马侃","dur":91,"id":345105,"imax":false,"img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","late":false,"nm":"最萌身高差","pn":72,"preSale":0,"rt":"2016-11-25上映","sc":7.9,"scm":"身高有差距，恋爱零距离","showDate":"","showInfo":"今天21家影院放映28场","sn":0,"snum":5868,"src":"","star":"高以翔,王水林,秦晓飞","time":"","vd":"","ver":"2D","wish":40251},{"3d":false,"cat":"动作,犯罪,剧情","cnms":0,"dir":"林超贤","dur":124,"id":338391,"imax":false,"img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","late":false,"nm":"湄公河行动","pn":296,"preSale":0,"rt":"2016-09-30上映","sc":9.3,"scm":"商船藏毒品，冤屈难洗清","showDate":"","showInfo":"今天16家影院放映23场","sn":0,"snum":823086,"src":"","star":"张涵予,彭于晏,冯文娟","time":"","vd":"","ver":"2D/中国巨幕","wish":57407},{"3d":false,"cat":"悬疑,剧情","cnms":0,"dir":"孙亮","dur":102,"id":343082,"imax":false,"img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","late":false,"nm":"判我有罪","pn":88,"preSale":0,"rt":"2016-05-06上映","sc":6.5,"scm":"医生有武器，心计和身体","showDate":"","showInfo":"今天4家影院放映21场","sn":0,"snum":1348,"src":"","star":"吴镇宇,戴立忍,李昕芸","time":"","vd":"","ver":"2D","wish":5709},{"3d":false,"cat":"动画,冒险","cnms":0,"dir":"宫元宏彰","dur":121,"id":344902,"imax":false,"img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","late":false,"nm":"航海王之黄金城","pn":108,"preSale":0,"rt":"2016-11-11上映","sc":9.1,"scm":"热血海贼王，冒险新起航","showDate":"","showInfo":"今天12家影院放映20场","sn":0,"snum":97036,"src":"","star":"田中真弓,大谷育江,冈村明美","time":"","vd":"","ver":"2D","wish":118442},{"3d":false,"cat":"剧情,喜剧","cnms":0,"dir":"周申,刘露","dur":111,"id":410612,"imax":false,"img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","late":false,"nm":"驴得水","pn":157,"preSale":0,"rt":"2016-10-28上映","sc":8.5,"scm":"谎言圆不上，人比驴荒唐","showDate":"","showInfo":"今天10家影院放映19场","sn":0,"snum":136178,"src":"","star":"任素汐,大力,刘帅良","time":"","vd":"","ver":"2D","wish":29385},{"3d":false,"cat":"恐怖,惊悚,悬疑","cnms":0,"dir":"周广兴","dur":89,"id":1182756,"imax":false,"img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","late":false,"nm":"怨灵地下室","pn":33,"preSale":0,"rt":"2016-11-25上映","sc":3.4,"scm":"夫人突暴毙，地下藏玄机","showDate":"","showInfo":"今天17家影院放映19场","sn":0,"snum":2206,"src":"","star":"那威,倪新宇,陈美行","time":"","vd":"","ver":"2D","wish":17215},{"3d":false,"cat":"剧情,爱情,悬疑","cnms":0,"dir":"林浩然","dur":95,"id":337195,"imax":false,"img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","late":false,"nm":"夏威夷之恋","pn":39,"preSale":0,"rt":"2016-11-25上映","sc":7.3,"scm":"只是被车撞，生活却变样","showDate":"","showInfo":"今天16家影院放映18场","sn":0,"snum":610,"src":"","star":"陈妍希,杰克逊·拉斯波恩,成康","time":"","vd":"","ver":"2D","wish":11823},{"3d":false,"cat":"剧情,爱情","cnms":0,"dir":"陈兵","dur":90,"id":344437,"imax":false,"img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","late":false,"nm":"我是处女座","pn":70,"preSale":0,"rt":"2016-11-25上映","sc":7.8,"scm":"处女爱处男，结局并不惨","showDate":"","showInfo":"今天9家影院放映11场","sn":0,"snum":1611,"src":"","star":"安宰贤,安以轩,方中信","time":"","vd":"","ver":"2D","wish":20845},{"3d":false,"cat":"剧情,喜剧,家庭","cnms":0,"dir":"安兵基","dur":103,"id":342427,"imax":false,"img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","late":false,"nm":"外公芳龄38","pn":166,"preSale":0,"rt":"2016-11-11上映","sc":8.3,"scm":"主播有点烦，儿孙太能缠","showDate":"","showInfo":"今天6家影院放映9场","sn":0,"snum":37313,"src":"","star":"佟大为,陈妍希,吕云骢","time":"","vd":"","ver":"2D","wish":39153},{"3d":false,"cat":"剧情,传记","cnms":0,"dir":"克林特·伊斯特伍德","dur":96,"id":342003,"imax":true,"img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","late":false,"nm":"萨利机长","pn":79,"preSale":1,"rt":"下周五上映","sc":0,"scm":"飞机遇意外，机长险被害","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":197,"src":"","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","time":"","vd":"","ver":"2D/IMAX 2D/中国巨幕","wish":12855},{"3d":false,"cat":"喜剧,爱情","cnms":0,"dir":"亚瑟·本扎昆","dur":101,"id":346365,"imax":false,"img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","late":false,"nm":"阿拉丁与神灯","pn":76,"preSale":0,"rt":"2016-11-18上映","sc":7.4,"scm":"穷人爱公主，神灯来帮助","showDate":"","showInfo":"今天3家影院放映5场","sn":0,"snum":11257,"src":"","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","time":"","vd":"","ver":"2D","wish":19648},{"3d":true,"cat":"动作,冒险,奇幻","cnms":0,"dir":"马蒂亚斯·霍恩","dur":108,"id":248637,"imax":false,"img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","late":false,"nm":"勇士之门","pn":212,"preSale":0,"rt":"2016-11-18上映","sc":6.4,"scm":"异世来相逢，勇者得重生","showDate":"","showInfo":"今天3家影院放映3场","sn":0,"snum":19401,"src":"","star":"赵又廷,倪妮,尤赖亚·谢尔顿","time":"","vd":"","ver":"2D/3D/中国巨幕","wish":23294},{"3d":false,"cat":"恐怖,惊悚,悬疑","cnms":0,"dir":"钟萱","dur":94,"id":1187417,"imax":false,"img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","late":false,"nm":"白云桥","pn":50,"preSale":0,"rt":"2016-11-18上映","sc":5.9,"scm":"神秘白云桥，阴阳交界处","showDate":"","showInfo":"今天3家影院放映3场","sn":0,"snum":2387,"src":"","star":"钟萱,温兆伦,刘宇珽","time":"","vd":"","ver":"2D","wish":4173},{"3d":false,"cat":"历史,战争,动作","cnms":0,"dir":"宁海强","dur":102,"id":346759,"imax":false,"img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","late":false,"nm":"勇士","pn":134,"preSale":0,"rt":"2016-10-14上映","sc":8.8,"scm":"夜奔百余里，行军创奇迹","showDate":"","showInfo":"今天2家影院放映2场","sn":0,"snum":17440,"src":"","star":"李东学,聂远,于小伟","time":"","vd":"","ver":"2D/中国巨幕","wish":10456},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"蒋钦民","dur":96,"id":345494,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","late":false,"nm":"不离不弃","pn":35,"preSale":0,"rt":"2016-11-04上映","sc":7.3,"scm":"新郎要逃婚，中了大陷阱","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":829,"src":"","star":"袁成杰,曹云金,江若琳","time":"","vd":"","ver":"2D","wish":16812},{"3d":false,"cat":"剧情","cnms":0,"dir":"刘雨霖","dur":110,"id":345216,"imax":false,"img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","late":false,"nm":"一句顶一万句","pn":176,"preSale":0,"rt":"2016-11-04上映","sc":7.7,"scm":"婚后无话讲，与谁诉短长","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":6804,"src":"","star":"毛孩,李倩,刘蓓","time":"","vd":"","ver":"2D","wish":11050},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"张坚庭","dur":96,"id":336061,"imax":false,"img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","late":false,"nm":"贫穷富爸爸","pn":61,"preSale":0,"rt":"2016-11-10上映","sc":8.1,"scm":"育儿新绝招，假装被破产","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":1946,"src":"","star":"郑嘉颖,小小彬,李呈媛","time":"","vd":"","ver":"2D","wish":16655},{"3d":false,"cat":"爱情,惊悚,悬疑","cnms":0,"dir":"摩撒利","dur":88,"id":346546,"imax":false,"img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","late":false,"nm":"聊斋新编之画皮新娘","pn":34,"preSale":0,"rt":"2016-11-11上映","sc":5.1,"scm":"东方魔幻书，怪力乱神出","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":4441,"src":"","star":"殷果儿,丁汇宇,刘小奇","time":"","vd":"","ver":"2D","wish":17879},{"3d":false,"cat":"剧情,喜剧,爱情","cnms":0,"dir":"郭翔","dur":96,"id":246674,"imax":false,"img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","late":false,"nm":"越囧","pn":77,"preSale":0,"rt":"2016-11-25上映","sc":0,"scm":"不惑未婚男，追女赴越南","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":252,"src":"","star":"马德钟,王大治,刘力扬","time":"","vd":"","ver":"2D","wish":3016},{"3d":false,"cat":"剧情,战争","cnms":0,"dir":"崔志敏","dur":90,"id":1189305,"imax":false,"img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","late":false,"nm":"热土悲歌","pn":7,"preSale":0,"rt":"2016-11-25上映","sc":0,"scm":"燕赵大地上，鬼子无处藏","showDate":"","showInfo":"今天1家影院放映1场","sn":0,"snum":8,"src":"","star":"邹德江,章宇,卢倩文","time":"","vd":"","ver":"2D","wish":7},{"3d":false,"cat":"剧情,爱情,冒险","cnms":0,"dir":"李柯","dur":94,"id":1197460,"imax":false,"img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","late":false,"nm":"沙漠之心","pn":68,"preSale":1,"rt":"本周五上映","sc":0,"scm":"沙漠越野赛，飙车为求爱","showDate":"","showInfo":"2016-12-02 本周五上映","sn":0,"snum":17,"src":"","star":"隋咏良,尤靖茹,薛祺","time":"","vd":"","ver":"2D","wish":3070},{"3d":false,"cat":"剧情","cnms":0,"dir":"万玛才旦","dur":120,"id":337708,"imax":false,"img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","late":false,"nm":"塔洛","pn":44,"preSale":1,"rt":"下周五上映","sc":0,"scm":"牧羊人进城，打碎纯真梦","showDate":"","showInfo":"2016-12-09 下周五上映","sn":0,"snum":433,"src":"","star":"西德尼玛,杨秀措,扎西","time":"","vd":"","ver":"2D","wish":2164},{"3d":false,"cat":"剧情,悬疑","cnms":0,"dir":"毕赣","dur":113,"id":342073,"imax":false,"img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","late":false,"nm":"路边野餐","pn":95,"preSale":0,"rt":"2016-07-15上映","sc":8.1,"scm":"离家把侄寻，帮人带书信","showDate":"","showInfo":"今天暂无场次","sn":0,"snum":6053,"src":"","star":"陈永忠,郭月,余世学","time":"","vd":"","ver":"2D","wish":5647},{"3d":false,"cat":"战争,历史,剧情","cnms":0,"dir":"刘星,胡明钢,于兰","dur":94,"id":1189048,"imax":false,"img":"http://p0.meituan.net/165.220/movie/91b3eb5fd8ea1f15e6a4a6c35842f63389899.jpg","late":false,"nm":"遵义会议","pn":0,"preSale":0,"rt":"2016-10-10上映","sc":0,"scm":"红军历万难，决战生死间","showDate":"","showInfo":"今天暂无场次","sn":0,"snum":443,"src":"","star":"佟瑞欣,郭伟华,马晓伟","time":"","vd":"","ver":"2D","wish":331}]}
     * status : 0
     */

    private int status;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        private boolean hasNext;
        /**
         * 3d : true
         * cat : 冒险,奇幻,家庭
         * cnms : 0
         * dir : 大卫·叶茨
         * dur : 133
         * id : 248918
         * imax : true
         * img : http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg
         * late : false
         * nm : 神奇动物在哪里
         * pn : 236
         * preSale : 0
         * rt : 2016-11-25上映
         * sc : 9
         * scm : 神奇动物城，法师显超能
         * showDate :
         * showInfo : 今天158家影院放映1994场
         * sn : 0
         * snum : 107198
         * src :
         * star : 埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔
         * time :
         * vd :
         * ver : 3D/IMAX 3D/中国巨幕
         * wish : 130686
         */

        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            @com.google.gson.annotations.SerializedName("3d")
            private boolean value3d;
            private String cat;
            private int cnms;
            private String dir;
            private int dur;
            private int id;
            private boolean imax;
            private String img;
            private boolean late;
            private String nm;
            private int pn;
            private int preSale;
            private String rt;
            private int sc;
            private String scm;
            private String showDate;
            private String showInfo;
            private int sn;
            private int snum;
            private String src;
            private String star;
            private String time;
            private String vd;
            private String ver;
            private int wish;

            public boolean isValue3d() {
                return value3d;
            }

            public void setValue3d(boolean value3d) {
                this.value3d = value3d;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getSc() {
                return sc;
            }

            public void setSc(int sc) {
                this.sc = sc;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }
}
