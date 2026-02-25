package furknttr.randevusistemi.CompanyMVC.mapper;

import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.dto.response.MyCompaniesResDto;
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
        company.setCityName(dto.getCityName());
        company.setDistrictId(dto.getDistrictId());
        company.setDistrictName(dto.getDistrictName());
        return company;
    }

    public MyCompaniesResDto toMyCompanies(Company company){
        MyCompaniesResDto myCompanies = new MyCompaniesResDto();
        myCompanies.setCompanyId(company.getId());
        myCompanies.setCityId(company.getCityId());
        myCompanies.setCityName(company.getCityName());
        myCompanies.setDistrictId(company.getDistrictId());
        myCompanies.setDistrictName(company.getDistrictName());
        return myCompanies;
    }

}
