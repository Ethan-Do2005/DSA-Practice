class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
        int max = 0;
        for(int[] boxType : boxTypes){
            int box = boxType[0];
            int unit = boxType[1];

            if(truckSize >= box){
                max += box * unit;
                truckSize -= box;
            }else{
                max += truckSize * unit;
                break;
            }
        }

        return max;
    }
}
/*
Time complexity: O(nlogn) - sort is nlogn and for loop is n
Space complexity: O(n) to store again in the sort 
*/