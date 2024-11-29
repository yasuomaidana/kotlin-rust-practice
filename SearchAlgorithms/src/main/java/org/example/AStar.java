package org.example;

import java.util.*;

public class AStar {
    HeuristicFunction heuristic;

    Graph graph;
    List<Node> path;
    Position start;
    Position end;

    AStar(Map map, HeuristicFunction heuristic) {
        this.graph = Graph.from_map(map);
        this.heuristic = heuristic;
        this.start = new Position(map.start[0], map.start[1]);
        this.end = new Position(map.end[0], map.end[1]);
    }

    public void find_path() {
        Node start_node = this.graph.get_node(this.start);
        Node end_node = this.graph.get_node(this.end);

        HashMap<Node, Node> cameFrom = new HashMap<>();

        // gScore is the cost of the cheapest path from start to the node
        HashMap<Node, Integer> gScore = new HashMap<>();
        // fScore is the cost of the cheapest path from start to the node that passes through the node
        HashMap<Node, Integer> fScore = new HashMap<>();

        PriorityQueue<Node> openSet = new PriorityQueue<>(
                Comparator.comparingInt(a -> fScore.getOrDefault(a, Integer.MAX_VALUE)));

        HashSet<Node> closedSet = new HashSet<>();

        openSet.add(start_node);
        gScore.put(start_node, 0);
        fScore.put(start_node, gScore.get(start_node) + heuristic.calculate(start_node, end_node));
        
        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            closedSet.add(current);

            if (current.equals(end_node)) {
                this.path = reconstruct_path(cameFrom, current);
                return;
            }

            for (Node neighbor : current.neighbours) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }
                int tentative_gScore = gScore.get(current) + neighbor.value;
                if (!openSet.contains(neighbor) || tentative_gScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentative_gScore);
                    fScore.put(neighbor, tentative_gScore + heuristic.calculate(neighbor, end_node));

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }

        }

    }

    private List<Node> reconstruct_path(HashMap<Node, Node> cameFrom, Node current) {
        List<Node> total_path = new java.util.ArrayList<>();
        total_path.add(current);
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            total_path.add(current);
        }
        return total_path;
    }

    public void print_path() {
        StringBuilder sb = new StringBuilder();
        for (Node node : this.path.reversed()) {
            sb.append(node.position.toString());
            sb.append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb);
    }
    
    public int path_cost(){
        return this.path.stream().mapToInt(node -> node.value).sum();
    }
    

}
