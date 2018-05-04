package com.example.sy.meituanlistview;

/**
 * Created by suoyue on 2018/5/3.
 */

public class MeiTuanHomeBean {
    private int syIcon;
    private String title;
    private String content;
    private String distance;
    private double price;
    private double salePrice;
    private boolean isTakeOut;      //是否支持外卖
    private boolean isNewGuest;     //是否新客优惠
    private int sold;

    public MeiTuanHomeBean() {
    }

    public MeiTuanHomeBean(int syIcon, String title, String content, String distance, double price, double salePrice, boolean isTakeOut, boolean isNewGuest, int sold) {
        this.syIcon = syIcon;
        this.title = title;
        this.content = content;
        this.distance = distance;
        this.price = price;
        this.salePrice = salePrice;
        this.isTakeOut = isTakeOut;
        this.isNewGuest = isNewGuest;
        this.sold = sold;
    }

    public int getSyIcon() {
        return syIcon;
    }

    public void setSyIcon(int syIcon) {
        this.syIcon = syIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isTakeOut() {
        return isTakeOut;
    }

    public void setTakeOut(boolean takeOut) {
        isTakeOut = takeOut;
    }

    public boolean isNewGuest() {
        return isNewGuest;
    }

    public void setNewGuest(boolean newGuest) {
        isNewGuest = newGuest;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "MeiTuanHomeBean{" +
                "syIcon=" + syIcon +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", distance='" + distance + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", isTakeOut=" + isTakeOut +
                ", isNewGuest=" + isNewGuest +
                ", sold=" + sold +
                '}';
    }
}
