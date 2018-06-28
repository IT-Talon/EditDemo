package com.trust.editdemo;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/28.
 */
public class DataEntity implements Serializable {

    private static final long serialVersionUID = 6000082763064143028L;
    private String name;
    private int imageId;
    private boolean showDelete;

    public DataEntity(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isShowDelete() {
        return showDelete;
    }

    public void setShowDelete(boolean showDelete) {
        this.showDelete = showDelete;
    }
}
