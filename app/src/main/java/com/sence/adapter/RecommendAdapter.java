package com.sence.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.activity.ContentDetailActivity;
import com.sence.bean.response.PMainRecommendBean;
import com.sence.net.Urls;
import com.sence.view.NiceImageView;

/**
 * Created by zwy on 2019/3/21.
 * package_name is com.sence.adapter
 * 描述:SenceGit
 */
public class RecommendAdapter extends BaseQuickAdapter<PMainRecommendBean, BaseViewHolder> {
    public RecommendAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PMainRecommendBean item) {
        final NiceImageView item_img = helper.getView(R.id.item_img);
        final Activity activity = (Activity) helper.itemView.getContext();
        Glide.with(activity).load(Urls.base_url + item.getAlbum_url()).into(item_img);
        Glide.with(activity).load(Urls.base_url + item.getAvatar()).into((ImageView) helper.getView(R.id.item_head));
        helper.setText(R.id.item_title, item.getTitle());
        helper.setText(R.id.item_content, item.getContent());
        helper.setText(R.id.item_name, item.getNick_name());
        if (item.getIs_kol().equals("1")) {
            helper.setGone(R.id.item_tag, true);
        } else {
            helper.setGone(R.id.item_tag, false);
        }
        ImageView item_support_img = helper.getView(R.id.item_support_img);
        if (item.getIs_like().equals("1")) {
            item_support_img.setSelected(true);
        } else {
            item_support_img.setSelected(false);
        }
        helper.setText(R.id.item_support, item.getPraise_count());
        helper.setText(R.id.item_comment, item.getMessage_count());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                        item_img, activity.getResources().getString(R.string.translation_recommend_name));
                activity.startActivity(new Intent(activity, ContentDetailActivity.class), activityOptions.toBundle());
            }
        });
    }
}