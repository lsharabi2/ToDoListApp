package com.example.user.todolistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        String[] my_items = {"Task one", "Task two", "Task three", "Task four", "Task five"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, my_items);

        ListView theListView = (ListView) findViewById(R.id.mylistView);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String itemPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(TaskListActivity.this, itemPicked, Toast.LENGTH_SHORT).show();
            }
        });

        button = (Button) findViewById(R.id.AddTask);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(TaskListActivity.this, CreateTaskActivity.class);
                startActivity(myIntent);
            }
        });

    }
}

