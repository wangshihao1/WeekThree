package com.bawei.weektwomn.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author Alex
 * @date 2019/2/18.
 * GitHub：https://github.com/wangshuaialex
 */
public class CommodityList implements MultiItemEntity {
    private int commodityId;

    private String commodityName;

    private String masterPic;

    private int price;

    private int saleNum;

    public static int left_img = 0;
    public static int right_img = 1;
    public static int bottom_img = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //自定义的条目类型
    private int type = 0;


    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCommodityId() {
        return this.commodityId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getMasterPic() {
        return this.masterPic;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getSaleNum() {
        return this.saleNum;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
