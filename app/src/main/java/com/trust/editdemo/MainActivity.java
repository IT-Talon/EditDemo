package com.trust.editdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rec)
    RecyclerView mRecyclerView;

    private EditAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<DataEntity> data = new ArrayList<>();
        data.add(new DataEntity("111", R.mipmap.ic_launcher));
        data.add(new DataEntity("222", R.mipmap.ic_launcher));
        data.add(new DataEntity("333", R.mipmap.ic_launcher));
        data.add(new DataEntity("444", R.mipmap.ic_launcher));
        data.add(new DataEntity("555", R.mipmap.ic_launcher));
        data.add(new DataEntity("666", R.mipmap.ic_launcher));
        data.add(new DataEntity("777", R.mipmap.ic_launcher));
        mAdapter = new EditAdapter(mRecyclerView, data);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                removeItem(position);
            }
        });
    }

    private void removeItem(int position) {
        mAdapter.getData().remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    boolean xIsshow = false;

    public void onClick(View view) {
        xIsshow = !xIsshow;
        List<DataEntity> data = mAdapter.getData();
        for (DataEntity entity : data) {
            entity.setShowDelete(xIsshow);
        }
        mAdapter.notifyDataSetChanged();
    }
}
