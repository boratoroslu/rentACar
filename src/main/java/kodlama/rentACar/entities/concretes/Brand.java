package kodlama.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands")
@Data
@AllArgsConstructor
@NoArgsConstructor//NoargsConstractor da var parametresiz istiyorsak.!!
@Entity //Sen bit veri tabanı 
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik 1 1 artıyor.
	@Column(name="id")
	 private int id;
	
	@Column(name="name")
	 private String name;
 


}
