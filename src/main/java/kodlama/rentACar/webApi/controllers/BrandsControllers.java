package kodlama.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.rentACar.business.abstracts.BrandService;
import kodlama.rentACar.business.requests.CreateBrandRequest;
import kodlama.rentACar.business.responses.GetAllBrandsResponse;

@RestController //annatoation 
@RequestMapping("/api/brands")
public class BrandsControllers {

		private BrandService brandService;
         @Autowired
		public BrandsControllers(BrandService brandService) {
			
			this.brandService = brandService;
		}
		@GetMapping("/getall")
		public List<GetAllBrandsResponse> getAll(){
			return brandService.getAll();
		}
		
		@PostMapping("/add")
		public void add(CreateBrandRequest createBrandRequest) {
			((BrandService) this.brandService).add(createBrandRequest); 
			
		}
		
}

