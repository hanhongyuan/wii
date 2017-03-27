package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class ProductVoucherDto {
    private int storeId;
    private int productTypeId;

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
