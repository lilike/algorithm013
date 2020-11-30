package com.lilike.homework;


import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author llk
 * @Date 2020/11/20 9:07
 * @Version 1.0
 */
public class AccountsMerge {

    int count;

    int[] parent;



    /**
     * 依然使用并查集去解决问题
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        count = n;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (isOneAccount(accounts.get(i),accounts.get(j))) {
                    union(j,i);
                }
            }
        }

        Map<Integer,List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rootI = find(i);
            if (rootI == i) {
                map.put(i,accounts.get(i));
            }else {
                List<String> list = map.get(rootI);
                if (list == null) {
                    list = accounts.get(rootI);
                }
                Set<String> rootISet = new LinkedHashSet<>(list.subList(1, list.size()));
                rootISet.addAll(new LinkedHashSet<>(accounts.get(i).subList(1,accounts.get(i).size())));
                List<String> newList = new ArrayList<>();
                newList.add(list.get(0));
                newList.addAll(rootISet);
                map.put(rootI,newList);
            }

        }

        return new ArrayList<>(map.values());
    }

    private boolean isOneAccount(List<String> account01, List<String> account02) {
        int count = 0;
        Set<String> set = new HashSet<>(account01);
        for (String s : account02) {
            if (set.contains(s)) {
                count++;
            }
        }

        return count > 1;
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
    }


    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {

        String[][] str = {{"John", "johnsmith@mail.com", "john00@mail.com"},
                          {"John", "johnnybravo@mail.com"},
                          {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                          {"Mary", "mary@mail.com"}};

        List<List<String>> list = new ArrayList<>();
        for (String[] strings : str) {
            list.add(Arrays.asList(strings));
        }
        List<List<String>> lists = new AccountsMerge().accountsMerge(list);
        System.out.println(lists);
    }


}
