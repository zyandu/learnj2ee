package me.zy.springframe.controller;

import me.zy.springframe.domain.User;
import me.zy.springframe.service.user.UserService;
import me.zy.springframe.strreotype.ZyAutoWired;
import me.zy.springframe.strreotype.ZyController;
import me.zy.springframe.strreotype.ZyRequestMapping;


@ZyController
@ZyRequestMapping("/user")
public class UserController {
    @ZyAutoWired
    protected UserService userService;

    @ZyRequestMapping("/login")
    public void login(User user){
        System.out.println("login ");
    }
}
