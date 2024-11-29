package org.example;

public class Main {

    public static void main(String[] args) {
        int[][] map = {
                {0, 1, 3, 8},
                {1, 2, 1, 10},
                {1, Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
                {2, 2, 2, 5}
        };
        int[] start = {0, 0};
        int[] end = {2, 3};
        Map map1 = new Map(map, start, end);
        map1.print_map();

        Graph graph = Graph.from_map(map1);
        Node start_node = graph.get_node(1, 1);
        System.out.println(start_node);

        HeuristicFunction heuristic = (Node a, Node b) ->
                Math.abs(a.position.x - b.position.x) + Math.abs(a.position.y - b.position.y);

        AStar a_star = new AStar(map1, heuristic);
        a_star.find_path();
        a_star.print_path();
        map1.print_solution(a_star.path);

        System.out.println("===========Second map==========");
        Map map2 = getMap2();
        AStar a_star2 = new AStar(map2, heuristic);
        a_star2.find_path();
        map2.print_solution(a_star2.path);
        System.out.println("Solution cost is: " + a_star2.path_cost());

        System.out.println("===========Second map: Dijkstra==========");
        HeuristicFunction dijkstra_heuristic = (Node _, Node _) -> 0;
        AStar dijkstra = new AStar(map2, dijkstra_heuristic);
        dijkstra.find_path();
        map2.print_solution(dijkstra.path);
        System.out.println("Solution cost is: " + dijkstra.path_cost());
        
    }

    private static Map getMap2() {
        int[][] grid = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 0, 1}};

        // Source is the left-most bottom-most corner
        int[] src = {8, 0};

        // Destination is the left-most top-most corner
        int[] dest = {0, 0};
        return new Map(grid, src, dest);
    }
}