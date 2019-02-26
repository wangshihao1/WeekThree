package com.bawei.weektwomn.di.contract;

import com.bawei.weektwomn.data.bean.HomeGoodsBean;
import com.bawei.weektwomn.data.bean.Root;

public interface ICycleContract {

    public interface ICycleView{

        void showCycleData(Root root);
    }

    public interface ICyclePresenter<ICycleView>{

        void atteachView(ICycleView cycleView);

        void deateachView(ICycleView cycleView);

        void responseData();
    }

    public interface ICycleModel{

        public interface ICallBack{

            void callBack(Root root);
        }

        void requestData(ICallBack callBack);
    }
}
