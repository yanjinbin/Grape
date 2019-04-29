package com.yanjinbin.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
/*    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> r = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return r;
        int size = Math.min(nums1.length, k);
        int[] index = new int[size];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            Integer s1 = o1[0] + o1[1];
            Integer s2 = o2[0] + o2[1];
            return s1.compareTo(s2);
        });
        for (int i = 0; i < size; i++) {
            queue.add(new int[]{nums1[i], nums2[0], i});
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            r.add(new int[]{pair[0], pair[1]});
            int id = pair[2];
            if (++index[id] < nums2.length)
                queue.add(new int[]{nums1[id], nums2[index[id]], id});
            count++;
            if (count == k)
                break;
        }
        return r;
    }*/

    public String longestPalindrome(String s) {
        //  长度为1，返回当前串
        if (s.length() == 1) {
            return s;
        }
        //长度为2并且两个字符相等则返回
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        //用于标记isLongestPalindrome[j][i]即从j到i是否是回文串；
        //如isLongestPalindrome[1][5]＝＝true则表示字符串索引位置从1到5的子串是回文串。
        boolean[][] isLongestPalindrome = new boolean[s.length()][s.length()];
        //最长回文串初始最大为0
        int maxlen = 0;
        //对应的maxlen的开始索引位置
        int beginIndex = 0;
        //对应的maxlen的结束索引位置
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j >= 0) {
                //满足上述的第三个条件，即当前s.charAt(i)==s.charAt(j)并
                //且s[j＋1到i－1]也是回文串
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isLongestPalindrome[j + 1][i - 1])) {
                    isLongestPalindrome[j][i] = true;
                    if (maxlen < i - j + 1) {
                        beginIndex = j;
                        lastIndex = i + 1;
                        maxlen = i - j + 1;
                    }
                }
                j--;
            }
        }
        return s.substring(beginIndex, lastIndex);
    }


    List<String> res = new ArrayList<>();
    Map<Character, String[]> map = new HashMap<>();
    String str = "";
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        dfs(digits,0);
        return res;
    }
    public void dfs(String digits, int step) {
        if (step == digits.length()) {
            res.add(str);
            return;
        }
        char c = digits.charAt(step);
        String[] strArray = map.get(c);
        for (String s : strArray) {
            str += s;
            dfs(digits, step + 1);
            str = str.substring(0, str.length() - 1);
        }
    }

}