class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();

        int[] intervalCurr = intervals[0];
        list.add(intervalCurr);

        for(int[] intervalNext : intervals){
            int startNext = intervalNext[0];
            int endNext = intervalNext[1];

            if(startNext <= intervalCurr[1]){
                intervalCurr[1] = Math.max(intervalCurr[1], endNext);
            }else{
                intervalCurr = intervalNext;
                list.add(intervalCurr);
            }
        }

        int[][] result = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}