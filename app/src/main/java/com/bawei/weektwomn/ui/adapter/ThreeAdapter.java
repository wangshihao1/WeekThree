package com.bawei.weektwomn.ui.adapter;


import android.widget.ImageView;
import com.bawei.weektwomn.R;
import com.bawei.weektwomn.data.bean.CommodityList;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ThreeAdapter extends BaseMultiItemQuickAdapter<CommodityList,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ThreeAdapter(List<CommodityList> data) {
        super(data);

        addItemType(CommodityList.left_img, R.layout.item_layout);
        addItemType(CommodityList.right_img, R.layout.item_right_layout);
        addItemType(CommodityList.bottom_img, R.layout.item_bottom_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityList item) {
        switch (helper.getItemViewType()) {
            case 0:
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                Glide.with(mContext).load(item.getMasterPic()).into(iv_icon);
                helper.setText(R.id.tv_title, item.getCommodityName() + "0");
                break;
            case 1:
                ImageView iv_right_icon = helper.getView(R.id.iv_right_icon);
                Glide.with(mContext).load(item.getMasterPic()).into(iv_right_icon);
                helper.setText(R.id.tv_right_title, item.getCommodityName() + "1");
                break;
            case 2:
                ImageView iv_top_icon = helper.getView(R.id.iv_top_icon);
                Glide.with(mContext).load(item.getMasterPic()).into(iv_top_icon);
                helper.setText(R.id.tv_top_title, item.getCommodityName() + "2");
                break;
        }
    }
}
