package com.lovehome.lovehome.model;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_item_entity {

    /**
     * childCategoryList : [{"child_category_id":1,"child_category_name":"酒店","parent_cate_id":1},{"child_category_id":2,"child_category_name":"饭店","parent_cate_id":1},{"child_category_id":3,"child_category_name":"西点","parent_cate_id":1},{"child_category_id":4,"child_category_name":"夜宵","parent_cate_id":1},{"child_category_id":5,"child_category_name":"外卖","parent_cate_id":1},{"child_category_id":6,"child_category_name":"茶馆","parent_cate_id":1},{"child_category_id":7,"child_category_name":"零食特产","parent_cate_id":1},{"child_category_id":8,"child_category_name":"其他","parent_cate_id":1},{"child_category_id":9,"child_category_name":"小吃","parent_cate_id":1}]
     * parent_cate_id : 1
     * parent_cate_img_url : http://123.206.87.139:80/LoveHomeTownServer/img/meishi.png
     * parent_cate_name : 美食
     */
    private String parent_cate_img_url;
    private String parent_cate_name;

    public String getParent_cate_img_url() {
        return parent_cate_img_url;
    }

    public void setParent_cate_img_url(String parent_cate_img_url) {
        this.parent_cate_img_url = parent_cate_img_url;
    }

    public String getParent_cate_name() {
        return parent_cate_name;
    }

    public void setParent_cate_name(String parent_cate_name) {
        this.parent_cate_name = parent_cate_name;
    }

    @Override
    public String toString() {
        return "Home_pager_item_entity{" +
                "parent_cate_img_url='" + parent_cate_img_url + '\'' +
                ", parent_cate_name='" + parent_cate_name + '\'' +
                '}';
    }
}
