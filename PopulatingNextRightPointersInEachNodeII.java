/*
// Asked in Microsoft

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Follow up:
    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
};
*/

class Solution {
    
    Node getLeftMostNext(Node root)
    {
        if (root == null)
            return root;
        if (root.left != null)
            return root.left;
        if (root.right != null)
            return root.right;
        return getLeftMostNext(root.next);
    }
    
    Node getRightMostInLeft(Node root)
    {
        if (root == null || root.next == null)
            return root;
        return getRightMostInLeft(root.next);
    }
    
    void interconnect(Node left, Node right)
    {
        if (left == null || right == null)
            return;
        left.next = right;
        
        // For each next level -> find rightmost in Left and leftmost in Right tree
        // If we have leftmost node in Left, we can reach to rightmost using next
        Node leftMost_left = (left.left == null) ? left.right : left.left;
        Node leftMost_right = (right.left == null) ? right.right : right.left;
        
        while (leftMost_left != null && leftMost_right != null)
        {
            Node nextL = getLeftMostNext(leftMost_left);
            Node nextR = getLeftMostNext(leftMost_right);
            Node rightMostinLeft = getRightMostInLeft(leftMost_left);
            rightMostinLeft.next = leftMost_right;
            
            leftMost_left = nextL;
            leftMost_right = nextR;
        }
    }
    
    public Node connect(Node root) {
        // Recursive: 1ms 41.7MB
        if (root == null)
            return root;
        connect(root.right);
        connect(root.left);        
        interconnect(root.left, root.right);

        // Iterative: 0ms 38.6MB
        /*
        Node curr = root;
        Node firstInLevel = null;
        Node prevInLevel = null;
        
        while (curr != null)
        {
            if (curr.left != null)
            {
                if (firstInLevel == null)
                {
                    firstInLevel = curr.left;
                }
                else
                {
                    prevInLevel.next = curr.left;
                }
                prevInLevel = curr.left;
            }
            
            if (curr.right != null)
            {
                if (firstInLevel == null)
                {
                    firstInLevel = curr.right;
                }
                else
                {
                    prevInLevel.next = curr.right;
                }
                prevInLevel = curr.right;
            }

            curr = curr.next;

            // change level
            if (curr == null)
            {
                curr = firstInLevel;
                firstInLevel = null;
                prevInLevel = null;
            }
        }
        */        

        return root;
    }
}

/*
Hard Inputs:
[-2,-9,0,3,5,-1,9,5,2,null,null,-3,null,-7,6,-6,null,null,null,-1,null,null,null,-9,9,null,null,null,null,8,null,-2,5]
[7,-10,2,-4,3,-8,null,null,null,null,-1,11]
*/