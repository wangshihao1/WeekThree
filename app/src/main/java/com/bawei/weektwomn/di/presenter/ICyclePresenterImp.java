package com.bawei.weektwomn.di.presenter;

import com.bawei.weektwomn.data.bean.HomeGoodsBean;
import com.bawei.weektwomn.data.bean.Root;
import com.bawei.weektwomn.di.contract.ICycleContract;
import com.bawei.weektwomn.di.model.ICycleModelmp;

import java.lang.ref.SoftReference;

public class ICyclePresenterImp implements ICycleContract.ICyclePresenter<ICycleContract.ICycleView> {
    private ICycleContract.ICycleModel cycleModel;
    private ICycleContract.ICycleView cycleView;
    private SoftReference<ICycleContract.ICycleView> reference;

    @Override
    public void atteachView(ICycleContract.ICycleView iCycleView) {
        this.cycleView = iCycleView;
        cycleModel = new ICycleModelmp();
        reference = new SoftReference<>(cycleView);
    }

    @Override
    public void deateachView(ICycleContract.ICycleView iCycleView) {
        reference.clear();
    }

    @Override
    public void responseData() {
        cycleModel.requestData(new ICycleContract.ICycleModel.ICallBack() {
            @Override
            public void callBack(Root homeGoodsBean) {
                cycleView.showCycleData(homeGoodsBean);
            }
        });
    }
}
