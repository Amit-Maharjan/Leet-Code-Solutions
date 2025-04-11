package com.company.TopInterview150.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTree(words);

        Set<String> resSet = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(board,m,n,resSet,root,i,j);
            }
        }

        return new ArrayList<>(resSet);
    }

    private Node buildTree(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                int index = c-'a';
                if (curr.children[index]==null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
            curr.completeWord = word;
        }
        return root;
    }

    private void dfs(char[][] board, int m, int n, Set<String> resSet, Node node, int i, int j) {
        if (i<0 || m<=i || j<0 || n<=j || board[i][j]=='#' || node.children[board[i][j]-'a']==null) {
            return;
        }

        if (node.children[board[i][j]-'a'].completeWord!=null) {
            resSet.add(node.children[board[i][j]-'a'].completeWord);
        }

        node = node.children[board[i][j]-'a'];
        char c = board[i][j];
        board[i][j] = '#';

        dfs(board,m,n,resSet,node,i-1,j);
        dfs(board,m,n,resSet,node,i+1,j);
        dfs(board,m,n,resSet,node,i,j-1);
        dfs(board,m,n,resSet,node,i,j+1);

        board[i][j] = c;
    }

    class Node {
        Node[] children;
        String completeWord;

        Node() {
            children = new Node[26];
            completeWord = null;
        }
    }
}
