/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.bill.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import works.bill.entities.Authorities;
import works.bill.entities.User;
import works.bill.repositories.AuthoritiesRepository;
import works.bill.repositories.UserRepository;

/**
 *
 * @author bill
 */
@Controller
public class IndexController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthoritiesRepository authoritiesRepository;
        
    @RequestMapping("/")
    public String index(Model model) {
        User user = userRepository.findOneByEmail("bill@bill.works");
        if (user==null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userRepository.save(new User("Bill Collins", "bill@bill.works", passwordEncoder.encode("swordfish")));
            authoritiesRepository.save(new Authorities("bill@bill.works", "USER"));
        }
        System.out.println(userRepository.findOneByEmail("bill@bill.works"));
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    @RequestMapping("/hello/")
    public String hello(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "hello";
    }
    
    @RequestMapping("/login/")
    public String login() {
        return "login";
    }
}
