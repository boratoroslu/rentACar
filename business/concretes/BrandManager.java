package kodlama.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.sql.results.graph.collection.internal.CollectionDomainResult;
import org.springframework.stereotype.Service;

import kodlama.rentACar.business.abstracts.BrandService;
import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.requests.UpdateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service //bu sınıf bir business nesnesidir demek.
@AllArgsConstructor
public class BrandManager implements BrandService{
   private BrandRepository brandRepository; 
   private ModelMapperService modelMapperService;

@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları
	
	List<Brand> brands = brandRepository.findAll();
		
	List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand->this.modelMapperService.forResponse()
			.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
	
		return brandsResponses;
	}

@Override
public void add(CreateBrandRequest createBrandRequest) {
			Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); 
	                this.brandRepository.save(brand);		
}   

@Override
public GetByIdBrandResponse getById(int id) {
	Brand brand =  this.brandRepository.findById(id).orElseThrow();
	GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
	return getByIdBrandResponse;
	
	
}

@Override
public void update(UpdateBrandRequest updateBrandRequest) {
	Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class); 
    this.brandRepository.save(brand);
	
}

@Override
public void delete(int id) {
	this.brandRepository.deleteById(id);
	
}

@Override
public void add(UpdateBrandRequest updateBrandRequest) {
	// TODO Auto-generated method stub
	
}

	

}
