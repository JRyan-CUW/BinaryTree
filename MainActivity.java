package com.example.jacobryan.binarytree;

import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed;
    private BinaryTree bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ed = (EditText)this.findViewById(R.id.inputEd);
    }

    public void addTreeButtonClicked (View v)
    {
        String st = ed.getText().toString();
        int in = Integer.parseInt(st);
        Node node = new Node(in);
        bt.add(node);
    }
}
