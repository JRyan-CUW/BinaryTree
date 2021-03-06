package com.example.jacobryan.binarytree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private EditText inputET;
    private ViewGroup theTree;
    private BinaryTree bt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.theTree = (ViewGroup)this.findViewById(R.id.theTree);

        //6, 5, 4, 7, 5, 3, 7,5
        this.bt = new BinaryTree(this.theTree, this);
    }

    public void addButtonPressed(View v) {
        this.bt.add(Integer.parseInt(this.inputET.getText().toString()));
    }

    public void inOrderTraverseButtonPressed(View v)
    {
        Core.theQ.clear();
        this.bt.visitInOrder();
        for(String s : Core.theQ)
        {
            System.out.print(s + ",");
        }
        System.out.println("");
    }

    public void getDepthButtonPressed(View v)
    {
        System.out.println("Depth: " + this.bt.getDepth());
    }
}
