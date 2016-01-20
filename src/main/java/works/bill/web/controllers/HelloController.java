/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.bill.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import works.bill.entities.User;
import works.bill.repositories.UserRepository;

/**
 *
 * @author bill
 */
@Controller
public class HelloController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/")
    public String index(Model model) {
        User user = userRepository.findOneByEmail("bill@bill.works");
        if (user==null) {
            userRepository.save(new User("Bill Collins", "bill@bill.works", "swordfish"));
        }
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
