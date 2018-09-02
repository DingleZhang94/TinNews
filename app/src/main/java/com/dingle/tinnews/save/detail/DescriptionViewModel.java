package com.dingle.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dingle.tinnews.R;
import com.dingle.tinnews.common.BaseViewModel;

import static android.support.v7.widget.RecyclerView.*;

public class DescriptionViewModel extends BaseViewModel<DescriptionViewModel.DescriptionViewHolder> {
    private final String description;

    public DescriptionViewModel(String description) {
        super(R.layout.description_layout);
        this.description = description;
    }

    @Override
    public DescriptionViewHolder createItemViewHolder(View view) {
        return new DescriptionViewHolder(view);
    }

    @Override
    public void bindViewHolder(DescriptionViewHolder holder) {
        holder.description.setText(description);
    }

    static class DescriptionViewHolder extends ViewHolder {
        TextView description;
        DescriptionViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
        }
    }

}
