package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    int[][] map;
    int[] start;
    int[] end;

    public Map(int[][] map, int[] start, int[] end) {
        this.map = map;
        this.start = start;
        this.end = end;
    }

    public void print_map() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int val = this.map[i][j];
                if (val == Integer.MAX_VALUE) {
                    System.out.print(" * ");
                } else if (val == 0) {
                    if (i == start[0] && j == start[1]) {
                        System.out.print("\u001B[34m S \u001B[0m");
                    } else if (i == end[0] && j == end[1]) {
                        System.out.print("\u001B[31m E \u001B[0m");
                    } else {
                        System.out.print(" 0 ");
                    }
                } else if (val < 5) {
                    System.out.print(" - ");
                } else if (val < 10) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<int[]> get_children(Position position) {
        return get_children(new int[]{position.x, position.y});
    }

    public ArrayList<int[]> get_children(int[] position) {
        int[] to_eval = {-1, 0, 1};
        ArrayList<int[]> children = new ArrayList<>();
        for (int i : to_eval) {
            for (int j : to_eval) {
                int ip = position[0] + i;
                int jp = position[1] + j;
                if (i == 0 && j == 0) {
                    continue;
                }
                if (ip >= 0 && ip < map.length && jp >= 0 && jp < map[0].length && map[ip][jp] != Integer.MAX_VALUE) {
                    children.add(new int[]{ip, jp});
                }
            }
        }
        return children;
    }

    public void print_solution(List<Node> path) {
        Position start = path.getFirst().position;
        Position end = path.getLast().position;
        HashSet<Position> solution = path.stream().map(node -> node.position)
                .collect(Collectors.toCollection(HashSet::new));

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int val = this.map[i][j];
                if (val == Integer.MAX_VALUE) {
                    System.out.print(" * ");
                } else if (start.equals(new Position(i, j))) {
                    System.out.print("\u001B[34m S \u001B[0m");
                } else if (end.equals(new Position(i, j))) {
                    System.out.print("\u001B[31m E \u001B[0m");
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (solution.contains(new Position(i, j))) {
                        sb.append("\u001B[32m");
                    }
                    if (val == 0) {
                        sb.append(" 0 ");
                    } else if (val < 5) {
                        sb.append(" - ");
                    } else if (val < 10) {
                        sb.append(" + ");
                    } else {
                        sb.append(" # ");
                    }
                    if (solution.contains(new Position(i, j))) {
                        sb.append("\u001B[0m");
                    }
                    System.out.print(sb);
                }
            }
            System.out.println();
        }
    }
}
