class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // dist[i] = shortest known distance from source 'k' to node i.
        // Initially every node is unreachable (infinity).
        int[] dist = new int[n + 1];
        int posInf = Integer.MAX_VALUE;
        Arrays.fill(dist, posInf);

        // Distance from source to itself is always 0.
        dist[k] = 0;

        // Priority Queue stores:
        // [node, shortestDistanceFromSource]
        //
        // IMPORTANT:
        // It DOES NOT store edge weights.
        // We always process the node having the minimum known distance first.
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{k, 0});

        // Adjacency List
        //
        // graph[u] = list of (neighbor, edgeWeight)
        //
        // Example:
        // 2 -> [(1,5), (3,2)]
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build the graph.
        for (int[] edge : times) {

            int u = edge[0];
            int v = edge[1];
            int edgeWeight = edge[2];

            // If this node has no adjacency list yet,
            // create an empty one.
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }

            // Add one outgoing edge.
            graph.get(u).add(new int[]{v, edgeWeight});
        }

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currNode = curr[0];

            // Distance carried by this PQ entry.
            int currDist = curr[1];

            // IMPORTANT (We discussed this a lot)
            //
            // The PQ can contain multiple entries for the SAME node.
            //
            // Example:
            // (5,10)
            // (5,7)
            //
            // The second one is better.
            //
            // When (5,10) is popped later,
            // it is an outdated entry.
            //
            // So simply ignore it.
            if (currDist > dist[currNode]) {
                continue;
            }

            // Some nodes may not have outgoing edges.
            // graph.get(node) would return null.
            if (graph.containsKey(currNode)) {

                for (int[] neigh : graph.get(currNode)) {

                    int neighNode = neigh[0];

                    // Weight of ONLY this edge.
                    int edgeWeight = neigh[1];

                    // -----------------------------
                    // RELAXATION STEP
                    // -----------------------------
                    //
                    // This is the heart of Dijkstra.
                    //
                    // Source ----currDist----> currentNode ----edgeWeight----> neighbor
                    //
                    // Candidate distance =
                    // current shortest distance
                    //        +
                    // edge weight
                    //
                    // We originally got confused here by writing:
                    //
                    // dist[currNode] + currDist
                    //
                    // That adds the current distance twice.
                    //
                    // Correct idea:
                    // currDist + edgeWeight

                    if (currDist + edgeWeight < dist[neighNode]) {

                        // Found a better path.
                        dist[neighNode] = currDist + edgeWeight;

                        // IMPORTANT
                        //
                        // Updating dist[] does NOT automatically update
                        // the priority queue.
                        //
                        // Therefore push a NEW entry.
                        //
                        // Old entries will automatically be ignored later
                        // because of the "outdated entry" check above.
                        pq.offer(new int[]{neighNode, dist[neighNode]});
                    }
                }
            }
        }

        // Network delay time means:
        // When does the LAST node receive the signal?
        //
        // Therefore answer = maximum shortest distance.
        //
        // If even one node is unreachable,
        // answer = -1.

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == posInf) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}