package online.salon.booking.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import online.salon.booking.system.dto.UserDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.ChangePasswordForm;
import online.salon.booking.system.form.LoginForm;
import online.salon.booking.system.form.MyProfileForm;
import online.salon.booking.system.service.UserServiceImpl;



@Controller
public class LoginCtl extends BaseCtl{
	
	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";
	
	
	@Autowired
	public UserServiceImpl userserice;

	@GetMapping("/loginView") 
	public String display(@ModelAttribute("form")LoginForm form,HttpSession session,Model model) {
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have Logout Successfully !!");
		}
		return "login";
	}
	
	@PostMapping("/loginView")
	public String login(@RequestParam String operation,HttpSession session,@Valid @ModelAttribute("form") LoginForm form,BindingResult 
			bindingResult,Model model,HttpServletRequest request){
	
	if (bindingResult.hasErrors()) {
		return "login";
	}
	UserDTO bean = userserice.Authentication((UserDTO)form.getDTO());
	if (bean != null) {
		if (bean.getRoleid() == 0) {
			model.addAttribute("msg", "Email Id & Password Reqired");
			return "login";
		}
		session.setAttribute("user", bean);
		return "redirect:/welcome2";
	}
	if (bean == null) {
		model.addAttribute("error", "Email Id & Password Invalid");
	}
	return "login";
	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		UserDTO entity = (UserDTO) session.getAttribute("user");
		form.populate(entity);
		return "myprofile";
	}

	@PostMapping(value = "/profilee")
	public String submitProfile(HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,
			BindingResult bindingResult, @RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/profile";
		}

//		if (bindingResult.hasErrors()) {
//			return "myprofile";
//		}
		UserDTO entity = (UserDTO) session.getAttribute("user");
		entity = userserice.FindByPk(entity.getId());
		entity.setUserName(form.getUserName());
		entity.setPassword(form.getPassword());
		entity.setPhoneNo(form.getPhoneNo());
		entity.setGender(form.getGender());
		entity.setEmail(form.getEmail());
		try {
			userserice.Update(entity);
		} catch (DuplicateRecordException e) {

		}
		model.addAttribute("success", "Profile Update successfully");

		return "myprofile";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		return "changePassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "changePassword";
		}
		if (form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {

			UserDTO dto = (UserDTO) session.getAttribute("user");
			dto = userserice.FindByPk(dto.getId());

			if (userserice.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword())) {
				model.addAttribute("success", "Password changed Successfully");
			} else {
				model.addAttribute("error", "Old Passowors Does not Matched");
			}
		} else {
			model.addAttribute("error", "New Password and confirm password does not matched");
		}
		return "changePassword";
	}
	
}
