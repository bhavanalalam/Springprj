package in.sp.backend;
import com.example.dao.UserDAO;
import com.example.dao.UserDAOImpl;
import com.example.dto.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    
    private UserDAO userDAO = new UserDAOImpl();
 

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; 
    }

    @PostMapping("/signup")
    public String register(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Model model) {
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        boolean success = userDAO.registerUser(user);

        if (success) {
            model.addAttribute("msg", "Registration successful");
            return "login";
        } else {
            model.addAttribute("msg", " The User Already Exists");
            return "signup";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        UserDTO user = userDAO.loginUser(email, password);

        if (user != null) {
            model.addAttribute("name", user.getName());
            return "success"; 
        } else {
            model.addAttribute("msg", "Invalid email or password!");
            return "error";
        }
    }
}
