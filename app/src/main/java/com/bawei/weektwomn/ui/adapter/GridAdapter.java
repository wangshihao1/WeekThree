package com.bawei.weektwomn.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bawei.weektwomn.R;
import com.bawei.weektwomn.data.bean.GridBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class GridAdapter extends BaseQuickAdapter<GridBean.ResultsBean,BaseViewHolder> {


    public GridAdapter(int layoutResId, @Nullable List<GridBean.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GridBean.ResultsBean item) {

        helper.setText(R.id.tv_details,item.getDesc());
        ImageView view = helper.getView(R.id.iv_src);
        Glide.with(mContext).load(item.getUrl()).into(view);
    }
}
