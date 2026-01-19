class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        
        int[] currInterval = intervals[0];
        list.add(currInterval);

        for(int[] nextInterval : intervals){
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if(nextStart <= currInterval[1]){
                currInterval[1] =  Math.max(nextEnd, currInterval[1]);
            }else{
                currInterval = nextInterval;
                list.add(currInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
/*
1--->3
   2---->6
              8--->10
                       15--->18
*/