package com.lovehome.publish.entity;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class Release_pager_entity {
    public String parent_cate_img_url;
    public String parent_cate_name;

    public String getParent_cate_img_url(){return parent_cate_img_url;}
    public void setParent_cate_img_url(String parent_cate_img_url){
        this.parent_cate_img_url=parent_cate_img_url;
    }
    public String getParent_cate_name(){return parent_cate_name;}
    public void setParent_cate_name(String parent_cate_name){
        this.parent_cate_name=parent_cate_name;
    }

    @Override
    public String toString() {
        return "Release_pager_entity{" +
                "parent_cate_img_url='" + parent_cate_img_url + '\'' +
                ", parent_cate_name='" + parent_cate_name + '\'' +
                '}';
    }
}
