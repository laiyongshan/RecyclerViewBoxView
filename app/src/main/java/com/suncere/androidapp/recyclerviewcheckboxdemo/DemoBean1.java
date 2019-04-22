package com.suncere.androidapp.recyclerviewcheckboxdemo;

import java.io.Serializable;

/**
 * @author lys
 * @time 2019/4/22 10:36
 * @desc:
 */

public class DemoBean1 implements Serializable {

    String itemName;
    boolean isSelected;

    public DemoBean1(String itemName,boolean isSelected){
        this.itemName=itemName;
        this.isSelected=isSelected;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
