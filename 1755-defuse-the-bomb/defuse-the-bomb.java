class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[code.length];

        if(k ==0){
            return result;
        }

        for(int i = 0; i < code.length; i++){
            int sum = 0;
            if(k > 0){
                for(int j = 1; j <= k; j++){
                    sum += code[(i+j) % n]; 
                }
            }
            
            if (k < 0){
                for(int j = 1 ; j <= -k ; j++){
                    sum += code[(i-j+n) % n];
                }
            }
                            
            result[i] = sum;
        }

        return result;
    }
}
