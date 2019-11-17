package com.example.rycyclerview08102019;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Monanadapter monanadapter;
    ArrayList<Monan> monanArrayList;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerview);
        builder= new AlertDialog.Builder(MainActivity.this);
        monanArrayList= new ArrayList<>();
        monanArrayList.add(new Monan("Coffee","Coffee thom ngon vo cung",R.drawable.coffee));
        monanArrayList.add(new Monan("Cavienchien","Coffee thom ngon vo cung",R.drawable.cavienchien));
        monanArrayList.add(new Monan("Comboxuclac","Coffee thom ngon vo cung",R.drawable.comboxuclac));
        monanArrayList.add(new Monan("Comgachien","Coffee thom ngon vo cung",R.drawable.comgachien));
        monanArrayList.add(new Monan("Tea","Coffee thom ngon vo cung",R.drawable.tea));
        monanadapter= new Monanadapter(monanArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(monanadapter);

        ((Monanadapter)(Objects.requireNonNull(recyclerView.getAdapter()))).Onclicklongtimelistener(new Onlistener() {
            @Override
            public boolean setlongtimeOnlistener(View v, final int position) {
                builder.setTitle("Ban muon xoa mon an nay khong?");
               builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                             monanArrayList.remove(position);
                             monanadapter.notifyDataSetChanged();
                           }
                       });
               builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
                       builder.show();
                return true;
            }

            @Override
            public void setonlickonlistener(View v, int position) {
                Toast.makeText(MainActivity.this, monanArrayList.get(position).getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
