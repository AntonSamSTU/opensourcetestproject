package opensourcetestproject.zcontroller;

import opensourcetestproject.model.Role;
import opensourcetestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String reg(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String reg(Model model, @RequestParam String username, @RequestParam String password,
                      @RequestParam String role) {
        if (userService.saveUser(username, password, Role.valueOf(role))) {
            return
                    "redirect:/login";
        } else {
            return
                    "registration";
        }
    }
}