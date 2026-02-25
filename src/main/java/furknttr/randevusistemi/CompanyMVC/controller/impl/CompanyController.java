package furknttr.randevusistemi.CompanyMVC.controller.impl;

import furknttr.randevusistemi.CompanyMVC.controller.ICompanyController;
import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.dto.response.MyCompaniesResDto;
import furknttr.randevusistemi.CompanyMVC.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/myCompanies")
    public MyCompaniesResDto myCompanies(@RequestHeader("Authorization") String authHeader) {
        return companyService.myCompanies(authHeader);
    }
}
