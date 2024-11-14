package kodlama.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.rentACar.business.abstracts.ModelService;
import kodlama.rentACar.business.requests.CreateModelRequest;
import kodlama.rentACar.business.responses.GetAllModelsResponse;
import kodlama.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelrepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		  
		List<Model> models = modelrepository.findAll();
		
		List<GetAllModelsResponse> modelsResponses = models.stream().map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
			return modelsResponses;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); 
        this.modelrepository.save(model);	
		
	}
	

}
