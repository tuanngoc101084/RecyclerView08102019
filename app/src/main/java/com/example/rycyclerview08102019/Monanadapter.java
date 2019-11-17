package com.example.rycyclerview08102019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Monanadapter extends RecyclerView.Adapter<Monanadapter.MonanViewHolder> {
    public Monanadapter(ArrayList<Monan> arrayList) {
        this.arrayList = arrayList;
    }
    private  Onlistener onlistener;
    private ArrayList<Monan> arrayList= new ArrayList<>();
    @NonNull
    @Override
    public MonanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item_layout_monan,null);
        return new MonanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonanViewHolder holder, final int position) {
        Monan monnan= arrayList.get(position);
        holder.img.setImageResource(monnan.getHinhanh());
        holder.txtTen.setText(monnan.getTen());
        holder.txtMota.setText(monnan.getMota());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onlistener.setlongtimeOnlistener(v,position);
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onlistener.setonlickonlistener(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }

    class MonanViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView txtTen,txtMota;
        public MonanViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.imageviewhinh);
            txtTen= itemView.findViewById(R.id.textten);
            txtMota= itemView.findViewById(R.id.textmota);
        }
    }
    public  void Onclicklongtimelistener(Onlistener onlistener)
    {
        this.onlistener= onlistener;

    }
}
