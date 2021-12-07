package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.dao.ShoppingCartDao;
import com.itheima.pojo.Result;
import com.itheima.pojo.ShoppingCart;
import com.itheima.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCarDao;


    @Override
    public Result add(Long userId, ShoppingCart shoppingCart) {
        shoppingCart.setUserId(userId);
        int i = shoppingCarDao.insert(shoppingCart);

        return new Result(i,"添加菜品成功");
    }

    @Override
    public Result findById(Long userId) {

        //int i = 1/0;
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingCart::getUserId,userId);
        List<ShoppingCart> shoppingCarts = shoppingCarDao.selectList(lqw);
        if(shoppingCarts.size() == 0){
            return new Result(0,"购物车暂无内容");
        }
        return new Result(1,"查询成功",shoppingCarts);
    }

    @Override
    public Result clean(Long userId) {
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingCart::getUserId,userId);
        int i = shoppingCarDao.delete(lqw);

        System.out.println(i);
        if(i == 0){
            return new Result(0,"购物车暂无内容");
        }
        return new Result(1,"清除购物车成功");
    }
}
