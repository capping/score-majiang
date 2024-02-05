package com.sevengod.score.domain.vo;

import java.util.HashMap;
import java.util.Map;

public class TokenInfo {
    private static final ThreadLocal<Map<String, Integer>> THREAD_LOCAL = new ThreadLocal<>();

    // 判断线程map是否为空，为空就添加一个
    public static Map<String, Integer> getLocalMap() {
        Map<String, Integer> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(8);
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void set(String key, Integer val) {
        Map<String, Integer> map = getLocalMap();
        map.put(key, val);
    }

    public static Integer get(String key) {
        Map<String, Integer> map = getLocalMap();
        return map.get(key);
    }
}
