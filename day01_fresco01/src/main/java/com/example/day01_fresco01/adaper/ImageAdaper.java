package com.example.day01_fresco01.adaper;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day01_fresco01.R;
import com.example.day01_fresco01.bean.ImageBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ImageBean.DataBean> mData;
    private Context mContext;

    public ImageAdaper(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }
    public void setmData(List<ImageBean.DataBean> datas){
        mData.addAll(datas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycle_item,viewGroup,false);
        ViewHolderImage holderImage = new ViewHolderImage(view);
        return holderImage;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolderImage holderImage = (ViewHolderImage) viewHolder;
        holderImage.title.setText(mData.get(i).getName());
        Uri uri = Uri.parse(mData.get(i).getIcon());
        holderImage.draweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class ViewHolderImage extends RecyclerView.ViewHolder{
        public final SimpleDraweeView draweeView;
        public final TextView title;
        public ViewHolderImage(@NonNull View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.simple);
            title = itemView.findViewById(R.id.title);
        }
    }
}
