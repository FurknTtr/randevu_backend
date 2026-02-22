package furknttr.randevusistemi.CompanyMVC.controller.impl;

import furknttr.randevusistemi.CompanyMVC.controller.ICompanyController;
import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController implements ICompanyController {

    private final ICompanyService companyService;

    @Override
    @PostMapping("/myCompanies")
    public void addCompany(@RequestBody AddCompanyReqDto addCompanyReqDto){
        System.out.println("Controllerdayım");
        companyService.addCompany(addCompanyReqDto);
    }

    @Override
    public void getMyCompanies() {

    }
}
