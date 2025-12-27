class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int[] currInterval = intervals[0];
        result.add(currInterval);

        for(int[] nextInterval : intervals){
            int currentEnd = currInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if(nextStart <= currentEnd ){
                currInterval[1] = Math.max(currentEnd, nextEnd);
            }else{
                currInterval = nextInterval;
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}