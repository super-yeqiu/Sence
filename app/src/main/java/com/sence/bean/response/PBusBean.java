package com.sence.bean.response;

import java.util.List;

/**
 * Created by zwy on 2019/3/27.
 * package_name is com.sence.bean.response
 * 描述:SenceGit
 */
public class PBusBean {

    /**
     * cart : [{"shopname":"hhhh","active":"1","favourable":"4","postage":"6","express":"1","goods":[{"num":"2",
     * "name":"一号商品","img":"","price":"4","vprice":"5","postage":"4.00","uid":"1"}]}]
     * isMember : 0
     * money : 2365
     */

    private String isMember;
    private String money;
    private List<CartBean> cart;

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public List<CartBean> getCart() {
        return cart;
    }

    public void setCart(List<CartBean> cart) {
        this.cart = cart;
    }

    public static class CartBean {
        /**
         * shopname : hhhh
         * active : 1
         * favourable : 4
         * postage : 6
         * express : 1
         * goods : [{"num":"2","name":"一号商品","img":"","price":"4","vprice":"5","postage":"4.00","uid":"1"}]
         */
        private boolean isSelect = false;
        private String shopname;
        private String active;
        private String favourable;
        private String postage;
        private String express;
        private List<GoodsBean> goods;

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getFavourable() {
            return favourable;
        }

        public void setFavourable(String favourable) {
            this.favourable = favourable;
        }

        public String getPostage() {
            return postage;
        }

        public void setPostage(String postage) {
            this.postage = postage;
        }

        public String getExpress() {
            return express;
        }

        public void setExpress(String express) {
            this.express = express;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public static class GoodsBean {
            /**
             * num : 2
             * name : 一号商品
             * img :
             * price : 4
             * vprice : 5
             * postage : 4.00
             * uid : 1
             */

            private int num;
            private String name;
            private String img;
            private String price;
            private String vprice;
            private String postage;
            private String uid;
            private boolean isSelect = false;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getVprice() {
                return vprice;
            }

            public void setVprice(String vprice) {
                this.vprice = vprice;
            }

            public String getPostage() {
                return postage;
            }

            public void setPostage(String postage) {
                this.postage = postage;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }
        }
    }
}