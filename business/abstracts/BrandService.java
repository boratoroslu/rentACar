package kodlama.rentACar.business.abstracts;

import java.util.List;

import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.requests.UpdateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.rentACar.business.responses.GetByIdBrandResponse;


public interface BrandService {

	//iş kurallarını yapacagım yapıyı tasarlıyoruz
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void add(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	void update(UpdateBrandRequest updateBrandRequest);
	
}
