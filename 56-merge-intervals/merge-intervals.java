class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        int[] currInterval = intervals[0]; 
        result.add(currInterval);

        for(int[] nextInterval : intervals){
            int startNext = nextInterval[0];
            int endNext = nextInterval[1];

            int startCurr = currInterval[0];

            if(currInterval[1] >= startNext){
                currInterval[1] = Math.max(currInterval[1], endNext);
            }else{
                currInterval = nextInterval;
                result.add(currInterval);
            }

        }

        return result.toArray(new int[result.size()][]);
    }
}