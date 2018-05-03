package com.example.sy.meituanlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suoyue on 2018/5/3.
 */

public class MeiTuanHomeActivity extends FragmentActivity {
    private MyListView myListView;
    private MeiTuanHomeAdapter meiTuanHomeAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meituan_home);
        initView();
        addGuessYouLike();   //自定义一个喜欢的布局
        initListView();
        //setListViewHeight(myListView);

    }

    private void initView(){
        myListView = findViewById(R.id.list_view);
    }

    private void initListView(){
        meiTuanHomeAdapter = new MeiTuanHomeAdapter(getData(),this);
        myListView.setAdapter(meiTuanHomeAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MeiTuanHomeActivity.this,"Positon = "+ position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<MeiTuanHomeBean> getData(){
        List<MeiTuanHomeBean> mList = new ArrayList<>();
        MeiTuanHomeBean meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_hanbao);
        meiTuanHomeBean.setTitle("华莱士");
        meiTuanHomeBean.setContent("【大庙村】豪华双人餐，提供免费wifi");
        meiTuanHomeBean.setDistance("<500m");
        meiTuanHomeBean.setPrice(19.9);
        meiTuanHomeBean.setSalePrice(28.8);
        meiTuanHomeBean.setSold(1345);
        meiTuanHomeBean.setTakeOut(true);
        mList.add(meiTuanHomeBean);

        meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_iphonex);
        meiTuanHomeBean.setTitle("一元夺iPhone X");
        meiTuanHomeBean.setContent("【全国】超高中奖率，不信来试");
        meiTuanHomeBean.setDistance("");
        meiTuanHomeBean.setPrice(1);
        meiTuanHomeBean.setSalePrice(1);
        meiTuanHomeBean.setSold(666);
        meiTuanHomeBean.setTakeOut(false);
        mList.add(meiTuanHomeBean);

        meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_malatang);
        meiTuanHomeBean.setTitle("温海江家麻辣烫");
        meiTuanHomeBean.setContent("【人文科技学院】单人豪华餐，买不了吃亏");
        meiTuanHomeBean.setDistance("1.1km");
        meiTuanHomeBean.setPrice(9.9);
        meiTuanHomeBean.setSalePrice(18.9);
        meiTuanHomeBean.setSold(3456);
        meiTuanHomeBean.setTakeOut(true);
        mList.add(meiTuanHomeBean);

        meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_chuan);
        meiTuanHomeBean.setTitle("冯广宇家串串");
        meiTuanHomeBean.setContent("好吃到没朋友的串串，快来品尝吧");
        meiTuanHomeBean.setDistance("366m");
        meiTuanHomeBean.setPrice(16.6);
        meiTuanHomeBean.setSalePrice(32);
        meiTuanHomeBean.setSold(2340);
        meiTuanHomeBean.setTakeOut(true);
        mList.add(meiTuanHomeBean);

        meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_zaodian);
        meiTuanHomeBean.setTitle("皮几万早点");
        meiTuanHomeBean.setContent("【早餐】包子、豆腐脑、油条、鸡蛋灌饼");
        meiTuanHomeBean.setDistance("900m");
        meiTuanHomeBean.setPrice(6.6);
        meiTuanHomeBean.setSalePrice(16.9);
        meiTuanHomeBean.setSold(1456);
        meiTuanHomeBean.setTakeOut(true);
        mList.add(meiTuanHomeBean);

        meiTuanHomeBean = new MeiTuanHomeBean();
        meiTuanHomeBean.setSyIcon(R.mipmap.meituan_dangao);
        meiTuanHomeBean.setTitle("奔跑吧！蛋糕");
        meiTuanHomeBean.setContent("【甜品】泡芙、蛋糕、面包、定制蛋糕");
        meiTuanHomeBean.setDistance("700m");
        meiTuanHomeBean.setPrice(45);
        meiTuanHomeBean.setSalePrice(89);
        meiTuanHomeBean.setSold(746);
        meiTuanHomeBean.setTakeOut(true);
        mList.add(meiTuanHomeBean);

        return mList;
    }

    private void addGuessYouLike(){
        View view = LayoutInflater.from(this).inflate(R.layout.layout_guess_you_like,null);
        myListView.addHeaderView(view);
    }


    //动态去设置ListView的高度
    private void setListViewHeight(ListView listView){
        if (listView == null){
            return;
        }
        ListAdapter adapter = listView.getAdapter();
        int totaHeight = 0;   //保存ListView的总高度
        int count = adapter.getCount();     //返回ListView的项数
        for (int i=0;i<count;i++){
            View view = adapter.getView(i,null,listView);
            view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
            int measureHeight = view.getMeasuredHeight();
            totaHeight += measureHeight;
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = totaHeight + listView.getDividerHeight() * (count - 1);
        listView.setLayoutParams(layoutParams);
    }
}
