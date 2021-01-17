package com.fh.shop_behind.entity.po;

public class Value {
    private Integer id;
    private String value;//属性
    private String valueZhi;//属性值
    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueZhi() {
        return valueZhi;
    }

    public void setValueZhi(String valueZhi) {
        this.valueZhi = valueZhi;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}
