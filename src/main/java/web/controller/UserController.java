package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("name") String name, Model model) {
        User user = new User(name);
        userService.add(user);
        model.addAttribute("addUser", user);
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id,
                           @RequestParam("name") String name,
                           Model model) {
        User user = userService.getUserById(id);
        user.setName(name);
        userService.update(user);
        model.addAttribute("editUser", user);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id,
                             Model model) {
        User user = userService.getUserById(id);
        userService.delete(id);
        model.addAttribute("deleteUser", user);
        return "delete";
    }
}
