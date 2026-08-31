package ravi.algo.concepts;

import java.util.*;

public class UnionFindList {

    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public UnionFindList() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    // Path compression
    public int find(int x) {

        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }

        return parent.get(x);
    }

    // Union by rank
    public boolean union(int x, int y) {

        // Create nodes if they don't exist
        parent.putIfAbsent(x, x);
        parent.putIfAbsent(y, y);

        rank.putIfAbsent(x, 0);
        rank.putIfAbsent(y, 0);

        // IMPORTANT: Find roots first
        int px = find(x);
        int py = find(y);

        // Already in the same component
        if (px == py) {
            return false;
        }

        // Attach smaller-rank tree under larger-rank tree
        if (rank.get(px) > rank.get(py)) {

            parent.put(py, px);

        } else if (rank.get(px) < rank.get(py)) {

            parent.put(px, py);

        } else {

            // Same rank: choose either root
            parent.put(py, px);

            rank.put(px, rank.get(px) + 1);
        }

        return true;
    }

    public Map<Integer, Integer> getParents() {
        return parent;
    }
}