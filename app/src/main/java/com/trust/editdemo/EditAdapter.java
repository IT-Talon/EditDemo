package com.trust.editdemo;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Talon on 2018/6/28.
 */
public class EditAdapter extends BaseQuickAdapter<DataEntity, BaseViewHolder> {
    private RecyclerView mRecyclerView;

    public EditAdapter(RecyclerView recyclerView, @Nullable List<DataEntity> data) {
        super(R.layout.item_layout, data);
        this.mRecyclerView = recyclerView;
    }

    @Override
    protected void convert(BaseViewHolder helper, DataEntity item) {
        ImageView img = helper.getView(R.id.img);
        int itemWidth = (getScreenWidth() - mRecyclerView.getPaddingLeft() - mRecyclerView.getPaddingRight()) / 2;
        int itemHeight = (int) (146 * itemWidth / 165);
//        int itemHeight = (int) (2 * itemWidth); //写2倍看效果比较明显
        img.getLayoutParams().height = itemHeight;
        helper.setText(R.id.tv_name, item.getName());
        helper.setImageResource(R.id.img, item.getImageId());
        if (item.isShowDelete()) {
            helper.getView(R.id.img_delete).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.img_delete).setVisibility(View.INVISIBLE);
        }
        helper.addOnClickListener(R.id.img_delete);
    }


    private int getScreenWidth() {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    private int getScreenHeight() {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
