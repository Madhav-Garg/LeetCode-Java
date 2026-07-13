class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return n;
        }
        
        int maxLength = 1;
        int anchor = 0;
        
        for (int i = 1; i < n; i++) {
            int c = Integer.compare(arr[i - 1], arr[i]);
            
            if (c == 0) {
            
                anchor = i;
            } else if (i == n - 1 || c * Integer.compare(arr[i], arr[i + 1]) >= 0) {

                maxLength = Math.max(maxLength, i - anchor + 1);
                anchor = i;
            }
        }
        
        return maxLength;
    }
}