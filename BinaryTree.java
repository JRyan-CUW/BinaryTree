package com.example.jacobryan.binarytree;

/**
 * Created by JacobRyan on 4/5/17.
 */

public class BinaryTree
{
    private Node root;

    public BinaryTree()
    {
        root = null;
    }

    public void add(Node node)
    {
        if(root == null)
        {
            this.root = node;
            this.root.getLeftNode().setPayload(0);
            this.root.getRightNode().setPayload(0);
        }
        else
        {
            Node cur = this.root;
            while(cur.getPayload() != 0)
            {
                if(node.getLeftNode().getPayload() <= cur.getPayload())
                {
                    if(cur.getLeftNode().getPayload() == 0)
                    {
                        cur.setLeftNode(cur);
                        cur.setPayload(0);
                    }
                    else
                    {
                        cur = cur.getLeftNode();
                    }
                }
                else
                {
                    if(cur.getRightNode().getPayload() == 0)
                    {
                        cur.setRightNode(cur);
                        cur.setPayload(0);
                    }
                    else
                    {
                        cur = cur.getRightNode();
                    }
                }
                node.getLeftNode().setPayload(0);
                node.getRightNode().setPayload(0);
            }
        }
    }
}
