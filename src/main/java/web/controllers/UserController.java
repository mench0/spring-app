package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //получение всех пользователей
    @GetMapping("")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsers", userService.allUsers());
        return "show-all-users";
    }

    //сохранение пользвателя
    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    //переход на страницу создания пользователя
    @GetMapping("/create")
    public String create(@ModelAttribute("user") User user){
        return "new";
    }

    // получение(выбор) одного пользователя
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

    //переход на страницу редактирования
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    // редактирование при нажатии кнопки
    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    //удаление пользователя
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
