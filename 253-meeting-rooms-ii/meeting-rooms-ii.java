class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        if(n == 0) return 0;
        int[] s1 = new int[n];
        int[] e1 = new int[n];


        int i = 0;

        for(int[] interval : intervals){
            int s = interval[0];
            int e = interval[1];

            s1[i] = s;
            e1[i] = e;
            i++;
        }

        Arrays.sort(s1);
        Arrays.sort(e1);

        int a = 0, b = 0;
        int count = 0;
        int max = 0;
        while(a < n){
            if(s1[a] < e1[b]){
                count++;
                a++;
            }else if(s1[a] == e1[b]){
                a++;
                b++;
            }else{
                count--;
                b++;
            }
            max = Math.max(count, max);
        }

        return max;


    }
}