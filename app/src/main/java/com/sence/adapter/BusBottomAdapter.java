package com.sence.adapter;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.bean.response.PBusRecommendBean;
import com.sence.utils.GlideUtils;

/**
 * Created by zwy on 2019/3/13.
 * package_name is com.sence.adapter
 * 描述:Sence
 */
public class BusBottomAdapter extends BaseQuickAdapter<PBusRecommendBean, BaseViewHolder> {
    public BusBottomAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PBusRecommendBean item) {
        GlideUtils.getInstance().loadNormal(item.getImg(), (ImageView) helper.getView(R.id.item_img));
        helper.setText(R.id.item_name, item.getName());
        TextView item_price_normal = helper.getView(R.id.item_price_normal);
        if("0".equals(item.getVprice())){
            helper.setText(R.id.item_price, "￥" + item.getPrice());
            item_price_normal.setVisibility(View.GONE);
        }else{
            helper.setText(R.id.item_price, "￥" + item.getVprice());
            item_price_normal.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
            item_price_normal.setText("￥" + item.getPrice());
        }
    }
}
