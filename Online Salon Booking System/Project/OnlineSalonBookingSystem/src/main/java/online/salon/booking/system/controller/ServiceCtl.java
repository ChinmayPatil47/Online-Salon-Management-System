package online.salon.booking.system.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import online.salon.booking.system.dto.ServicesDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.ServicesForm;
import online.salon.booking.system.service.ServicesInt;

@Controller
public class ServiceCtl extends BaseCtl{
	
	@Autowired
	private ServicesInt service;
	
	@GetMapping("/services")
	public String addService(@ModelAttribute("form") ServicesForm form, Model model)
	{
		return "addservice";
	}
	
	@PostMapping("/addservice")
	public String submitService(@RequestParam("image")MultipartFile file, String operation,@Valid @ModelAttribute("form") ServicesForm form,
			BindingResult bindingResult,Model model,HttpServletRequest request) throws IOException
	{
			
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/service";
		}
		
		if (bindingResult.hasErrors()) {
			return "addservice";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				ServicesDTO bean = (ServicesDTO) populateDTO(form.getDTO(), request);
			    bean.setImage(form.getImage().getBytes());
			    if (bean.getId()>0) {
			    	service.Update(bean);
					model.addAttribute("success", "Service Data Updated");
				}else {
					service.add(bean);
					model.addAttribute("success", "Service Added SuccessFully !!");
				}
				return "addservice";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "addservice";
		}
		return "addservice";
	}
	
	@RequestMapping(value = "/serviceList", method = { RequestMethod.GET, RequestMethod.POST })
	public String UserList(@ModelAttribute("form") ServicesForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/serviceList";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			ServicesDTO dto = (ServicesDTO) form.getDTO();
		     List<ServicesDTO> list = service.search(dto);
		     if (list.size() == 0) {
					model.addAttribute("error", "Record not found");
				}
			model.addAttribute("list", list);
			return "servicelist";
		}
		List<ServicesDTO> list = service.list();
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		return "servicelist";
	}
	
	
	@GetMapping("/gender")
	public String Service(@ModelAttribute("form") ServicesForm form,
			@RequestParam(required = false) String operation,String gender, HttpSession session, Model model) {
		System.out.println("gender:"+gender);
		//ServicesDTO bean = service.FindByServiceName(gender);
		List<ServicesDTO> list  = service.servicelist(gender);
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		return "servicelist";
	}
	
	@GetMapping("/Delete")
	public String Delete(@ModelAttribute("form") ServicesForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		service.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<ServicesDTO> list = service.list();
		model.addAttribute("list", list);
		return "servicelist";
	}
	
	@GetMapping("/update")
	public String findByPk(@ModelAttribute("form") ServicesForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		ServicesDTO bean = service.FindByPk(id);
		form.populate(bean);
		return "addservice";
	}
	
	@GetMapping("/image")
	 public void showImage(@Param("id") Long id, HttpServletResponse response, ServicesDTO v)
	   throws ServletException, IOException {
		v = service.FindByPk(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(v.getImage());
		response.getOutputStream().close();
	 }
	
	@GetMapping("/image/{id}")
	public void getServicePhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {

		Blob blb=service.getImageById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

}
