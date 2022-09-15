package tw.leonchen.order.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository poRepo;
	
	
	public PurchaseOrder insert(PurchaseOrder po) {
		return poRepo.save(po);
	}
	
	public PurchaseOrder findById(int id) {
		Optional<PurchaseOrder> op = poRepo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;	
	}
	
	public List<PurchaseOrder> findAll(){
		return poRepo.findAll();
	}
		
}
