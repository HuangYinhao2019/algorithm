package leetcode.daily.daily4;

import java.util.*;

/**
 * @author liusandao
 * @description Day5
 * @date 2020-4-5 13:21
 */
public class Day5 {

    class LFUCache {

        private Map<Integer,Integer> map;
        private Map<Integer,Integer> map1;
        private Map<Integer,Integer> map2;
        private int capacity;
        private int now = 0;
        private int times = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            this.now = 0;
            this.times = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)){
                int count = map1.get(key)+1;
                map1.put(key,count);
                this.times++;
                return map.get(key);
            }
            else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(this.now < this.capacity){
                map.put(key,value);
                map1.put(key,0);
                map2.put(key,times);
            }
            else{
                Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
                for (Map.Entry entry : entries) {

                }

            }
        }
    }

}
