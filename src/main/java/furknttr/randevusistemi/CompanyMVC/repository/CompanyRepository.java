package furknttr.randevusistemi.CompanyMVC.repository;

import furknttr.randevusistemi.CompanyMVC.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
