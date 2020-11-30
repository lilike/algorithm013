package com.lilike.daily;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author llk
 * @Date 2020/11/4 15:28
 * @Version 1.0
 */
public class Router {

    public static void main(String[] args) {

        String endpointStr = "http://127.0.0.1:8080;http://127.0.0.1:8081;http://127.0.0.1:8082";

        List<String> endpoints = Arrays.asList(endpointStr.split(";"));

        int size = endpoints.size();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }



    }

}
