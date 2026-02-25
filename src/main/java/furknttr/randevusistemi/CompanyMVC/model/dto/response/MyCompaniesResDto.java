package furknttr.randevusistemi.CompanyMVC.model.dto.response;

import lombok.Data;

@Data
public class MyCompaniesResDto {
    private Long companyId;
    private int districtId;
    private String districtName;
    private int cityId;
    private String cityName;
}
