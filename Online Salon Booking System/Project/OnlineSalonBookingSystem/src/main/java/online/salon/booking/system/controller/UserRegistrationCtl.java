package online.salon.booking.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import online.salon.booking.system.dto.UserDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.UserForm;
import online.salon.booking.system.service.UserServiceInt;


@Controller
public class UserRegistrationCtl extends BaseCtl{
	
	
	
	@Autowired
	public UserServiceInt userServiceInt;
	
	
	@GetMapping("/userRegistration")
	public String display(@ModelAttribute("form") UserForm form, Model model) {
		return "register";
	}
	
	
	@PostMapping("/userRegistration")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UserForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/userRegistration";
		}
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "register";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				UserDTO entity = (UserDTO) populateDTO(form.getDTO(), request);
				userServiceInt.add(entity);
				model.addAttribute("success", "User Registration Is Done");
				return "register";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		}
		return "register";

	}

	
	
}
