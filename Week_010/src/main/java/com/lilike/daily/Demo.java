package com.lilike.daily;

/**
 * @Author llk
 * @Date 2020/11/12 10:41
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        String str = "com.carnation.moc.neo4j.dal.neo4j.entity.resource.relational.ColumnEntity";
        String substring = str.substring(str.lastIndexOf(".") + 1);
        System.out.println(substring);

    }

}
