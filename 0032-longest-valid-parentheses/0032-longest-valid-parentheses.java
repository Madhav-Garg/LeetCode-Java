class Solution {
    public int longestValidParentheses(String s) {
        int maxlen=0;
        int n=s.length();
        Stack<Integer> st=new Stack<>();   
        st.push(-1);
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxlen=Math.max(maxlen,i-st.peek());
                }
            }
        }
        return maxlen;
    }
}