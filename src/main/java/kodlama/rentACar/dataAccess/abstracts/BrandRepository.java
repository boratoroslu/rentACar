package kodlama.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand , Integer> {
	
	boolean existsByName(String name); //spring jpa keywords
		
}
