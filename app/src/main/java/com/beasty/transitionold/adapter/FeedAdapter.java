package com.beasty.transitionold.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beasty.transitionold.DetailActivity;
import com.beasty.transitionold.R;
import com.beasty.transitionold.view.model.FeedViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<FeedViewModel> feedViewModelList = new ArrayList<>();
    private Context context;

    public FeedAdapter(List<FeedViewModel> feedViewModelList, Context context) {
        this.feedViewModelList = feedViewModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View row = LayoutInflater.from(context).inflate(R.layout.row_feed, parent, false);
        ViewHolder holder = new ViewHolder(row, context);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        FeedViewModel feedViewModel = feedViewModelList.get(position);

        viewHolder.itemView.setTag(feedViewModel);

        TextView titleBandView = viewHolder.titleBandView;
        String title = feedViewModel.getTitle();
        titleBandView.setText(title);

        ImageView avatarBandView = viewHolder.avatarBandView;
        String urlAvatar = feedViewModel.getUrlAvatar();
        if (urlAvatar != null && !urlAvatar.equals("")) {
            Picasso.with(context).load(urlAvatar).into(avatarBandView);
        }
    }


    @Override
    public int getItemCount() {
        return feedViewModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView titleBandView;
        public ImageView avatarBandView;
        public Context context;

        public ViewHolder(View root, Context context) {
            super(root);
            titleBandView = (TextView) root.findViewById(R.id.tv_row_feed_title_band);
            avatarBandView = (ImageView) root.findViewById(R.id.tv_row_feed_avatar_band);
            this.context = context;
            root.setOnClickListener(clickRow);
        }

        private final View.OnClickListener clickRow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedViewModel rowClicked = (FeedViewModel) v.getTag();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TITLE, rowClicked.getTitle());
                intent.putExtra(DetailActivity.EXTRA_AVATAR_URL, rowClicked.getUrlAvatar());

                context.startActivity(intent);
            }
        };
    }
}