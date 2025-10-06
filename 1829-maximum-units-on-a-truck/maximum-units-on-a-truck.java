class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);

        int result = 0;

        for(int[] storage : boxTypes){
            int box = storage[0];
            int unit = storage[1];
            if(truckSize >= box){
                result += (box * unit);
                truckSize -= box; 
            }else{
                result += (truckSize * unit);
                break;
            }
        }

        return result;
    }
}