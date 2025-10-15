class Solution {
    int[] prefix;
    int total;
    public Solution(int[] w) {
        prefix = new int[w.length];
        total = 0;

        prefix[0] = w[0];

        for(int i = 1; i < w.length; i++){
            prefix[i] = w[i] + prefix[i-1];
        }

        total = prefix[prefix.length - 1];
    }
    
    public int pickIndex() {
        int target = 1 + (int)(Math.random() * total);
        int l = 0;
        int r = prefix.length -1;

        while(l < r){
            int m = l + (r-l)/2;

            if(prefix[m] < target){
                l = m + 1;
            }else{
                r = m;
            }
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */