class Solution {
    int MOD = 1_000_000_007;
    List<int[]>[] graph;
    long[] result;
    public int[] baseUnitConversions(int[][] conversions) {
        int maxNode = 0;
        for(int[] conver : conversions){
            maxNode = Math.max(maxNode, Math.max(conver[0], conver[1]));
        }
        int n = maxNode + 1;

        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] conv : conversions){
            graph[conv[0]].add(new int[]{conv[1], conv[2]});
        }

        result = new long[n];
        Arrays.fill(result, -1);
        
        result[0] = 1;
        dfs(0);

        int[] finalResult = new int[n];
        for(int i = 0; i < n; i++){
            if(result[i] == -1){
                finalResult[i] = 0;
            }else{
                finalResult[i] = (int) result[i];
            }
        }

        return finalResult;

    }
    
    private void dfs(int node){
        for(int[] neighbor : graph[node]){
            int nextNode = neighbor[0];
            int factor = neighbor[1];

            if(result[nextNode] == -1){
                result[nextNode] = (result[node] * factor) % MOD;
                dfs(nextNode);
            }
        }
    }
}
/*
[sourceUnit] = conversionFactor * [targetUnit]
[0] = 1

[1] = 2 * [0] = 2;
[2] = 3 * [0] = 3;
[3] = 4 * [1] = 8;
[4] = 5 * [1] = 10;
[5] = 2 * [2] = 6;

My approach: is using the weighted directed graph 
3 Phase
Phase 1: Size (based on maximum node)
Phase 2: Building adjancent list 
graph[0]: {[1,2]}
graph[1]: {[2,3]}
Phase 3: setting first node as 1 and going with dfs to traverse the parent to child
Phase 4: return into

Time and Space Complexity is O(V + E) where V is the nodes (units) and E is the edge case
*/