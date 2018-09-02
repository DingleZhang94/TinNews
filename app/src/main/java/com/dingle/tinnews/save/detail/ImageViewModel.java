package com.dingle.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.dingle.tinnews.R;
import com.dingle.tinnews.common.BaseViewModel;
import com.squareup.picasso.Picasso;

import static android.support.v7.widget.RecyclerView.*;

public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder>{

    private final String uri;
    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }


    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }

    static class ImageViewModelViewHolder extends ViewHolder {
        ImageView image;
        ImageViewModelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }

}
