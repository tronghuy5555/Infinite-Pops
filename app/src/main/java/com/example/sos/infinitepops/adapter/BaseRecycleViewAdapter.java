package com.example.sos.infinitepops.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.sos.infinitepops.R;
import com.example.sos.infinitepops.callback.OnEventListener;
import com.example.sos.infinitepops.control.VolleySingleton;
import com.example.sos.infinitepops.dto.FeedItemResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRecycleViewAdapter
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class BaseRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<FeedItemResponse> items = new ArrayList<>();
    private static int DATA = 0;
    private static int LOAD_MORE = 1;
    private boolean isEnableLoadMore = true;
    private boolean isCancelLoadMore = false;
    private OnEventListener eventListener;

    public BaseRecycleViewAdapter(List<FeedItemResponse> items) {
        if (items != null)
            this.items.addAll(items);
    }

    public OnEventListener getEventListener() {
        return eventListener;
    }

    public void setEventListener(OnEventListener eventListener) {
        this.eventListener = eventListener;
    }

    public boolean isCancelLoadMore() {
        return isCancelLoadMore;
    }

    public void setCancelLoadMore(boolean cancelLoadMore) {
        isCancelLoadMore = cancelLoadMore;
    }

    public boolean isEnableLoadMore() {
        return isEnableLoadMore;
    }

    public void setEnableLoadMore(boolean enableLoadMore) {
        isEnableLoadMore = enableLoadMore;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= getItemCount() - 1 && isEnableLoadMore)
            return LOAD_MORE;
        return DATA;
    }

    public void setData(List<FeedItemResponse> data) {
        items.clear();
        items.addAll(data);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == LOAD_MORE) {
            View progressView = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_layout,parent,false);
            return new ProgressHolder(progressView);
        }
        View feedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_item,parent,false);
        return new FeedItemHolder(feedView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (this.getItemViewType(position) == LOAD_MORE)
            eventListener.onLoadMore(position);
        if (holder instanceof FeedItemHolder) {
            ((FeedItemHolder) holder).bindData(items.get(position));
        } else if (holder instanceof ProgressHolder) {
            ((ProgressHolder) holder).setVisibleProgress(this.isCancelLoadMore? View.GONE: View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (items != null && !items.isEmpty())
            return isEnableLoadMore ? items.size() + 1 : items.size();
        return 1;
    }

    static class ProgressHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rlProgress;

        public ProgressHolder(View itemView) {
            super(itemView);
            rlProgress = itemView.findViewById(R.id.rlProgress);
        }

        void setVisibleProgress(int visible) {
            rlProgress.setVisibility(visible);
        }
    }

    static class FeedItemHolder extends RecyclerView.ViewHolder{

        private FeedItemResponse data;
        private TextView tvText;
        private NetworkImageView ivImageResource;

        public FeedItemHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            ivImageResource = itemView.findViewById(R.id.ivImageSource);
        }

        void bindData(FeedItemResponse data) {
            this.data = data;
            tvText.setText(data.getText());
            ImageLoader imageLoader = VolleySingleton.getInstance().getImageLoader();
            ivImageResource.setImageUrl(data.getImageSrc(), imageLoader);
        }
    }
}
