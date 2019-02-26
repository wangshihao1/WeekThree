package com.bawei.weektwomn.di.model;

import com.bawei.weektwomn.data.bean.GridBean;
import com.bawei.weektwomn.data.bean.HomeGoodsBean;
import com.bawei.weektwomn.data.bean.Root;
import com.bawei.weektwomn.data.countent.Apis;
import com.bawei.weektwomn.di.contract.ICycleContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ICycleModelmp implements ICycleContract.ICycleModel {
    @Override
    public void requestData(final ICallBack callBack) {
        OkGo.<String>get(Apis.HOMEGOODS_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                String result = response.body().toString();
                Root homeGoodsBean = gson.fromJson(result, Root.class);
                callBack.callBack(homeGoodsBean);
            }
        });
    }
}
