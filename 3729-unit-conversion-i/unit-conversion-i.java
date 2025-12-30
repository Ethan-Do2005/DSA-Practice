class Solution {
    int MOD = 1_000_000_007;
    List<int[]>[] graph;
    int[] result;

    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;

        graph = new ArrayList[n];
        //Create empty value in array list
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //Contains value into array list
        for(int[] conv : conversions){
            graph[conv[0]].add(new int[]{conv[1], conv[2]});
        }

        result = new int[n];
        result[0] = 1;
        dfs(0);

        return result;
    }

    private void dfs(int node){
        for(int[] neightbor : graph[node]){
            int next = neightbor[0];
            int factor = neightbor[1];

            if(result[next] == 0 && next != 0){
                result[next] = (int) ((long) result[node] * factor % MOD);
                dfs(next);
            }
        }
    }
}
/*
Understanding concep it is kind of transparent money
for example  [[0,1,2], [1,2,3]]
Sign: [0] means Type 0, [1] means Type 1
Always: [0] = 1
for [0,1,2] => [1] = 2 x [0] = 2 x 1 = 2
for [1,2,3] => [2] = 3 x [1] = 3 x 2 = 6

What they waant is to return each an array with its index is its Type
For that example return =>[Type 0, Type 1, Type 2] = [1, 2, 6]
*/