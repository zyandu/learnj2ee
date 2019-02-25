package me.zy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
    public static void main(String[] args){
        String fileNmRegex = "\\d{4}([0]{1}[1-9]{1}|[1]{1}[012]{1})([0]{1}[1-9]{1}|[12]{1}\\d{1}|[3]{1}[01]{1})_SCDHSQ_.*?(\\.xls|\\.xlsx)";
        //String fileNmRegex = "\\d{4}([0]{1}[1-9]{1}|[1]{1}[012]{1})([0]{1}[1-9]{1}|[12]{1}\\d{1}|[3]{1}[01]{1})_SCDHSQ_.*?\\.xls";

        Pattern patternProduct = Pattern.compile(fileNmRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcherProduct = patternProduct.matcher("20181025_SCDHSQ_0001.xlsx");
        System.out.println("CNVS正则规则匹配："+matcherProduct.matches());


    }
}
