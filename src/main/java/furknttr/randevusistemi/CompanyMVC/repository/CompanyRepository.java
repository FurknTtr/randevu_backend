package furknttr.randevusistemi.CompanyMVC.repository;

import furknttr.randevusistemi.CompanyMVC.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByOwnerId(Long ownerId);

    Optional<Company> findByDistrictId(int districtId);

    Optional<Company> findByCityId(int cityId);
}
