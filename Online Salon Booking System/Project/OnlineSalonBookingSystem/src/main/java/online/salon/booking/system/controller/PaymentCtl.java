package online.salon.booking.system.controller;

import java.util.List;

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

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.dto.PaymentDTO;
import online.salon.booking.system.dto.UserDTO;
import online.salon.booking.system.exception.DuplicateRecordException;
import online.salon.booking.system.form.PaymentForm;
import online.salon.booking.system.service.CartInt;
import online.salon.booking.system.service.PaymentServiceInt;


@Controller
public class PaymentCtl extends BaseCtl{
	
	
	@Autowired
	private CartInt booking;
	
	@Autowired
	private PaymentServiceInt payment;
	
	
	@GetMapping("/pay")
	public String payment(@ModelAttribute("form") PaymentForm form,
		@RequestParam(required = false) String operation,long totalcharge, Long id, HttpSession session, Model model,HttpServletRequest request) {
		
//		CartDTO bean = booking.FindByPk(id);
//		booking.Paid(id,bean.getStatus());
		PaymentDTO dto = new PaymentDTO();
		dto.setPayment(totalcharge);
		form.populate(dto);
        return "payment";		
	}
	
	@PostMapping("/submitpayment")
	public String submitPayment(@RequestParam String operation, @Valid @ModelAttribute("form") PaymentForm form,
			BindingResult bindingResult, Model model, HttpSession session, HttpServletRequest request) {
	
		
//		if (bindingResult.hasErrors()){
//			return "payment";
//		}
		
		try {
			PaymentDTO bean = (PaymentDTO) populateDTO(form.getDTO(), request);
			System.out.println(bean.getUsername());
			UserDTO uDto = (UserDTO) session.getAttribute("user");
			bean.setUserid(uDto.getId());
			bean.setUsername(uDto.getUserName());
			bean.setStatus("Paid");
            payment.add(bean);
			model.addAttribute("success", "Payment done Successfully !!");
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		return "payment";
	}
	
	
	@RequestMapping(value = "/paymentlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String PaymentList(@ModelAttribute("form") PaymentForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/paymentlist";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			PaymentDTO dto = (PaymentDTO) form.getDTO();
		     List<PaymentDTO> list = payment.search(dto);
			 model.addAttribute("list", list);
			return "paymentList";
		}
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		long roleid = uDto.getRoleid();
		if (roleid == 2) {
			try {
				List<PaymentDTO> list = payment.userpaymentlist(uDto.getId());
				if (list.size() == 0) {
					model.addAttribute("error", "Record not found");
				}
				model.addAttribute("list", list);
				
				return "paymentList";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
		List<PaymentDTO> list = payment.list();
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		model.addAttribute("list", list);
		}
		return "paymentList";
	}
	
	
	@GetMapping("/payment/Delete")
	public String Delete(@ModelAttribute("form") PaymentForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		payment.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<PaymentDTO> list = payment.list();
		model.addAttribute("list", list);
		return "paymentList";
	}
	
	
	

}
