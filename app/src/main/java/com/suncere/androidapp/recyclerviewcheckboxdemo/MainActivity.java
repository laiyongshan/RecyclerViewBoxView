package com.suncere.androidapp.recyclerviewcheckboxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView my_rv;
    CheckBoxAdapter mCheckBoxAdapter;
    List<DemoBean1> mList;

    private Map<Integer, Boolean> checkStatus;

    Button check_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        check_btn = findViewById(R.id.check_btn);
        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkStatus = mCheckBoxAdapter.getAllSelecteds();
            }
        });

        my_rv = findViewById(R.id.My_rv);
        my_rv.setLayoutManager(new LinearLayoutManager(this));

        mList = initData();

        mCheckBoxAdapter = new CheckBoxAdapter(mList);
        mCheckBoxAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                checkStatus = mCheckBoxAdapter.getAllSelecteds();
                Toast.makeText(MainActivity.this, "Position：" + position + " is " + checkStatus.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        my_rv.setAdapter(mCheckBoxAdapter);

    }

    private List<DemoBean1> initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add(new DemoBean1("item" + i, true));
        }
        return mList;
    }

}
