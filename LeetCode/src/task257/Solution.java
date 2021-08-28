package task257;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> dfsResult = new ArrayList<>();
        dfs(root, new ArrayList<>(), dfsResult);
        List<String> result = new ArrayList<>();

        for (List<Integer> list: dfsResult) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer element: list) {
                stringBuilder.append(element);
                stringBuilder.append("->");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            result.add(stringBuilder.toString());
        }

        return result;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> pathsList) {
        path.add(node.val);
        if (node.left != null) {
            dfs(node.left, new ArrayList<>(path), pathsList);
        }
        if (node.right != null) {
            dfs(node.right, new ArrayList<>(path), pathsList);
        }
        if (node.right == null && node.left == null) {
            pathsList.add(new ArrayList<>(path));
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(2);
//        node2.right = node5;
//        TreeNode root = new TreeNode(1, node2, node3);
//
//        System.out.println(solution.binaryTreePaths(root));
//    }