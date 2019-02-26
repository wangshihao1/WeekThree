package com.bawei.weektwomn.di.presenter;

import com.bawei.weektwomn.data.bean.BannerBean;
import com.bawei.weektwomn.di.contract.IBannerContract;
import com.bawei.weektwomn.di.model.IBannerModelImp;

import java.lang.ref.SoftReference;

public class IBannerPresenterImp implements IBannerContract.IBannerPresenter<IBannerContract.IBannerView> {

    private IBannerContract.IBannerModel bannerModel;
    private IBannerContract.IBannerView bannerView;
    private SoftReference<IBannerContract.IBannerView> reference;

    @Override
    public void atteachView(IBannerContract.IBannerView iBannerView) {
        this.bannerView = iBannerView;
        bannerModel = new IBannerModelImp();
        reference = new SoftReference<>(bannerView);
    }

    @Override
    public void deateachView(IBannerContract.IBannerView iBannerView) {
        reference.clear();
    }

    @Override
    public void responseData() {
        bannerModel.requestData(new IBannerContract.IBannerModel.ICallBack() {
            @Override
            public void callBack(BannerBean bannerBean) {
                bannerView.showData(bannerBean);
            }
        });
    }
}
