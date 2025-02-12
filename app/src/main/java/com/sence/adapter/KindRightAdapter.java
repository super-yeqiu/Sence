package com.sence.adapter;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.bean.response.PGoodListBean;
import com.sence.net.Urls;
import com.sence.utils.GlideUtils;
import com.sence.view.BigMidSmallTextView;

/**
 * Created by zwy on 2019/3/13.
 * package_name is com.sence.adapter
 * 描述:Sence
 */
public class KindRightAdapter extends BaseQuickAdapter<PGoodListBean, BaseViewHolder> {
    public KindRightAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PGoodListBean item) {
        GlideUtils.getInstance().loadNormal(item.getImg(), (ImageView) helper.getView(R.id.item_img));
        BigMidSmallTextView item_price = helper.getView(R.id.item_price);
        helper.setText(R.id.item_name, item.getName());
        item_price.setRight_text(item.getPrice());
        helper.addOnClickListener(R.id.item_bus);
    }
}
