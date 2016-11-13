package in.leob.one.util;

/**
 * @author leobin
 * @time 2016/11/9  19:32
 * @desc 接口
 */
public class OneApi {
    //首页接口
    public static String getOneTodayHome(String date){
        return "http://rest.wufazhuce.com/OneForWeb/one/getHp_N?strDate=" + date +"&strRow=1";
    }

    //文章接口
    public static String getOneTodayArticle(String date,int count){
        return "http://rest.wufazhuce.com/OneForWeb/one/getC_N?strDate=" + date + "&strRow=" + count;
    }

    //问答接口
    public static String getOneTodayQuestion(String date,int count){
        return "http://rest.wufazhuce.com/OneForWeb/one/getQ_N?strDate="+ date+ "&strRow=" + count;
    }
}
