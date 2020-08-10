package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adaptor_class extends RecyclerView.Adapter<Adaptor_class.modelViewHolder> {

    Context mcontext;
    List<Model_class> item_list;

    public Adaptor_class(Context mcontext, List<Model_class> item_list) {
        this.mcontext = mcontext;
        this.item_list = item_list;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercardview,parent,false);
        return new modelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {
            holder.title.setText(item_list.get(position).getTitle());
            holder.description.setText(item_list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder{

        TextView title,description;
        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textview1);
            description = (TextView) itemView.findViewById(R.id.textview2);
        }
    }
}
