class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int j = 1;

        for(int i = 0; i < n/2; i++){
            res[i] = -j;
            res[i+n/2] = j;
            ++j;
        } 

        if(n % 2 != 0){
            res[n-1] = 0;
        }

        return res;
    }
}