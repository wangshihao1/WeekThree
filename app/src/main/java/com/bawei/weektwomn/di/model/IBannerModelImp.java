package com.bawei.weektwomn.di.model;

import com.bawei.weektwomn.data.bean.BannerBean;
import com.bawei.weektwomn.data.countent.Apis;
import com.bawei.weektwomn.di.contract.IBannerContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;


public class IBannerModelImp implements IBannerContract.IBannerModel {


    @Override
    public void requestData(final ICallBack callBack) {
        OkGo.<String>get(Apis.BANNER_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                String result = response.body().toString();
                BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
                callBack.callBack(bannerBean);
            }
        });
    }

}
