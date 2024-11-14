package kodlama.rentACar.business.abstracts;

import java.util.List;

import kodlama.rentACar.business.requests.CreateModelRequest;
import kodlama.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {

	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	

}
