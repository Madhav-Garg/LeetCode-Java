class Solution {
    public boolean EvenDigit(int nums){
        int digits = 0;
        while(nums!=0){
            nums=nums/10;
            digits++;
        }
        return digits%2==0;
    }
    public int findNumbers(int[] nums) {
        int evendigit = 0;
        for(int i=0;i<nums.length;i++){
            if(EvenDigit(nums[i])){
                evendigit++;
            }
        }
        return evendigit;
    }
}