package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dmacc.model.OfficeHour;
import dmacc.model.Term;
import dmacc.model.User;
import dmacc.service.HourService;
import dmacc.service.TermService;
import dmacc.service.UserService;

@Controller
public class HourController {
	@Autowired
	private UserService userService;
	@Autowired
	private HourService hourService;
	@Autowired
	private TermService termService;

	@GetMapping(value = "/viewAllOfficeHours")
	public ModelAndView viewAllHours() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());

		modelAndView.addObject("enteredHours", hourService.findByUser(user));

		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " "
				+ user.getLastName() + " (" + user.getEmail() + ")");
		return modelAndView;
	}

	@GetMapping(value = "/addOfficeHour")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " "
				+ user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.addObject("termList", termService.findAll());
		modelAndView.addObject("officeHour", new OfficeHour());
		modelAndView.addObject("user", user);
		modelAndView.setViewName("addOfficeHour");
		return modelAndView;
	}

	@PostMapping(value = "/addOfficeHour")
	public ModelAndView insertNewOfficeHour(OfficeHour hour, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		hour.setUser(user);
		hourService.save(hour);
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		// modelAndView.addObject("adminMessage","Content Available Only for Users with
		// Admin Role");
		modelAndView.addObject("termList", termService.findAll());
		modelAndView.addObject("officeHour", new OfficeHour());
		modelAndView.addObject("user", user);
		modelAndView.addObject("successMessage", "Office Hour has been saved successfully");
		modelAndView.setViewName("addOfficeHour");
		return modelAndView;
	}

	@GetMapping(value = "/createTerm")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Term t = new Term();
		modelAndView.addObject("term", t);
		modelAndView.setViewName("createTerm");
		return modelAndView;
	}

	@PostMapping(value = "/createTerm")
	public ModelAndView createNewTerm(@Valid Term t, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		termService.save(t);

		modelAndView.addObject("successMessage", "Term has been saved successfully");
		modelAndView.addObject("term", new Term());
		modelAndView.setViewName("createTerm");

		return modelAndView;
	}

	// @ModelAttribute("termList")
	public List<String> getTermList() {
		List<Term> termList = termService.findAll();
		List<String> termStringList = new ArrayList<String>();
		for (Term t : termList) {
			System.out.println(t.getTermCode());
			termStringList.add(t.getTermCode());
		}
		return termStringList;
	}

}
