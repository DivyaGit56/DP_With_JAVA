class Solution {
    public int superEggDrop(int k, int n) {
        // base case
        if(n == 0||n==1)return n;
        if(k == 1)return n;

        int min = Integer.MAX_VALUE;
        
        for(int x = 1; x<=n; x++){
            int temp = 1+Math.max(superEggDrop(k-1,x-1),superEggDrop(k,n-x));
            min = Math.min(min,temp);
        }
        return min;
    
    }
}
