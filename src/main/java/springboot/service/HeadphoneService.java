package springboot.service;

import java.util.List;

import springboot.entity.Headphone;

public interface HeadphoneService {
	List<Headphone> getAllHeadphones();
	
	Headphone saveHeadphone(Headphone headphone);
	
	Headphone getHeadphoneById(Long id);
	
	Headphone updateHeadphone(Headphone headphone);
	
	void deleteHeadphoneById(Long id);
}
