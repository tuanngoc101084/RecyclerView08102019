package com.example.rycyclerview08102019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Monanadapter monanadapter;
    ArrayList<Monan> monanArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerview);
        monanArrayList= new ArrayList<>();
        monanArrayList.add(new Monan("Coffee","Coffee thom ngon vo cung",R.drawable.coffee));
        monanArrayList.add(new Monan("Cavienchien","Coffee thom ngon vo cung",R.drawable.cavienchien));
        monanArrayList.add(new Monan("Comboxuclac","Coffee thom ngon vo cung",R.drawable.comboxuclac));
        monanArrayList.add(new Monan("Comgachien","Coffee thom ngon vo cung",R.drawable.comgachien));
        monanArrayList.add(new Monan("Tea","Coffee thom ngon vo cung",R.drawable.tea));
        monanadapter= new Monanadapter(monanArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(monanadapter);
    }
}
