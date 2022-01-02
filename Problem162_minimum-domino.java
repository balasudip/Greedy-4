// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0)
            return 0;
        int result = check(tops, bottoms, tops[0]);
        if(result != -1) {
            return result;
        }
        return check(tops, bottoms, bottoms[0]);
    }
    private int check(int[] tops, int[] bottoms, int target) {
        int topRot = 0, bottomRot = 0;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topRot++;
            if(bottoms[i] != target) bottomRot++;
        }
        return Math.min(topRot, bottomRot);
    }
}