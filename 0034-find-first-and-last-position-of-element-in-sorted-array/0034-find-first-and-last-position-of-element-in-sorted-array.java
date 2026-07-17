class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    private int findFirst(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int firstIdx = -1;
        
        while (st <= end) {
            int mid = st + (end - st) / 2;
            
            if (nums[mid] == target) {
                firstIdx = mid;
                end = mid - 1; 
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstIdx;
    }
    private int findLast(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int lastIdx = -1;
        
        while (st <= end) {
            int mid = st + (end - st) / 2;
            
            if (nums[mid] == target) {
                lastIdx = mid;
                st = mid + 1; 
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastIdx;
    }
}