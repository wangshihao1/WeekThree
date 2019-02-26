package com.bawei.weektwomn.di.contract;

import com.bawei.weektwomn.data.bean.GridBean;

public interface IGridContract {

    public interface IGridView{

        void showGridData(GridBean gridBean);
    }

    public interface IGridPresenter<IGridView>{

        void atteachView(IGridView gridView);

        void deateachView(IGridView gridView);

        void responseData();
    }

    public interface IGridModel{

        public interface ICallBack{

            void callBack(GridBean gridBean);
        }

        void requestData(ICallBack callBack);
    }
}
