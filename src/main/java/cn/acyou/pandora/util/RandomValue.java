package cn.acyou.pandora.util;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * copy from : https://www.jianshu.com/p/cc8d567ebda5
 * @author youfang
 * @version [1.0.0, 2018-8-27 下午 10:54]
 **/
public class RandomValue {

    public static String getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        String name = Surname[index]; //获得一个随机的姓氏
        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
        if(i==2){
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = name + girl.substring(j, j + 2);
            } else {
                name = name + girl.substring(j, j + 1);
            }

        }
        else{
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = name + boy.substring(j, j + 2);
            } else {
                name = name + boy.substring(j, j + 1);
            }

        }

        return name;
    }

    public static Integer getAge(){
        Random random = new Random();
        return random.nextInt(100);
    }

    /**
     *
     * @param numberFlag 是否数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        StringBuilder retStr = new StringBuilder();
        String strTable = numberFlag ? "1234567890"
                : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = new StringBuilder();
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr.append(strTable.charAt(intR));
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr.toString();
    }

    /**
     * 递归生成指定长度的随机字符串
     * @param length 长度
     * @return 字符串
     */
    public static String createRandomStr(int length) {
        String str = UUID.randomUUID().toString().replace("-","");
        if (length < str.length()){
            return str.substring(str.length() - length);
        }
        return str + createRandomStr(length - str.length());
    }

    /**
     * 随机 0 or 1
     * @return  0 or 1
     */
    public static int random01(){
        Random r = new Random();
        return r.nextInt(2);
        //return Math.random() > 0.5 ? 1 : 0;
    }

    public static Date randomRangeDate(String startStr, String endStr) {
        long startTime = (new DateTime(startStr)).toDate().getTime();
        long endTime = (new DateTime(endStr)).toDate().getTime();
        double randomDate = Math.random() * (double)(endTime - startTime) + (double)startTime;
        DateTime random = new DateTime(Math.round(randomDate));
        return random.toDate();
    }

    public static Date randomDate() {
        return randomRangeDate("1990-01-01", "2018-12-31");
    }

    public static void main(String[] args) {
        System.out.println(RandomValue.getName());
        System.out.println(RandomValue.getAge());
    }

}
