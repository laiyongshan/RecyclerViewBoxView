package com.suncere.androidapp.recyclerviewcheckboxdemo;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lys
 * @time 2019/4/22 10:36
 * @desc:
 */

public class CheckBoxAdapter extends BaseQuickAdapter<DemoBean1,BaseViewHolder> {

    private Map<Integer, Boolean> checkStatus;//用来记录所有checkbox的状态

    public CheckBoxAdapter( List<DemoBean1> datas) {
        super(R.layout.item_layout, datas);

        checkStatus = new HashMap<>();
        for (int i = 0; i < datas.size(); i++) {
            checkStatus.put(i, true);// 默认所有的checkbox都是选中
        }
    }

    @Override
    protected void convert(final BaseViewHolder helper, DemoBean1 item) {
        ((TextView)helper.getView(R.id.item_name_tv)).setText(item.getItemName()+"");
        ((CheckBox)helper.getView(R.id.checkbox)).setOnCheckedChangeListener(null);//清掉监听器
        ((CheckBox)helper.getView(R.id.checkbox)).setChecked(checkStatus.get(helper.getPosition()));//设置选中状态
        ((CheckBox)helper.getView(R.id.checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//再设置监听器
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkStatus.put(helper.getPosition(), isChecked);//check状态一旦改变，保存的check值也要发生相应的变化
            }
        });
    }

    public Map<Integer, Boolean> getAllSelecteds(){
        return checkStatus;
    }
}
