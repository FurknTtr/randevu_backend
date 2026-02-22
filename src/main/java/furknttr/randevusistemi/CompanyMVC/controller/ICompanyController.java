package furknttr.randevusistemi.CompanyMVC.controller;

import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;

public interface ICompanyController {

    void addCompany(AddCompanyReqDto addCompanyReqDto);

    void getMyCompanies();
}
