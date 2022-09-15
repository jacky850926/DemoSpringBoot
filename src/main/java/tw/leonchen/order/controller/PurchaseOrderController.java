package tw.leonchen.order.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.order.model.PurchaseOrder;
import tw.leonchen.order.model.PurchaseOrderService;


@Controller
@RequestMapping("/order")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService poService;
	

	@GetMapping (path = "/poproductlist.controller")
	public String processPoProductAction() {
		
		return "order/purchaseOrderProductList";
	}
	
	@GetMapping(path ="/poiteminfo.controller")
	public String processPoProductItemAction(@RequestParam("pid") int pid, Model m) {
		m.addAttribute("pid",pid);
		return "order/purchaseOrderProduct";
	}
	
	
	
//	@GetMapping(path ="/purchaseOrder ")
	
	
	
	@PostMapping(path ="/poinsert.controller")
	@ResponseBody
	public PurchaseOrder processPoInsert(@RequestBody PurchaseOrder po) {
		po.setOdate(new Date());
		return poService.insert(po);
	}

	
	
	
	
	
//	@PostMapping(path ="/purchaseOrder ")
//	@ResponseBody
//	
//	
//	
//	@PostMapping(path ="/purchaseOrder ")
//	@ResponseBody
	
}
