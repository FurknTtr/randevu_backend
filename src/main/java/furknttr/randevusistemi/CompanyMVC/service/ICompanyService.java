package furknttr.randevusistemi.CompanyMVC.service;

import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.dto.response.MyCompaniesResDto;

public interface ICompanyService {

    void addCompany(AddCompanyReqDto addCompanyReqDto);

    MyCompaniesResDto myCompanies(String authHeader);
}
