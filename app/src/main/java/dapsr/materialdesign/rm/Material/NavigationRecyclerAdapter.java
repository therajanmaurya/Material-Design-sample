package dapsr.materialdesign.rm.Material;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import dapsr.materialdesign.rm.R;

/**
 * Created by rajan on 23-03-2015.
 */
public class NavigationRecyclerAdapter extends RecyclerView.Adapter<NavigationRecyclerAdapter.MyViewHolder> {
    List<NavigationItemInformation> data= Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    public NavigationRecyclerAdapter(Context context, List<NavigationItemInformation> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row, parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavigationItemInformation current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
