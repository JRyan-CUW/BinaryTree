package com.example.jacobryan.binarytree;

/**
 * Created by JacobRyan on 4/5/17.
 */

public class Node
{
    private Integer payload;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer payload)
    {
        this.payload = payload;
        this.rightNode = null;
        this.leftNode = null;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
