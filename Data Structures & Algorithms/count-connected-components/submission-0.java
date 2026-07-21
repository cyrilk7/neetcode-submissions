class Solution {
    private HashMap<Integer, List<Integer>> graph = new HashMap();
    Set<Integer> visited = new HashSet();

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList());
        }

        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for (int i = 0; i < n; i++){
            if (!visited.contains(i)){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node){
        visited.add(node);

        for (int nei : graph.get(node)){
            if (visited.contains(nei)) continue;

            dfs(nei);
        }
    }
}
