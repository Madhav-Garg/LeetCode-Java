class Solution {
    public static ArrayList<Integer> NSL(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                ans.add(-1);
            }
            else if(!st.isEmpty() && arr[st.peek()]<arr[i]){
                ans.add(st.peek());
            }
            else if(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans.add(-1);
                }
                else ans.add(st.peek());
            }
            st.push(i);
        }
        return ans;
    }
    public static ArrayList<Integer> NSR(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans.add(n);
            }
            else if(!st.isEmpty() && arr[st.peek()]<arr[i]){
                ans.add(st.peek());
            }
            else if(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans.add(n);
                }
                else ans.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
    public int MAH(int[] arr){
        ArrayList<Integer> left=NSL(arr);
        ArrayList<Integer> right=NSR(arr);
        int n=arr.length;
        int[] width=new int[n];
        int[] area=new int[n];
        for(int i=0;i<n;i++){
            width[i]=right.get(i)-left.get(i)-1;
        }
        for(int i=0;i<n;i++){
            area[i]=arr[i]*width[i];
        }
        int max_area=area[0];
        for(int i=1;i<n;i++){
            if(area[i]>max_area){
                max_area=area[i];
            }
        }
        return max_area;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] histogram=new int[m];
        //for first row
        for(int i=0;i<m;i++){
            histogram[i]=matrix[0][i]-'0';
        }
        int max=MAH(histogram);
        //for remaining rows
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]== '0'){
                    histogram[j]=0;
                }
                else{
                    histogram[j]+=1;
                }
            }
            max=Math.max(max, MAH(histogram));
        }
        return max;
    }
}