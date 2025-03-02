import java.util.Stack;

public class ZigZagPath1372 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class State {
        public TreeNode currNode;
        public Boolean takeLeft;
        public Integer currZigZagPathCount;

        public State(TreeNode currNode, Boolean takeLeft, Integer currZigZagPathCount) {
            this.currNode = currNode;
            this.takeLeft = takeLeft;
            this.currZigZagPathCount = currZigZagPathCount;
        }

        @Override
        public String toString() {
            return "State [currNode=" + currNode + ", takeLeft=" + takeLeft + ", currZigZagPathCount="
                    + currZigZagPathCount + "]";
        }

    }

    public int longestZigZag(TreeNode root) {
        Stack<State> stateSpaceStack = new Stack<State>();
        Integer result = 0;
        if (root.left != null) {
            stateSpaceStack.add(new State(root.left, false, 1));
            stateSpaceStack.add(new State(root.left, true, 0));
        }
        if (root.right != null) {
            stateSpaceStack.add(new State(root.right, true, 1));
            stateSpaceStack.add(new State(root.right, false, 0));
        }

        while (!stateSpaceStack.empty()) {

            State currItem = stateSpaceStack.pop();
            result = Math.max(currItem.currZigZagPathCount, result);
            if (currItem.takeLeft) {
                if (currItem.currNode.left != null) {
                    stateSpaceStack
                            .add(new State(currItem.currNode.left, false, currItem.currZigZagPathCount + 1));
                } else if (currItem.currNode.right != null) {
                    stateSpaceStack
                            .add(new State(currItem.currNode.right, true, 1));
                }
            } else if (!currItem.takeLeft) {
                if (currItem.currNode.right != null) {
                    stateSpaceStack
                            .add(new State(currItem.currNode.right, true, currItem.currZigZagPathCount + 1));
                } else if (currItem.currNode.left != null) {
                    stateSpaceStack
                            .add(new State(currItem.currNode.left, false, 1));
                }
            }
        }

        return result;
    }
}
