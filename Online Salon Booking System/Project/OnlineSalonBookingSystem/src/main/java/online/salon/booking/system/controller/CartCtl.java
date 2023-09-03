package online.salon.booking.system.controller;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.dto.ServicesDTO;
import online.salon.booking.system.dto.UserDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.CartForm;
import online.salon.booking.system.service.CartInt;
import online.salon.booking.system.service.ProductInt;
import online.salon.booking.system.service.ServicesInt;

@Controller
public class CartCtl extends BaseCtl {

	@Autowired
	private ProductInt service;
	
	@Autowired
	public ServicesInt serviceint;

	@Autowired
	private CartInt cart;

	@GetMapping("/bookProduct")
	public String book(@ModelAttribute("form") CartForm form, @RequestParam(required = false) String operation, Long id,
			String productName, long price, HttpSession session, Model model, HttpServletRequest request) {

		try {
			CartDTO dto = new CartDTO();
			UserDTO uDto = (UserDTO) session.getAttribute("user");
			dto.setUserid(uDto.getId());
			dto.setUserName(uDto.getUserName());
			dto.setProductname(productName);
			dto.setServicecharge(price);
			dto.setStatus("booked");
			 List<CartDTO> list = cart.userorderlist(uDto.getId());
			    model.addAttribute("list", list);
			    Iterator<CartDTO> it = list.iterator();
			    long balance = 0;
			    while (it.hasNext()) {
			    	CartDTO txBean = (CartDTO) it.next();
					 balance =  txBean.getTotalcharge();
				}
			    long amount = price + balance;
		        dto.setTotalcharge(amount);
			cart.add(dto);
			model.addAttribute("success", "Product Added in Cart Successfully !!");
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		System.out.println("ID:"+id);
		ServicesDTO bean = serviceint.FindByPk(id);
		List<ProductDTO> list  = service.productlist(bean.getId());
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		return "productlist";
	}
	
	@RequestMapping(value = "/cartlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String BookingList(@ModelAttribute("form") CartForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/bookinglist";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			CartDTO dto = (CartDTO) form.getDTO();
		     List<CartDTO> list = cart.search(dto);
			 model.addAttribute("list", list);
			return "bookinglist";
		}
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		long roleid = uDto.getRoleid();
		if (roleid == 2) {
			try {
				System.out.println("User List");
				List<CartDTO> list = cart.userorderlist(uDto.getId());
				if (list.size() == 0) {
					model.addAttribute("error", "Record not found");
				}
				model.addAttribute("list", list);
				return "bookinglist";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
		List<CartDTO> list = cart.list();
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		}
		return "bookinglist";
	}
	
	@GetMapping("/order/Delete")
	public String Delete(@ModelAttribute("form") CartForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		cart.Delete(id);
		model.addAttribute("success", "Remove Successfully!!!");
		List<CartDTO> list = cart.list();
		model.addAttribute("list", list);
		return "bookinglist";
	}
	


}
