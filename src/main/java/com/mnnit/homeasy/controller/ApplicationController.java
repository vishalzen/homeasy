package com.mnnit.homeasy.controller;

import com.mnnit.homeasy.repository.*;
import com.mnnit.homeasy.model.*;
import com.mnnit.homeasy.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;


@Controller
@RequestMapping({"/"})
public class ApplicationController {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HostelRepository hostelRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessRepository messRepository;

    @Autowired
    MessRequestRepository messRequestRepository;

    @Autowired
    RoomRequestRepository roomRequestRepository;

    @Autowired
    LeaveRequestRepository leaveRequestRepository;


    @RequestMapping({"/","/user"})
    public RedirectView home(Principal principal){
        User user = userRepository.findByUsername(principal.getName());

        if(user.getRole().compareTo("USER") == 0){
            return new RedirectView("/user/home");
        }
        else{
            return new RedirectView("/admin/home");
        }
    }


    /*
        login page for users/admin
    */
    @RequestMapping("/login")
    public String loginPage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/user/";
        }
        return "login";
    }

    /*
        after logging out
    */
    @RequestMapping("/logout-success")
    public String logout(){
        return "logout";
    }


    /*
        registration page
    */
    @RequestMapping("/signup")
    public String signUp(User user){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/user/";
        }

        return "signup";
    }


    @PostMapping("/signup")
    public String addUser(User user, ModelMap modelMap){

        try{
            userDetailsService.loadUserByUsername(user.getUsername());
        }catch (UsernameNotFoundException ue) {
            try {
                UserDetails userDetails = userDetailsService.registerUser(user);
                return "redirect:/user/student";
            } catch (Exception e) { e.printStackTrace(); }
        }

        modelMap.addAttribute("error_message", "Registration Unsuccessful!");
        return "signup";
    }
}