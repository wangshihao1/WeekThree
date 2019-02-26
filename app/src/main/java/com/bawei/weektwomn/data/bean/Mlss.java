package com.bawei.weektwomn.data.bean;

import java.util.List;

/**
 * @author Alex
 * @date 2019/2/18.
 * GitHub：https://github.com/wangshuaialex
 */
public class Mlss {
    private List<CommodityList> commodityList ;

    private int id;

    private String name;

    public void setCommodityList(List<CommodityList> commodityList){
        this.commodityList = commodityList;
    }
    public List<CommodityList> getCommodityList(){
        return this.commodityList;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
