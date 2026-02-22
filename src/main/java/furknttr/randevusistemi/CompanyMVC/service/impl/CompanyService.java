package furknttr.randevusistemi.CompanyMVC.service.impl;

import furknttr.randevusistemi.CompanyMVC.mapper.CompanyMapper;
import furknttr.randevusistemi.CompanyMVC.model.dto.request.AddCompanyReqDto;
import furknttr.randevusistemi.CompanyMVC.model.entity.Company;
import furknttr.randevusistemi.CompanyMVC.repository.CompanyRepository;
import furknttr.randevusistemi.CompanyMVC.service.ICompanyService;
import furknttr.randevusistemi.Contracts.CompanyEvents.CompanyCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void addCompany(AddCompanyReqDto addCompanyReqDto) {
        System.out.println("Serviceteyim");
        Company company = companyMapper.addCompanyReqDtoToCompany(addCompanyReqDto);
        companyRepository.save(company);
        System.out.println(new CompanyCreatedEvent(company.getOwnerId()));
        eventPublisher.publishEvent(new CompanyCreatedEvent(company.getOwnerId()));
    }
}
