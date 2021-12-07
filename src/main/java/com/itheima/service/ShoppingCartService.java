package com.itheima.service;


import com.itheima.pojo.Result;
import com.itheima.pojo.ShoppingCart;

public interface ShoppingCartService {
    /**
     * 添加菜品到购物车
     * @param userId
     * @param shoppingCart
     * @return
     */
    Result add(Long userId, ShoppingCart shoppingCart);

    /**
     * 查询用户购物车
     * @param userId
     * @return
     */
    Result findById(Long userId);

    /**
     * 清空用户购物车
     * @param userId
     * @return
     */
    Result clean(Long userId);
}
