package com.example.demo.entity;

import java.util.Date;

public class Collectinfo {
    private Integer id;

    private String useropenid;

    private String productopenid;

    private String title;

    private Double price;

    private Date time;

    private Date createtime;

    private Integer type;

    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseropenid() {
        return useropenid;
    }

    public void setUseropenid(String useropenid) {
        this.useropenid = useropenid == null ? null : useropenid.trim();
    }

    public String getProductopenid() {
        return productopenid;
    }

    public void setProductopenid(String productopenid) {
        this.productopenid = productopenid == null ? null : productopenid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}