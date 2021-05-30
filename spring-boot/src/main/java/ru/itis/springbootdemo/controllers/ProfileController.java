package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.PaperDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.UserSettingsDto;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.PapersService;
import ru.itis.springbootdemo.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, HttpServletResponse response, HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("not_change_settings")) {
                UserDto user = usersService.getUserById(userDetails.getUser().getId());
                model.addAttribute("user", user);
                return "profile_page";
            }
        }
        response.addCookie(new Cookie("not_change_settings","true"));
        return "redirect:/change-user-settings";

    }

    @GetMapping("/change-user-settings")
    public String getProfileSettings() {
        return "user_settings";
    }

    @PostMapping("/change-user-settings")
    public String setSettings(@AuthenticationPrincipal UserDetailsImpl userDetails, UserSettingsDto userSettingsDto) {
        userSettingsDto.setUserId(userDetails.getUser().getId());
        usersService.changeUserSettings(userSettingsDto);
        return "redirect:/profile";
    }
}
