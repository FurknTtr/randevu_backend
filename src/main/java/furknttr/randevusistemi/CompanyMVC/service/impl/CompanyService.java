package furknttr.randevusistemi.CompanyMVC.service.impl;

import furknttr.randevusistemi.CompanyMVC.mapper.CompanyMapper;
import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.dto.response.MyCompaniesResDto;
import furknttr.randevusistemi.CompanyMVC.model.entity.Company;
import furknttr.randevusistemi.CompanyMVC.repository.CompanyRepository;
import furknttr.randevusistemi.CompanyMVC.service.ICompanyService;
import furknttr.randevusistemi.Contracts.CompanyEvents.CompanyCreatedEvent;
import furknttr.randevusistemi.Exception.GeneralException;
import furknttr.randevusistemi.JWT.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {

    private final JwtService jwtService;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void addCompany(AddCompanyReqDto addCompanyReqDto) {
        Company company = companyMapper.addCompanyReqDtoToCompany(addCompanyReqDto);
        companyRepository.save(company);
        System.out.println(new CompanyCreatedEvent(company.getOwnerId()));
        eventPublisher.publishEvent(new CompanyCreatedEvent(company.getOwnerId()));
    }

    @Override
    public MyCompaniesResDto myCompanies(String authHeader) {
        String token = authHeader.substring(7);
        String strOwnerId = jwtService.extractMemberId(authHeader);
        Long ownerId = Long.parseLong(strOwnerId);
        //Buradan devam edeceksin unutma,
        Company company = companyRepository.findByOwnerId(ownerId)
                .orElseThrow(()->new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı"));

        return companyMapper.toMyCompanies(company);
    }
}
