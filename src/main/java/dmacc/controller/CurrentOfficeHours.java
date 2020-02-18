package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dmacc.model.OfficeHour;
import dmacc.model.Requests;
import dmacc.model.User;
import dmacc.repository.RequestsRepository;
import dmacc.service.AvailableService;
import dmacc.service.UserService;

@Controller
public class CurrentOfficeHours {

	@Autowired
	private AvailableService availableService;
	@Autowired
	private RequestsRepository requestsRepo;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/currentOfficeHours", method = RequestMethod.GET)
	public ModelAndView currentHours() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("currentHours", availableService.findCurrentOfficeHours());
		modelAndView.setViewName("currentOfficeHours");
		return modelAndView;
	}


	@GetMapping("/recordVisit/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		User hereToSee = userService.findByUserId((int) id);
		System.out.println(" ---> Found User " + hereToSee.getName());
		requestsRepo.save(new Requests(hereToSee));
		modelAndView.addObject("currentHours", availableService.findCurrentOfficeHours());
		modelAndView.addObject("successMessage", hereToSee.getName() + " is being notified");
		modelAndView.setViewName("currentOfficeHours");
		return modelAndView;
	}
}
