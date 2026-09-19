class Solution {
    public int balancedString(String s) {
        int n=s.length();
        int need=n/4;
        int[] count=new int[4];
        for(char c:s.toCharArray()){
            if(c=='Q') count[0]++;
            else if(c=='W') count[1]++;
            else if(c=='E') count[2]++;
            else count[3]++;
        }
        if(count[0]==need&&count[1]==need&&count[2]==need&&count[3]==need) return 0;
        int left=0;
        int ans=n;
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            if(c=='Q') count[0]--;
            else if(c=='W') count[1]--;
            else if(c=='E') count[2]--;
            else count[3]--;
            while(count[0]<=need&&count[1]<=need&&count[2]<=need&&count[3]<=need){
                ans=Math.min(ans,right-left+1);
                char x=s.charAt(left);
                if(x=='Q') count[0]++;
                else if(x=='W') count[1]++;
                else if(x=='E') count[2]++;
                else count[3]++;
                left++;
            }
        }
        return ans;
    }
}