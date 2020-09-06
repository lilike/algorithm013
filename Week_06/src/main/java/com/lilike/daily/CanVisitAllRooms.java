package com.lilike.daily;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms/
 * 钥匙和房间
 *
 * @Author llk
 * @Date 2020/8/31 13:43
 * @Version 1.0
 */
public class CanVisitAllRooms {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0) return false;
        boolean[] roomVisited = new boolean[rooms.size()];
        _canVisitAllRooms(rooms, 0, roomVisited);
        for (int i = 0; i < roomVisited.length; i++) {
            if (!roomVisited[i]) {
                return false;
            }
        }
        return true;
    }

    private void _canVisitAllRooms(List<List<Integer>> rooms, int roomNum, boolean[] roomVisited) {

        // 访问过了就不访问了
        if (roomVisited[roomNum] == true) return;
        roomVisited[roomNum] = true;
        List<Integer> keys = rooms.get(roomNum);

        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            _canVisitAllRooms(rooms,key,roomVisited);
        }
    }

    public static void main(String[] args) {


    }


}
