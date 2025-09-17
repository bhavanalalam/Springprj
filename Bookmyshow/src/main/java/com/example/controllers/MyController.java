package com.example.controllers;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    
    // Show registration page
    @GetMapping("/registration")
    public String openRegisterPage(Model model) {
        model.addAttribute("user", new User());  // Add an empty User object to the model for form binding
        return "registration";    
    }
    
    // Show login page
    @GetMapping("/login")
    public String openLoginPage() {
        return "login";
    }

    // Handle registration form submission
    @PostMapping("/registrationdata")
    public String handleRegistration(@ModelAttribute User user, Model model) {
        // Validation checks for registration
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("error", "All fields are required.");
            return "registration";  // Return to the registration page with an error message
        }

        // Here you can add logic to save the User object to the database
        // For example, you might want to add the user to a service/repository layer

        // If successful, show a success message and redirect to the login page
        model.addAttribute("message", "Registration successful! Please log in.");
        return "login";  // Redirect to login page
    }

    // Handle login form submission
    @PostMapping("/logindata")
    public String handleLogin(@RequestParam("email") String email, 
                              @RequestParam("password") String password, 
                              Model model) {
        // Example: Authentication logic (you can replace it with actual logic like checking database)
        if (email.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Email and password cannot be empty.");
            return "login";  // Stay on the login page with an error message
        }

        // Mock login validation (replace with actual user lookup/authentication)
        if (email.equals("user@example.com") && password.equals("password123")) {
            model.addAttribute("message", "Login successful!");
            return "home";  // Redirect to the home page after successful login
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";  // Stay on the login page with an error message
        }
    }
}
