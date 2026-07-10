class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String num = String.valueOf(x);
        String rev = new StringBuilder(num).reverse().toString();
        return num.equals(rev);
    }
}