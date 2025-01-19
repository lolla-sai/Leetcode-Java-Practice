import java.util.Stack;

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

public class CountGoodNodes1448 {
    class Solution {
        public int goodNodes(TreeNode root) {
            Integer result = 0;
            Stack<TreeNode> currNodeStack = new Stack<TreeNode>();
            currNodeStack.add(root);
            Stack<Integer> maxValueOnPath = new Stack<Integer>();
            maxValueOnPath.add(root.val);
            while (currNodeStack.size() > 0) {
                TreeNode currNode = currNodeStack.pop();
                Integer currMaxAlongPath = maxValueOnPath.pop();
                if (currNode.val >= currMaxAlongPath) {
                    result++;
                }

                // add the left node with the max value
                if (currNode.left != null) {
                    currNodeStack.add(currNode.left);
                    maxValueOnPath.add(Math.max(currNode.left.val, currMaxAlongPath));
                }

                if (currNode.right != null) {
                    // add the right node with the max value
                    currNodeStack.add(currNode.right);
                    maxValueOnPath.add(Math.max(currNode.right.val, currMaxAlongPath));
                }
            }
            return result;
        }
    }
}
