package com.sence.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.orhanobut.logger.Logger;
import com.sence.R;
import com.sence.bean.request.RAddAddressBean;
import com.sence.bean.request.REditroAddressBean;
import com.sence.bean.response.PManageAddressBean;
import com.sence.net.HttpCode;
import com.sence.net.HttpManager;
import com.sence.net.manager.ApiCallBack;
import com.sence.utils.LoginStatus;
import com.sence.utils.StatusBarUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * 添加收货地址
 */
public class AddAddressActivity extends AppCompatActivity {

    private TextView mTitle;
    private ImageView mBack;
    private EditText mName, mPhone, mDetailsAddress, mPostCode;
    private String name;
    private String phone;
    private String detailsAddress;
    private String postCode,address;
    private CityPicker cityPicker;
    private TextView mAddress;
    private PManageAddressBean bean = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);
        StatusBarUtil.setLightMode(this);
        Intent intent = getIntent();
        bean = (PManageAddressBean)intent.getSerializableExtra("bean");
        initData();

    }

    private void initData() {
        mTitle = findViewById(R.id.pub_title);
        mTitle.setText("新增收货地址");
        mBack = findViewById(R.id.pub_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mName = findViewById(R.id.et_name_addaddress);
        mPhone = findViewById(R.id.et_phone_addaddress);
        mAddress = findViewById(R.id.tv_address_addaddress);
        mDetailsAddress = findViewById(R.id.et_detailsaddress_addaddress);
        mPostCode = findViewById(R.id.et_postcode_addaddress);
        if(bean!=null){
            mName.setText(bean.getUsername());
            mPhone.setText(bean.getPhone());
            mAddress.setText(bean.getArea());
            mDetailsAddress.setText(bean.getAddress());
            mPostCode.setText(bean.getZipcode());
        }
        findViewById(R.id.ll_address_addaddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(AddAddressActivity.this);
                //滚轮文字的大小
                initCityPicker();
                cityPicker.show();
            }
        });

        findViewById(R.id.bt_save_addaddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doHttp();
            }
        });
    }

    private void initCityPicker() {
        cityPicker = new CityPicker.Builder(AddAddressActivity.this).textSize(20)//滚轮文字的大小.title("地址选择").backgroundPop(0xa0000000)
                .titleBackgroundColor("#0CB6CA")
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("xx省")
                .city("xx市")
                .district("xx区")
                .textColor(Color.parseColor("#000000"))//滚轮文字的颜色
                .provinceCyclic(true)//省份滚轮是否循环显示
                .cityCyclic(false)//城市滚轮是否循环显示
                .districtCyclic(false)//地区（县）滚轮是否循环显示
                .visibleItemsCount(7)//滚轮显示的item个数
                .itemPadding(10)//滚轮item间距
                .onlyShowProvinceAndCity(false)
                .build();

        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];

                mAddress.setText(province + city + district);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    private void doHttp() {
        name = mName.getText().toString().trim();
        phone = mPhone.getText().toString().trim();
        detailsAddress = mDetailsAddress.getText().toString().trim();
        address = mAddress.getText().toString().trim();
        postCode = mPostCode.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showShort("请输入您的姓名");
            return;
        }
        if(!RegexUtils.isMobileExact(phone)){
            ToastUtils.showShort("请输入正确的手机号码");
            return;
        }
        if (address.equals("省、市、区")) {
            ToastUtils.showShort("请选择省市区");
            return;
        }
        if (TextUtils.isEmpty(detailsAddress)) {
            ToastUtils.showShort("请输入详细地址");
            return;
        }

        if (TextUtils.isEmpty(postCode)) {
            ToastUtils.showShort("请输入当地邮政编码");
            return;
        }
        if(bean==null){
            addAddress();
        }else{
            editorAddress();
        }
    }

    private void editorAddress() {
        HttpManager.getInstance().PlayNetCode(HttpCode.ADDRESS_EDIT, new REditroAddressBean(LoginStatus.getUid(),bean.getId(),detailsAddress,address,phone,postCode,name)).request(new ApiCallBack<String>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void Message(int code, String message) {

            }

            @Override
            public void onSuccess(String o, String msg) {
                Logger.e("msg==========" + msg);
                ToastUtils.showShort(msg);
                if(msg.equals("编辑地址成功")){
                    finish();
                }
            }
        });
    }

    private void addAddress() {
        HttpManager.getInstance().PlayNetCode(HttpCode.ADDRESS_ADD, new RAddAddressBean(LoginStatus.getUid(),detailsAddress,address,phone,postCode,name)).request(new ApiCallBack<String>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void Message(int code, String message) {

            }

            @Override
            public void onSuccess(String o, String msg) {
                Logger.e("msg==========" + msg);
                ToastUtils.showShort(msg);
                if(msg.equals("添加地址成功")){
                    finish();
                }
            }
        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
