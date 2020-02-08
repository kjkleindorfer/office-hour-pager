package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.User;
import dmacc.repository.UserRepository;

@Controller
public class WebController {
	@Autowired
	UserRepository repo;
	
	@GetMapping("/addNewUser")
	public String addNewUser(Model model) {
	    User u = new User();
	    model.addAttribute("newUser", u);
	    return "input";
	}
	
	@PostMapping("/addNewUser")
	public String addNewContact(@ModelAttribute User u, Model model) {
		repo.save(u);
		model.addAttribute("users", repo.findAll());
		return "results";
	}

	@GetMapping("/viewAll")
	public String viewAllContacts(Model model) {
		model.addAttribute("users", repo.findAll());
		return "results";
	}
}
