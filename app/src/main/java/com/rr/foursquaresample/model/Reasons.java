
package com.rr.foursquaresample.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reasons {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Item__> items = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item__> getItems() {
        return items;
    }

    public void setItems(List<Item__> items) {
        this.items = items;
    }

}
