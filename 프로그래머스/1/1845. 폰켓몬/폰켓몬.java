import java.util.*;
class Solution {
    public int solution(int[] nums) {
        float length = (float) nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i< nums.length;i++){
            set.add(nums[i]);
        }
        float size = (float)set.size();
        if(size<=length) return (int)size;
        return (int)length;
    }
}