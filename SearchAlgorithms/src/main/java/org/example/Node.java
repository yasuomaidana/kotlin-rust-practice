package org.example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbours = new ArrayList<>();
    int value;
    Position position;

    Node(int value, int x, int y) {
        this.value = value;
        this.position = new Position(x, y);
    }
    
    @Override
    public int hashCode() {
        return this.position.hashCode();
    }

    public void add_child(Node child) {
        this.neighbours.add(child);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        sb.append("-");
        sb.append(this.position.toString());
        if (this.neighbours.isEmpty()) {
            return sb.toString();
        }
        sb.append(": { ");
        for (Node child: this.neighbours) {
            sb.append(child.value);
            sb.append("-").append(child.position.toString());
            sb.append(" , ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
