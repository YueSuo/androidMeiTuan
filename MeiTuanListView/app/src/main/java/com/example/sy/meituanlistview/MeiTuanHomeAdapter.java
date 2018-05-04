package com.example.sy.meituanlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suoyue on 2018/5/3.
 */

public class MeiTuanHomeAdapter extends BaseAdapter implements View.OnClickListener {

    private List<MeiTuanHomeBean> mList;
    private LayoutInflater inflater;
    public MeiTuanHomeAdapter(List<MeiTuanHomeBean> mList, Context context){
        this.mList = mList;
        this.inflater = LayoutInflater.from(context);
    }






    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if(converView == null){
            converView = inflater.inflate(R.layout.item_meituan_home,null,false);

            viewHolder = new ViewHolder();
            viewHolder.imageViewSyIcon = (ImageView) converView.findViewById(R.id.sy_icon);
            viewHolder.textViewTitle = (TextView) converView.findViewById(R.id.title);
            viewHolder.textViewDistance = (TextView) converView.findViewById(R.id.distance);
            viewHolder.textViewContent = (TextView) converView.findViewById(R.id.content);
            viewHolder.textViewPrice = (TextView) converView.findViewById(R.id.price);
            viewHolder.textViewSalePrice = (TextView) converView.findViewById(R.id.sale_price);
            viewHolder.textViewSold = (TextView) converView.findViewById(R.id.sold);
            viewHolder.textViewTakeOut = (TextView) converView.findViewById(R.id.take_out);

            converView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) converView.getTag();
        }

        MeiTuanHomeBean meiTuanHomeBean = mList.get(position);

        if (meiTuanHomeBean.isTakeOut()){
            viewHolder.textViewTakeOut.setVisibility(View.VISIBLE);
        } else {
            viewHolder.textViewTakeOut.setVisibility(View.GONE);
        }

        viewHolder.imageViewSyIcon.setImageResource(meiTuanHomeBean.getSyIcon());
        viewHolder.textViewTitle.setText(meiTuanHomeBean.getTitle());
        viewHolder.textViewDistance.setText(meiTuanHomeBean.getDistance());
        viewHolder.textViewContent.setText(meiTuanHomeBean.getContent());
        viewHolder.textViewPrice.setText("" + meiTuanHomeBean.getPrice());
        viewHolder.textViewSalePrice.setText("门市价：¥" + meiTuanHomeBean.getSalePrice());
        viewHolder.textViewSold.setText("已售" + meiTuanHomeBean.getSold());

        viewHolder.imageViewSyIcon.setOnClickListener(this);
        viewHolder.imageViewSyIcon.setTag(position);

        return converView;
    }


    private class ViewHolder{
        public ImageView imageViewSyIcon;
        public TextView textViewTitle;
        public TextView textViewDistance;
        public TextView textViewContent;
        public TextView textViewPrice;
        public TextView textViewSalePrice;
        public TextView textViewSold;
        public TextView textViewTakeOut;
    }

    //自定义接口
    interface InnerLister{
        void imgClick(View v);
    }
    private InnerLister innerLister;
    public void setInnerLister(InnerLister innerLister){
        this.innerLister = innerLister;
    }

    public void onClick(View v) {
        innerLister.imgClick(v);;
    }

}
