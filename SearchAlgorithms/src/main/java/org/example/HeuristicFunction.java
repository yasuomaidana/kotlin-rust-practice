package org.example;

@FunctionalInterface
public interface HeuristicFunction {
    int calculate(Node a, Node end);
}
