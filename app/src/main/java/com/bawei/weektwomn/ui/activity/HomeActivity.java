package com.bawei.weektwomn.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weektwomn.R;
import com.bawei.weektwomn.data.bean.BannerBean;
import com.bawei.weektwomn.data.bean.CommodityList;
import com.bawei.weektwomn.data.bean.GridBean;
import com.bawei.weektwomn.data.bean.HomeGoodsBean;
import com.bawei.weektwomn.data.bean.Root;
import com.bawei.weektwomn.data.countent.GlideImageLoader;
import com.bawei.weektwomn.di.contract.IBannerContract;
import com.bawei.weektwomn.di.contract.ICycleContract;
import com.bawei.weektwomn.di.contract.IGridContract;
import com.bawei.weektwomn.di.presenter.IBannerPresenterImp;
import com.bawei.weektwomn.di.presenter.ICyclePresenterImp;
import com.bawei.weektwomn.di.presenter.IGridPresenterImp;
import com.bawei.weektwomn.ui.adapter.GridAdapter;
import com.bawei.weektwomn.ui.adapter.ThreeAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements IBannerContract.IBannerView, IGridContract.IGridView,ICycleContract.ICycleView {


    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_view)
    RecyclerView rvView;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.left_drawer)
    FrameLayout leftDrawer;
    @BindView(R.id.fly_banner)
    Banner banner;
    @BindView(R.id.gv_view)
    RecyclerView gvView;
    private IBannerPresenterImp presenterImp;
    private ActionBarDrawerToggle toggle;
    private List<BannerBean.ResultBean> result;
    private IGridPresenterImp gridPresenterImp;
    private GridAdapter adapter;
    private List<GridBean.ResultsBean> results;
    private ICyclePresenterImp cyclePresenterImp;
    private HomeGoodsBean.ResultBean resultBean;
    private ThreeAdapter threeAdapter;
    private List<CommodityList> commodityList;
    private List<CommodityList> commodityLists;
    private List<CommodityList> commodityListss;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenterImp = new IBannerPresenterImp();
        presenterImp.atteachView(this);
        presenterImp.responseData();

        gridPresenterImp = new IGridPresenterImp();
        gridPresenterImp.atteachView(this);
        gridPresenterImp.responseData();

        cyclePresenterImp = new ICyclePresenterImp();
        cyclePresenterImp.atteachView(this);
        cyclePresenterImp.responseData();

    }

    @Override
    public void showData(BannerBean bannerBean) {
        result = bannerBean.getResult();
        ArrayList<String> beanlist = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String url = result.get(i).getImageUrl();
            beanlist.add(url);
        }
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(beanlist);

        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);

        banner.setIndicatorGravity(BannerConfig.CENTER);

        //banner设置方法全部调用完毕时最后调用
        banner.start();


    }


    @Override
    public void showGridData(GridBean gridBean) {
        results = gridBean.getResults();
        adapter = new GridAdapter(R.layout.item_grid, results);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        gvView.setLayoutManager(manager);
        gvView.setAdapter(adapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterImp.deateachView(this);
    }


    @Override
    public void showCycleData(Root root) {
        commodityList = root.getResult().getRxxp().get(0).getCommodityList();
        commodityLists = root.getResult().getMlss().get(0).getCommodityList();
        commodityListss = root.getResult().getPzsh().get(0).getCommodityList();
        ArrayList<CommodityList> beanlist = new ArrayList<>();
        beanlist.addAll(commodityList);
        beanlist.addAll(commodityLists);
        beanlist.addAll(commodityListss);
        threeAdapter = new ThreeAdapter(beanlist);
        rvView.setAdapter(threeAdapter);


    }
}

