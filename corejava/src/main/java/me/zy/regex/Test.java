package me.zy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args){
        //\d{4}([0]{1}[1-9]{1}|[1]{1}[012]{1})([0]{1}[1-9]{1}|[12]{1}\d{1}|[3]{1}[01]{1})_SCDHSQ_.*?\.xls

        Pattern patternProduct = Pattern.compile("zsmx[^f]*?\\.dbf",Pattern.CASE_INSENSITIVE);
        Matcher matcherProduct = patternProduct.matcher("ZSMX.DBF");
        System.out.println("生产 ~ ZSMX正则规则匹配："+matcherProduct.matches());

        System.out.println("");

        //Pattern me.zy.pattern = Pattern.compile("zsmx[^fk]*?\\.dbf",Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("zsmx(f[^k]|[^f]).*?\\.dbf",Pattern.CASE_INSENSITIVE);
        pattern = patternProduct;
        Matcher matcher = pattern.matcher("zsmx.DBF");
        System.out.println("ZSMX正则规则匹配zsmx："+matcher.matches());

        matcher = pattern.matcher("ZSMX0.DBF");
        System.out.println("ZSMX正则规则匹配ZSMX0.DBF："+matcher.matches());

        matcher = pattern.matcher("ZSMXa.DBF");
        System.out.println("ZSMX正则规则匹配ZSMXa.DBF："+matcher.matches());

        matcher = pattern.matcher("ZSMX0815.DBF");
        System.out.println("ZSMX正则规则匹配ZSMX0815.DBF："+matcher.matches());

        matcher = pattern.matcher("ZSMX20180815.DBF");
        System.out.println("ZSMX正则规则匹配ZSMX20180815.DBF："+matcher.matches());

        matcher = pattern.matcher("ZSMXk20180815.DBF");
        System.out.println("ZSMX正则规则匹配ZSMXk20180815.DBF："+matcher.matches());

        //========== ZSMXFK文件测试 =========
        System.out.println("");

        Pattern pattern1 = Pattern.compile("zsmxfk.*?\\.dbf",Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher("ZSMX.DBF");
        System.out.println("ZSMXFK正则规则匹配ZXMX："+matcher1.matches());


        matcher1 = pattern1.matcher("ZSMXfk.DBF");
        System.out.println("ZSMXFK正则规则匹配ZXMXFK："+matcher1.matches());

    }

}
