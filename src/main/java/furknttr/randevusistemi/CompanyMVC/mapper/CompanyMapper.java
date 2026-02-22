package furknttr.randevusistemi.CompanyMVC.mapper;

import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company addCompanyReqDtoToCompany(AddCompanyReqDto dto){
        Company company = new Company();

        company.setOwnerId(dto.getOwnerId());
        company.setName(dto.getName());
        company.setPhone(dto.getPhone());
        company.setCityId(dto.getCityId());
        company.setDistrictId(dto.getDistrictId());
        System.out.println("Mapperdayım");
        return company;
    }

}
