package kodlama.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.rentACar.business.abstracts.BrandService;
import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.rentACar.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir demek.
public class BrandManager implements BrandService{
   private BrandRepository brandRepository; 
   
   @Autowired
	public BrandManager(BrandRepository brandRepository) {
	
	this.brandRepository = brandRepository;
}

@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları
	
	List<Brand> brands = brandRepository.findAll();
	List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();
	for (Brand brand : brands) {
		GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
		responseItem.setId(brand.getId());
		responseItem.setName(brand.getName());
		
		brandResponse.add(responseItem);
	}
		
		return brandResponse;
	}

@Override
public void add(CreateBrandRequest createBrandRequest) {
			Brand brand = new Brand();
				brand.setName(createBrandRequest.getName());
			this.brandRepository.save(brand);
}

	

}
