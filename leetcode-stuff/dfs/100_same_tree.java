/**
 * LeetCode 100. Same Tree
 * Topics: Depth-First search
 * 
 * Link: https://leetcode.com/problems/same-tree/description/?envType=problem-list-v2&envId=depth-first-search
 */

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
    // Private  method to do depth-first search
    private boolean depthFirstSearchCompare(TreeNode p, TreeNode q) {
        boolean result, leftSearch, rightSearch;
        // Compare the values
        if (p.val == q.val) {
            result = true;
        } else { result = false; }

        // Check subtrees
        // Left search
        if (p.left != null && q.left != null) {
            leftSearch = depthFirstSearchCompare(p.left, q.left);
        } else if (p.left == null && q.left == null) {
            // no sub trees -> good
            leftSearch = true;
        } else { leftSearch = false;};
        
        // Right search
        if (p.right != null && q.right != null) {
            rightSearch = depthFirstSearchCompare(p.right, q.right);
        } else if (p.right == null && q.right == null) {
            rightSearch = true;
        } else { rightSearch = false;};

        return result && leftSearch && rightSearch;
    };

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //Base case:
        if (p == null && q == null) {
            return true;
        } else if (( p != null && q == null ) || (p == null && q != null)){
            return false;
        } else {
            // Traverse tree p and if there is an unmatched node -> return false
            return depthFirstSearchCompare(p, q);
        }
    }
    
    // Cleaner solutoin
    public boolean isSameTreeCleaner(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    // both empty → same
        if (p == null || q == null) return false;   // only one empty → different
        if (p.val != q.val) return false;           // values differ → different

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}