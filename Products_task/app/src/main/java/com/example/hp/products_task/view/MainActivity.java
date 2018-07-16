package com.example.hp.products_task.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hp.products_task.R;
import com.example.hp.products_task.controller.Controller;
import com.example.hp.products_task.model.Adapter.RecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context mContext;
    private Controller mcontroller;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        mcontroller=new Controller(MainActivity.this,recyclerView);
        mcontroller.startFetching();
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mContext = getApplicationContext();
        TextView tv = new TextView(mContext);
        // Initialize a new LayoutParams object
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT  // Height of TextView
        );

        tv.setLayoutParams(lp);
        try{
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            // Set the action bar custom view
            getSupportActionBar().setCustomView(tv);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        tv.setText("products");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(24);

    }

}
