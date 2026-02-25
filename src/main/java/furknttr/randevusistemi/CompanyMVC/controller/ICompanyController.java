package furknttr.randevusistemi.CompanyMVC.controller;

import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.dto.response.MyCompaniesResDto;

public interface ICompanyController {

    void addCompany(AddCompanyReqDto addCompanyReqDto);

    MyCompaniesResDto myCompanies(String authHeader);
}
