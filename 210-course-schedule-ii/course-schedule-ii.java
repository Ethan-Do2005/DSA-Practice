class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //Step 1
        List<List<Integer>> table = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            table.add(new ArrayList<>());
        }

        for(int[] pres: prerequisites){
            int index = pres[1];
            int list = pres[0];

            table.get(index).add(list);
            indegree[list] += 1;
        }

        //Step 2
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int value = q.poll();  
            res[index++] = value;
            for(int v : table.get(value)){
                if(--indegree[v] == 0) q.offer(v);
            }
        }


        return (index == numCourses) ? res : new int[]{};

    }
}