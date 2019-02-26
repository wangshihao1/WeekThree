package com.bawei.weektwomn.di.contract;

import com.bawei.weektwomn.data.bean.BannerBean;

public interface IBannerContract {

    public interface IBannerView{

        void showData(BannerBean bannerBean);
    }

    public interface IBannerPresenter<IBannerView>{

        void atteachView(IBannerView bannerView);

        void deateachView(IBannerView bannerView);

        void responseData();
    }

    public interface IBannerModel{

        public interface ICallBack{

            void callBack(BannerBean bannerBean);
        }

        void requestData(ICallBack callBack);
    }
}
