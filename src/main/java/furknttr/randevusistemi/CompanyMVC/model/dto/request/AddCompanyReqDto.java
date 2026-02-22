package furknttr.randevusistemi.CompanyMVC.model.dto.request;

import lombok.Data;

@Data
public class AddCompanyReqDto {

    private Long ownerId;
    private String name;
    private String phone;
    private int cityId;
    private int districtId;
}
