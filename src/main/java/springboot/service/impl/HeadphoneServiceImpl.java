package springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.entity.Headphone;
import springboot.repository.HeadphoneRepository;
import springboot.service.HeadphoneService;

@Service
public class HeadphoneServiceImpl implements HeadphoneService
{

	private HeadphoneRepository headphoneRepository;
	
	public HeadphoneServiceImpl(HeadphoneRepository headphoneRepository) {
		super();
		this.headphoneRepository = headphoneRepository;
	}

	@Override
	public List<Headphone> getAllHeadphones() {
		return headphoneRepository.findAll();
	}

	@Override
	public Headphone saveHeadphone(Headphone headphone) {
		return headphoneRepository.save(headphone);
	}

	@Override
	public Headphone getHeadphoneById(Long id) {
		return headphoneRepository.findById(id).get();
	}

	@Override
	public Headphone updateHeadphone(Headphone headphone) {
		return headphoneRepository.save(headphone);
	}

	@Override
	public void deleteHeadphoneById(Long id) {
		headphoneRepository.deleteById(id);	
	}

}
