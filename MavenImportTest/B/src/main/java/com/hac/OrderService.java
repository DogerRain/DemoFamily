package com.hac;

public class OrderService {

    public String getOrderInfo(String orderId){
        String userInfo = new UserService().getUserInfo(2022);

        String order = "orderName:car,"+userInfo;

        String transport = new InfoService().getInfo();

        return order;

    }



}
