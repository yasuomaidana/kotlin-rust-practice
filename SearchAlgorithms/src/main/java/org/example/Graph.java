package org.example;

import java.util.HashMap;

public class Graph {
    HashMap<Position, Node> nodes = new HashMap<>();
    
    static Graph from_map(Map map) {
        Graph graph = new Graph();
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                int val = map.map[i][j];
                if (val == Integer.MAX_VALUE) {
                    continue;
                }
                Node node = new Node(val, i, j);
                graph.nodes.put(node.position, node);
            }
        }
        for (Position position: graph.nodes.keySet()) {
            Node node = graph.nodes.get(position);
            for (int[] child_position: map.get_children(position)) {
                Position child_position_obj = new Position(child_position[0], child_position[1]);
                Node child = graph.get_node(child_position_obj);
                node.add_child(child);
            }
        }
        return graph;
    }
    
    Node get_node(Position position) {
        return this.nodes.get(position);
    }
    
    Node get_node(int x, int y) {
        return this.get_node(new Position(x, y));
    }
}
