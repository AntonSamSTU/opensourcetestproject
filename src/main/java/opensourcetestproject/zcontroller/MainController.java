package opensourcetestproject.zcontroller;

import opensourcetestproject.model.Role;
import opensourcetestproject.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @PostMapping("/")
    public String main(Model model, @AuthenticationPrincipal User user) {

        if (user.getRoles().contains(Role.USER)) {
            return "redirect:/user";
        }
        if (user.getRoles().contains(Role.ADMIN)) {
            return "redirect:/admin";
        }
        return "main";
    }
}
