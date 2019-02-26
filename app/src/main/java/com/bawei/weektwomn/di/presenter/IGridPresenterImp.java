package com.bawei.weektwomn.di.presenter;

import com.bawei.weektwomn.data.bean.GridBean;
import com.bawei.weektwomn.di.contract.IGridContract;
import com.bawei.weektwomn.di.model.IGridModelImp;

import java.lang.ref.SoftReference;

public class IGridPresenterImp implements IGridContract.IGridPresenter<IGridContract.IGridView> {
    private IGridContract.IGridModel gridModel;
    private IGridContract.IGridView gridView;
    private SoftReference<IGridContract.IGridView> reference;

    @Override
    public void atteachView(IGridContract.IGridView iGridView) {
        this.gridView = iGridView;
        gridModel = new IGridModelImp();
        reference = new SoftReference<>(gridView);
    }

    @Override
    public void deateachView(IGridContract.IGridView iGridView) {
        reference.clear();
    }

    @Override
    public void responseData() {
        gridModel.requestData(new IGridContract.IGridModel.ICallBack() {
            @Override
            public void callBack(GridBean gridBean) {
                gridView.showGridData(gridBean);
            }
        });
    }
}
