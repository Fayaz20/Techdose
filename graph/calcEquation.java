class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<Double, String>>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            graph.putIfAbsent(s1, new ArrayList<>());
            graph.putIfAbsent(s2, new ArrayList<>());
            graph.get(s1).add(new Pair<>(value, s2));
            graph.get(s2).add(new Pair<>(1/value, s1));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String s1 = query.get(0);
            String s2 = query.get(1);
            if (!graph.containsKey(s1) || !graph.containsKey(s2)) {
                ans[i] = -1.0;
                continue;
            }
            if (s1.equals(s2)) {
                ans[i] = 1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            visited.add(s1);
            ans[i] = dfs(s1, s2, graph, visited, 1.0);
        }
        
        return ans;
    }
    
    public double dfs(String s1, String s2, Map<String, List<Pair<Double, String>>> graph, Set<String> visited, double q) {
        double p = -1.0;
        for (Pair<Double, String> nb: graph.get(s1)) {
            double value = nb.getKey();
            String node = nb.getValue();
            if (visited.contains(node)) continue;
            visited.add(node);
            if (node.equals(s2)) {
                p = q * value;
                break;
            }
            p = dfs(node, s2, graph, visited, q * value);
            if (p != -1) break;
            visited.remove(node);
        }
        
        return p;
    }
}