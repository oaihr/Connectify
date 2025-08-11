package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.customer.Customer;
import com.app.service.customer.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/login")
    public String loginForm() {
        return "customer/login";
    }

    @PostMapping("/customer/login")
    public String login(@RequestParam String id,
                        @RequestParam String pw,
                        HttpSession session,
                        Model model) {

        Customer customer = customerService.login(id, pw);
        if (customer != null) {
            session.setAttribute("customer", customer);
            return "redirect:/customer/main";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "customer/login";
        }
    }

    @GetMapping("/customer/signup")
    public String signupForm() {
        return "customer/signup";
    }

    @PostMapping("/customer/signup")
    public String signup(Customer customer) {
        customerService.signup(customer);
        return "redirect:/customer/login";
    }

    @GetMapping("/customer/main")
    public String main() {
        return "customer/main";
    }
}
