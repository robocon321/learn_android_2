package com.example.learnandroid2.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid2.R;
import com.example.learnandroid2.activity.SqliteTodoActivity;
import com.example.learnandroid2.utils.Task;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private SqliteTodoActivity context;
    private ArrayList<Task> list;
    private int resource;

    public TaskAdapter(SqliteTodoActivity context, ArrayList<Task> list, int resource){
        this.context = context;
        this.list = list;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if(view == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, null);
            viewHolder.txtTitle = view.findViewById(R.id.txtTitle);
            viewHolder.imgEdit = view.findViewById(R.id.imgEdit);
            viewHolder.imgDelete = view.findViewById(R.id.imgDelete);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(list.get(position).getId());
            }
        });

        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.todo_edit);
                EditText editUpdate = dialog.findViewById(R.id.editUpdate);
                Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
                Button btnCancel = dialog.findViewById(R.id.btnCancel);

                Task task = list.get(position);
                editUpdate.setText(task.getTitle());
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        update(new Task(task.getId(),editUpdate.getText().toString()));
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
        });

        viewHolder.txtTitle.setText(list.get(position).getTitle());
        return view;
    }

    public void remove(int id){
        context.database.query("DELETE FROM TASKS WHERE id = "+id);
        context.getData();
    }

    public void update(Task task){
        context.database.query("UPDATE TASKS SET task = '"+ task.getTitle() +"' WHERE id = "+ task.getId());
        context.getData();
    }

    private class ViewHolder{
        TextView txtTitle;
        ImageView imgEdit, imgDelete;
    }
}
