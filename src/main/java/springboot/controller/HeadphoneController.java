package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import springboot.entity.Headphone;
import springboot.service.HeadphoneService;

@Controller
public class HeadphoneController {
	
	private HeadphoneService headphoneService;

	public HeadphoneController(HeadphoneService headphoneService) {
		super();
		this.headphoneService = headphoneService;
	}
	
	@GetMapping("/headphonestore")
	public String listHeadphoneStore(Model model) {
		model.addAttribute("headphones", headphoneService.getAllHeadphones());
		return "headphone_store";
	}
	
	@GetMapping("/login")
	public String listHeadphoneStoreLogin(Model model) {
		model.addAttribute("headphones", headphoneService.getAllHeadphones());
		return "login";
	}
	
	// handler method to handle list headphones and return mode and view
	@GetMapping("/headphones")
	public String listHeadphones(Model model) 
	{
		model.addAttribute("headphones", headphoneService.getAllHeadphones());
		return "headphones";
	}
	
	@GetMapping("/headphones/new")
	public String createHeadphoneForm(Model model) 
	{
		
		// create headphone object to hold form data
		Headphone headphone = new Headphone();
		model.addAttribute("headphone", headphone);
		return "create_headphone";
	}
	
	@PostMapping("/headphones")
	public String saveHeadphone(@ModelAttribute("headphone") Headphone headphone) {
		headphoneService.saveHeadphone(headphone);
		return "redirect:/headphones";
	}
	
	@GetMapping("/headphones/edit/{id}")
	public String editHeadphoneForm(@PathVariable Long id, Model model) {
		model.addAttribute("headphone", headphoneService.getHeadphoneById(id));
		return "edit_headphone";
	}

	@PostMapping("/headphones/{id}")
	public String updateHeadphones(@PathVariable Long id,
			@ModelAttribute("headphone") Headphone headphone,
			Model model) {
		
		// Get headphone from database by id
		Headphone existingHeadphone = headphoneService.getHeadphoneById(id);
		existingHeadphone.setId(id);
		existingHeadphone.setBrand(headphone.getBrand());
		existingHeadphone.setModel(headphone.getModel());
		existingHeadphone.setColor(headphone.getColor());
		existingHeadphone.setYear(headphone.getYear());
		existingHeadphone.setPrice(headphone.getPrice());
		
		// save updated headphone object
		headphoneService.updateHeadphone(existingHeadphone);
		return "redirect:/headphones";		
	}
	
	// Handler method to handle delete headphone request
	
	@GetMapping("/headphones/{id}")
	public String deleteHeadphone(@PathVariable Long id) {
		headphoneService.deleteHeadphoneById(id);
		return "redirect:/headphones";
	}
	
}
