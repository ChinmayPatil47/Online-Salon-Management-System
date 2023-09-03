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

import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.dto.ServicesDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.ProductForm;
import online.salon.booking.system.form.ServicesForm;
import online.salon.booking.system.service.ProductInt;
import online.salon.booking.system.service.ServicesInt;


@Controller
public class ProductCtl extends BaseCtl{
	
	@Autowired
	public ServicesInt serviceint;
	
	@Autowired
	public ProductInt service;
	

	
	@ModelAttribute
	public void preload(Model model)
	{
		List<ServicesDTO> list = serviceint.list();
		model.addAttribute("servicelist", list);
	}
	
	@GetMapping("/products")
	public String ProductView(@ModelAttribute("form")ProductForm form,HttpSession session,Model model, HttpServletRequest request){
		return "product";
	}
	
	@PostMapping("/addproduct")
	public String submitProduct(@RequestParam("image")MultipartFile file, String operation,@Valid @ModelAttribute("form") ProductForm form,
			BindingResult bindingResult,Model model,HttpServletRequest request) throws IOException
	{
			
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/product";
		}
		
		if (bindingResult.hasErrors()) {
			return "product";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				ProductDTO bean = (ProductDTO) populateDTO(form.getDTO(), request);
			    bean.setImage(form.getImage().getBytes());
			    long serviceid = bean.getServiceid();
				ServicesDTO serviceDto = serviceint.FindByPk(serviceid);
				String serviceName = serviceDto.getServiceName();
				bean.setServiceName(serviceName);
			    if (bean.getId()>0) {
			    	service.Update(bean);
					model.addAttribute("success", "Product Data Updated");
				}else {
					service.add(bean);
					model.addAttribute("success", "Product Added SuccessFully !!");
				}
				return "product";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "product";
		}
		return "product";
	}
	
	@RequestMapping(value = "/productsList", method = { RequestMethod.GET, RequestMethod.POST })
	public String ProductList(@ModelAttribute("form") ProductForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/productlist";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			ProductDTO dto = (ProductDTO) form.getDTO();
		     List<ProductDTO> list = service.search(dto);
		     if (list.size() == 0) {
					model.addAttribute("error", "Record not found");
				}
			model.addAttribute("list", list);
			return "productlist";
		}
		List<ProductDTO> list = service.list();
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		return "productlist";
	}
	
	@GetMapping("/Service")
	public String findByService(@ModelAttribute("form") ServicesForm form,
			@RequestParam(required = false) String operation, Long serviceid, HttpSession session, Model model) {
		ServicesDTO bean = serviceint.FindByPk(serviceid);
		List<ProductDTO> list  = service.productlist(bean.getId());
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		return "productlist";
	}
	
	
	@GetMapping("/deleteproduct")
	public String Delete(@ModelAttribute("form") ProductForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		service.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<ProductDTO> list = service.list();
		model.addAttribute("list", list);
		return "productlist";
	}
	
	@GetMapping("/Updateproduct")
	public String findByPk(@ModelAttribute("form") ProductForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		ProductDTO bean = service.FindByPk(id);
		form.populate(bean);
		return "product";
	}
	
	@GetMapping("/productImage")
	 public void showImage(@Param("id") Long id, HttpServletResponse response, ProductDTO v)
	   throws ServletException, IOException {
		v = service.FindByPk(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(v.getImage());
		response.getOutputStream().close();
	 }
	
	@GetMapping("/productImage/{id}")
	public void getServicePhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {

		Blob blb=service.getImageById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}



}
