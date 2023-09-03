package online.salon.booking.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import online.salon.booking.system.form.UserForm;
import online.salon.booking.system.service.UserServiceImpl;




@Controller
public class UserCtl extends BaseCtl {
	
	@Autowired
	public UserServiceImpl userservice;
	
	

	@RequestMapping(value = "/userList", method = { RequestMethod.GET, RequestMethod.POST })
	public String UserList(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/userList";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			UserDTO dto = (UserDTO) form.getDTO();
			List<UserDTO> list = userservice.search(dto);
			model.addAttribute("list", list);
			return "list";
		}
		List<UserDTO> list = userservice.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/home/Delete")
	public String Delete(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		userservice.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<UserDTO> list = userservice.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/home/update")
	public String findByPk(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		UserDTO bean = userservice.FindByPk(id);
		form.populate(bean);
		return "update";
	}
	
	@PostMapping("/home/update")
	public String update(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation,HttpSession session, BindingResult bindingResult,Model model,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "update";
		}
		try {
			if (OP_UPDATE.equalsIgnoreCase(form.getOperation())) {
				UserDTO entity = (UserDTO) populateDTO(form.getDTO(), request);
				userservice.Update(entity);
				model.addAttribute("success", "User Data Updated");
				return "update";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "update";
		}
		return "update";
	}
}
