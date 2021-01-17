package com.fh.shop_behind.entity.vo;
//业务bean   查询条件用的
public class AttrParams extends PageParams {
    private  String name;

    private Integer type;

    private Integer isSKU;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSKU() {
        return isSKU;
    }

    public void setIsSKU(Integer isSKU) {
        this.isSKU = isSKU;
    }
}
