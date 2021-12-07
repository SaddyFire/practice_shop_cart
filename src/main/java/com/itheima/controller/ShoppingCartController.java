package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.ShoppingCart;
import com.itheima.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add/{userId}")
    public Result add(@PathVariable Long userId, @RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.add(userId,shoppingCart);
    }
    @GetMapping("/list/{userId}")
    public Result findById(@PathVariable Long userId){
        return shoppingCartService.findById(userId);
    }
    @GetMapping("/clean/{userId}")
    public Result clean(@PathVariable Long userId){
        return shoppingCartService.clean(userId);
    }

}
