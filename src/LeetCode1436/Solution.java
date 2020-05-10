package LeetCode1436;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {

    List<Integer>[] graph;

    public String destCity(List<List<String>> paths) {
        graph = new List[201];
        for (int i = 0; i < 201; i++) {
            graph[i] = new ArrayList();
        }

        Map<String, Integer> map = new HashMap();
        Map<Integer, String> m = new HashMap();
        int c = 1;
        for (List<String> path : paths) {
            for (String string : path) {
                if (!map.containsKey(string)) {
                    map.put(string, c);
                    m.put(c, string);
                    c++;
                }
            }
        }

        for (List<String> path : paths) {
            graph[map.get(path.get(0))].add(map.get(path.get(1)));
        }
        String ans = null;
        Stack<Integer> s = new Stack();
        s.add(1);
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (!graph[cur].isEmpty()) {
                for (Integer u : graph[cur]) {
                    s.add(u);
                }
            } else {
                ans = m.get(cur);
            }
        }
        return ans;
    }
}
