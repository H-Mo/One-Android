package in.leob.one.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author leobin
 * @time 2016/11/10  9:55
 * @desc 获取对应格式的时间
 */
public class DateUtil {
    public static String getDate(Date date){
       SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");//20161110
       return format.format(date);
    }
}
