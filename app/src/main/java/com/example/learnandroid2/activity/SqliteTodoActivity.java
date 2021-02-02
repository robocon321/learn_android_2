package com.example.learnandroid2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.learnandroid2.R;
import com.example.learnandroid2.adapter.TaskAdapter;
import com.example.learnandroid2.utils.Database;
import com.example.learnandroid2.utils.Task;

import java.util.ArrayList;

public class SqliteTodoActivity extends AppCompatActivity {
    ListView lvTodo;
    ArrayList<Task> tasks;
    TaskAdapter adapter;
    public static Database database;
    Task currentTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_todo);
        addControls();
     }

    public void addControls(){
        database = new Database(this, "ghichu.sqlite", null, 1);
        database.query("CREATE TABLE IF NOT EXISTS TASKS(id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR(50))");

        tasks = new ArrayList<>();
        adapter = new TaskAdapter(this, tasks, R.layout.layout_todo);
        getData();

        lvTodo = findViewById(R.id.lvTodo);
        lvTodo.setAdapter(adapter);
    }

    public void getData(){
        tasks.clear();
        Cursor cursor = database.get("SELECT * FROM TASKS");
        while(cursor.moveToNext()){
            tasks.add(new Task(cursor.getInt(0), cursor.getString(1)));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.todo_add);
            EditText editAdd = dialog.findViewById(R.id.editAdd);
            Button btnAdd = dialog.findViewById(R.id.btnAdd);
            Button btnCancel = dialog.findViewById(R.id.btnCancel);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.query("INSERT INTO TASKS(task) VALUES('"+editAdd.getText()+"')");
                    getData();
                    dialog.dismiss();
                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo, menu);
        return super.onCreateOptionsMenu(menu);
    }
}