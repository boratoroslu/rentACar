package kodlama.rentACar.business.abstracts;

import java.util.List;

import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;


public interface BrandService {

	//iş kurallarını yapacagım yapıyı tasarlıyoruz
	
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	
}
