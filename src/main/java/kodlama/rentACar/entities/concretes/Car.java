package kodlama.rentACar.entities.concretes;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik 1 1 artıyor.
	@Column(name="id")
	@jakarta.persistence.Id
	 private int id;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="state")
	private int state;   //1-available 2- rented 3- mainteance vb
	
		@ManyToOne
		@JoinColumn(name="model_id")
		private Model model;
	
}
