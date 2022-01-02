// Time Complexity: O(nlogm)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int shortestWay(String source, String target) {
        int tl = target.length();
        int sl = source.length();
        int i = 0; // on target string
        int pos = 0; // source string pointer
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int k = 0; k < sl; k++) {
            char c = source.charAt(k);
            if(!map.containsKey(c))
                map.put(c, new ArrayList<>());
            map.get(c).add(k);
        }
        // abcdad -> source
        
        // aabacb -> target
        // {
        //     a: [0, 4]
        //     b: [1]
        //     c: [2]
        //     d: [3, 5]
        // }
        
        
        int result = 1;
        while(i < tl) {
            if(!map.containsKey(target.charAt(i))) return -1;
            // find the corresponding index of my current char of target with closest binary search in the list of indices of that char in my map
            List<Integer> li = map.get(target.charAt(i)); // list of indices
            int k = Collections.binarySearch(li, pos); // searching for the closest index
            // this k is the index of list
            if(k < 0)
                k = -k - 1;
            if(k == li.size()) {
                result++;
                pos = 0;
            } else {
                pos = li.get(k) + 1;
                i++;
            }
        }
        return result;
    }
}