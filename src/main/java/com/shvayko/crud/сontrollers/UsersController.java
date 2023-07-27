package com.shvayko.crud.сontrollers;

import com.mysql.cj.xdevapi.CreateIndexParams;
import com.shvayko.crud.models.User;
import com.shvayko.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.findALL());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect: /users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("editUser", userService.findOne(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("editUser") User user, @PathVariable("id") int id) {
        userService.update(id,user);
        return "redirect: /users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
