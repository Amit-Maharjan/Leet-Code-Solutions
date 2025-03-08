package com.company.TopInterview150.DivideAndConquer;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return consTree(grid, n, 0, 0);
    }

    private Node consTree(int[][] grid, int n, int x, int y) {
        boolean isSame = true;
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                if (grid[x][y]!=grid[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) return new Node(grid[x][y]==1, true);

        n = n/2;
        Node node = new Node();
        node.topLeft = consTree(grid, n, x, y);
        node.topRight = consTree(grid, n, x, y+n);
        node.bottomLeft = consTree(grid, n, x+n, y);
        node.bottomRight = consTree(grid, n, x+n, y+n);
        return node;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
