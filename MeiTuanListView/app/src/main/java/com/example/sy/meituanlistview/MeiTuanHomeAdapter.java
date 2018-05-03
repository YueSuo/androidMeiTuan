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

public class MeiTuanHomeAdapter extends BaseAdapter {

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
            viewHolder.imageViewSyIcon = converView.findViewById(R.id.sy_icon);
            viewHolder.textViewTitle = converView.findViewById(R.id.title);
            viewHolder.textViewDistance = converView.findViewById(R.id.distance);
            viewHolder.textViewContent = converView.findViewById(R.id.content);
            viewHolder.textViewPrice = converView.findViewById(R.id.price);
            viewHolder.textViewSalePrice = converView.findViewById(R.id.sale_price);
            viewHolder.textViewSold = converView.findViewById(R.id.sold);
            viewHolder.textViewTakeOut = converView.findViewById(R.id.take_out);

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
}
