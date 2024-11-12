package kodlama.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.rentACar.business.abstracts.BrandService;
import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.requests.UpdateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController //annatoation 
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsControllers {

		private BrandService brandService;
       
		@GetMapping()
		public List<GetAllBrandsResponse> getAll(){
			return brandService.getAll();
		}
		
		@GetMapping("/{id}")
		public GetByIdBrandResponse getById(@PathVariable int id) {
			return brandService.getById(id);
			
		}
		
		@PostMapping() 
		@ResponseStatus(code=HttpStatus.CREATED)
		public void add(CreateBrandRequest createBrandRequest) {
			((BrandService) this.brandService).add(createBrandRequest); 
		}
		@PutMapping
		public void update(UpdateBrandRequest updateBrandRequest) {
			this.brandService.update(updateBrandRequest);
		}
		@DeleteMapping("{id}")
		public void delete(@PathVariable int id) {
			this.brandService.delete(id);
		}
		
		
	 	
		
}

