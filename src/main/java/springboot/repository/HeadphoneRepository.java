package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.Headphone;

public interface HeadphoneRepository extends JpaRepository<Headphone, Long>{

}
