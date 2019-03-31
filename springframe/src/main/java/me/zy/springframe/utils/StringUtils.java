package me.zy.springframe.utils;

public class StringUtils {
    /**
     * 字符串首字母转为小写字母
     * @param targetString
     * @return
     */
    public static String toFirstCharLowerCase(String targetString){
        if(!isEmpty(targetString)){
            char[] charArray = targetString.toCharArray();
            //大小写字母ASCII码值相差32
            //大写字母ASCII要小于小写字母
            //对字符串字母进行大小写转换，其实就是对字母的ASCII值进行计算
            charArray[0] +=32;
            return String.valueOf(charArray);
        }else{
            return null;
        }
    }


    public static boolean isEmpty(String targetString){
        if(targetString == null || targetString.equals("")){
            return true;
        }else {
            return  false;
        }
    }
}
