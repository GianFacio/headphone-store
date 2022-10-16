package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import springboot.entity.Headphone;
import springboot.repository.HeadphoneRepository;

@SpringBootApplication
public class HeadphoneStore implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HeadphoneStore.class, args);
	}

	@Autowired
	private HeadphoneRepository headphoneRepository;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	
	@Override
	public void run(String... args) throws Exception 
	{
		//String sql = "INSERT INTO headphones (id, brand, model, color, year, price) VALUES (?, ?, ?, ?, ?)";
        
        //int result = jdbcTemplate.update(sql, "1","Beats", "Studio", "Red", "2023", "100");
         
        //if (result > 0) {
            //System.out.println("A new row has been inserted.");
        //}
	}

}
