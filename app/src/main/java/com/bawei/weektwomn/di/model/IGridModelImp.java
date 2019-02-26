package com.bawei.weektwomn.di.model;

import com.bawei.weektwomn.data.bean.GridBean;
import com.bawei.weektwomn.data.countent.Apis;
import com.bawei.weektwomn.di.contract.IGridContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class IGridModelImp implements IGridContract.IGridModel {
    @Override
    public void requestData(final IGridContract.IGridModel.ICallBack callBack) {
        OkGo.<String>get(Apis.GRID_VIEW_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                String result = response.body().toString();
                GridBean gridBean = gson.fromJson(result, GridBean.class);
                callBack.callBack(gridBean);
            }
        });
    }
}
