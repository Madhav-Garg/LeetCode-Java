class Solution {
    public int findNumbers(int[] nums) {
        int evendigit = 0;
        for(int num : nums){
            int len = String.valueOf(num).length();
            if(len%2==0){
                evendigit++;
            }
        }
        return evendigit;
    }
}