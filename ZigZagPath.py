# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


def move(node, takeLeft, count):
    if node is None:
        return count
    if takeLeft:
        return max(move(node.left, not takeLeft, count+1),move(node.right, takeLeft, 0))
    else:
        return max(move(node.right, not takeLeft, count+1),move(node.left, takeLeft, 0))


class Solution:
    def longestZigZag(self, root) -> int:
        if root.left is not None and root.right is not None:
            return max(move(root.left, False, 0),move(root.right, True, 0))
        elif root.left is None:
            return move(root.right, True, 0)
        elif root.right is None:
            return move(root.left, False, 0)
