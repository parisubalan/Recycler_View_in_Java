package com.parisubalan.recyclerview.pojo;

public class RecyclerPojo {

    private String title;
    private String subTitle;
    private int imageView;


    public RecyclerPojo(int imageView) {
        this.imageView = imageView;
    }


    public RecyclerPojo(String title, String subTitle, int imageView) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }


}
