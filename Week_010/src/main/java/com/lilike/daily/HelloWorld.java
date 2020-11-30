package com.lilike.daily;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author llk
 * @Date 2020/10/18 10:38
 * @Version 1.0
 */
public class HelloWorld {

    public static void main(String[] args) {
        String reg = "^[0-9]*";
        String s = "454848_生成数据仓库_事实表（fact_ec_ldp_logistics_bill_dtl）_202009231535171600846517.log";
        Pattern p2 = Pattern.compile(reg);
        Matcher m2 = p2.matcher(s);
        if(m2.find()){
            System.out.println(m2.group(0));  // 组提取字符串
        }
    }

}
