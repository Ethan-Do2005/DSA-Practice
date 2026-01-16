class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] curInterval = intervals[0];
        result.add(curInterval);

        for(int[] nextInterval : intervals){
            int startNext = nextInterval[0];
            int endNext = nextInterval[1];

            if(startNext <= curInterval[1]){
                curInterval[1] = Math.max(curInterval[1], endNext);
            }else{
                curInterval = nextInterval;
                result.add(curInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
/*
intervals = [[1,3],[2,6],[8,10],[15,18]]

1-->3
  2----->6 
             8-->10
                      15--->18
Output: [[1,6],[8,10],[15,18]]

What is the range length of intervals
1 <= intervals.length <= 10^4

unsorted
Apprach for this one Using ArrayList
startCurrent, endCurrent
startNext, endNext
1-->6

O(nlogn) time complexity and O(n) space complexity
*/