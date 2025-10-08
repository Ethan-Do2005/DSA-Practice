class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //Step 1: create List and add on [0] in [1] index
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        //Step 2: Count freq in each List of adj
        int[] inDegree = new int[numCourses];
        for(int u = 0; u < numCourses; u++)
            for(int v : adj.get(u)) inDegree[v]++;

        //Step 3: Create Deque to add index == 0 in inDegree
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        //Step 4: Check
        int taken = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            taken++;
            //For loop inside is reverse of step 2
            for(int v : adj.get(u)){
                if(--inDegree[v] == 0) q.offer(v);
            }
        }

        return taken == numCourses;

    }
}