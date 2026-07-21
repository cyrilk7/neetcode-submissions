class Solution {
    Set<Integer> visited = new HashSet();
    private HashMap<Integer, List<Integer>> graph = new HashMap();

    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList());
        }

        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, -1});
        visited.add(0);

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0], prev = cur[1];

            for (int nei : graph.get(node)){
                if (prev == nei) continue;

                if (visited.contains(nei)) return false;

                visited.add(nei);
                q.offer(new int[]{nei, node});
            }
        }

        return visited.size() == n;

    }


}
