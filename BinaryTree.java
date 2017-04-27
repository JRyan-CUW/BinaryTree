package com.example.jacobryan.binarytree;

    import android.content.Context;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import java.util.LinkedList;


    /**
     * Created by michaellitman on 4/6/17.
     */

    public class BinaryTree
    {
        public boolean isSet;
        private int payload;
        private char position;
        private int depth;
        private ViewGroup theTreeView;
        private Context context;
        private BinaryTree leftTree;
        private BinaryTree rightTree;

        //Added for HW 15**********************************
        private BinaryTree parent;

        public BinaryTree(ViewGroup theTreeView, Context context)
        {
            this.theTreeView = theTreeView;
            this.isSet = false;
            this.depth = 0;
            this.position = 'M';
            this.leftTree = null;
            this.rightTree = null;
            this.context = context;
            this.parent = null;
        }

        public BinaryTree(int payload, int depth, char position, ViewGroup theTreeView, Context context)
        {
            this(theTreeView, context);
            this.payload = payload;
            this.depth = depth;
            this.position = position;
            this.isSet = true;
        }

        //Added for HW 15*********************************************
        public String locationToParent()
        {
            if(this.parent.rightTree == this)
            {
                return "right";
            }
            else if(this.parent.leftTree == this)
            {
                return "left";
            }
            return "root";
        }

        public boolean isOutOfBalance()
        {
            int leftDepth = 0;
            int rightDepth = 0;
            if(this.leftTree != null)
            {
                leftDepth = this.leftTree.getDepth();
            }
            if(this.rightTree != null)
            {
                rightDepth = this.rightTree.getDepth();
            }


            //Added for HW 15
            int difference = Math.abs(leftDepth - rightDepth);
            if(difference > 1)
            {
                System.out.println(outOfBalanceSide());
                return true;
            }
            return false;
            //*******************************************





        }

        public String outOfBalanceSide()
        {
            int leftDepth = 0;
            int rightDepth = 0;
            if(this.leftTree != null)
            {
                leftDepth = this.leftTree.getDepth();
            }
            if(this.rightTree != null)
            {
                rightDepth = this.rightTree.getDepth();
            }

            if(rightDepth > leftDepth && isOutOfBalance())
            {
                return "Right";
            }
            else if(leftDepth > rightDepth && isOutOfBalance())
            {
                return "Left";
            }
            else
            {
                return "Balanced";
            }
        }


        public int getDepth()
        {
            int leftDepth = 0;
            int rightDepth = 0;
            if(this.leftTree != null)
            {
                leftDepth = 1 + this.leftTree.getDepth();
            }
            if(this.rightTree != null)
            {
                rightDepth = 1 + this.rightTree.getDepth();
            }

            if(rightDepth > leftDepth)
            {
                return rightDepth;
            }
            else
            {
                return leftDepth;
            }
        }

        public void visitInOrder()
        {
            if(this.leftTree != null)
            {
                this.leftTree.visitInOrder();
            }
            Core.theQ.addLast("" + this.payload);
            if(this.rightTree != null)
            {
                this.rightTree.visitInOrder();
            }
        }

        private void addTextViewToTree(String lexJSON)
        {
            TextView tv = new TextView(this.context);
            tv.setText(lexJSON);
            this.theTreeView.addView(tv);
        }

        public boolean add(int payload)
        {
            if(!this.isSet)
            {
                this.payload = payload;
                this.addTextViewToTree(this.toLexicalJSON());
                this.isSet = true;
                return true;
            }
            else
            {
                if(payload <= this.payload)
                {
                    //add this payload to the left
                    if(this.leftTree == null)
                    {
                        this.leftTree = new BinaryTree(payload, this.depth+1, 'L', theTreeView, this.context);
                        this.addTextViewToTree(this.leftTree.toLexicalJSON());
                        return true;
                    }
                    else
                    {
                        //I have a left tree, and I'm going to ask him to
                        //add the payload to himself.
                        return this.leftTree.add(payload);
                    }
                }
                else
                {
                    //add this payload to the right
                    if(this.rightTree == null)
                    {
                        this.rightTree = new BinaryTree(payload, this.depth+1, 'R', this.theTreeView, this.context);
                        this.addTextViewToTree(this.rightTree.toLexicalJSON());
                        return true;
                    }
                    else
                    {
                        //I have a right tree, and I'm going to ask him to
                        //add the payload to himself.
                        return this.rightTree.add(payload);
                    }
                }
            }
        }

        private String toLexicalJSON()
        {
            String json = "{\"depth\":" + this.depth + ", \"position\":\"" + this.position + "\", \"payload\":" + this.payload + "}";
            return json;
        }

        public void display()
        {
            if(this.isSet)
            {
                System.out.println(this.payload);
                if(this.leftTree != null)
                {
                    this.leftTree.display();
                }
                if(this.rightTree != null)
                {
                    this.rightTree.display();
                }
            }
            else
            {
                System.out.println("Empty Tree");
            }
        }
    }
