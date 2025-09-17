package in.sp.backend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.entity.UserIno;

@Controller
public class MyController {
	@GetMapping("/home")
	public String openHome() {
		return "hello";
	}
	@GetMapping("/registration")
	public String openRegisterPage() {
		return "registration";	
	}
	@GetMapping("/login")
	public String openLoginPage() {
		return "login";
	}
	
	@PostMapping("/registrationdata")

		public String registerData(@RequestParam("name") String name,
				@RequestParam("email") String email, @RequestParam("password") String password,Model model) {
		    model.addAttribute("regName", name);
		    model.addAttribute("regPassword", password);
		    model.addAttribute("regEmail", email);
    
		 
	    return "login"; 	
	}
	
	@PostMapping("/logindata")
	public String PostData(
	                       @RequestParam("password") String password,
	                       @RequestParam("email") String email,
	                       @ModelAttribute("regPassword") String regPassword,
	                       @ModelAttribute("regEmail") String regEmail,
	                       Model model) {
	    
	    if (password.equals(regPassword) && email.equals(regEmail)) {
	        return "profile"; 
	    } else {
	        model.addAttribute("error", "Invalid login credentials");
	        return "login"; 
	    }
	}
    }


