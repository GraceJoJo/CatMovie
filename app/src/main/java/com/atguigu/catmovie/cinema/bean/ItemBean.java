package com.atguigu.catmovie.cinema.bean;

/**
 * Created by Administrator on 2016/12/6.
 */
public class ItemBean {
    private String addr;
    private String area;
    private String nm;
    private boolean sell;
    private String sellPrice;

    public ItemBean() {
    }

    public ItemBean(String addr, String area, String nm, boolean sell,String sellPrice) {
        this.addr = addr;
        this.area = area;
        this.nm = nm;
        this.sellPrice = sellPrice;
        this.sell = sell;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "addr='" + addr + '\'' +
                ", area='" + area + '\'' +
                ", nm='" + nm + '\'' +
                ", sell=" + sell +
                ", sellPrice='" + sellPrice + '\'' +
                '}';
    }
}
