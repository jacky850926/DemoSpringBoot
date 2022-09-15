package tw.leonchen.product.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository pRepo;
	
//	單筆查詢
	public Product findById(int id) {
		Optional<Product> op = pRepo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;
	}
	
//	全部查詢
	public List<Product> findAll(){
		return pRepo.findAll();
	}
//	分頁查詢
	public Page<Product> findAllByPage(Pageable pageable){
		return pRepo.findAll(pageable);
	}

}
