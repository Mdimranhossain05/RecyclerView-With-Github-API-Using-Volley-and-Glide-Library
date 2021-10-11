package com.example.volleylibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder> {

    private Context context;
    private User[] users;

    public MyAdapter(Context context, User[] users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sample_user_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        User user = users[position];
        holder.name.setText(user.getLogin());
        Glide.with(context).load(user.getAvatarUrl()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin() +" was clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(),WebviewActivity.class);
                i.putExtra("url",user.getHtmlUrl().toString());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgUser);
            name = itemView.findViewById(R.id.txtUser);

        }
    }

}
