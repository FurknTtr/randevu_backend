package furknttr.randevusistemi.Location.service;


import furknttr.randevusistemi.Location.model.dto.response.CityResDto;
import furknttr.randevusistemi.Location.model.dto.response.DistrictResDto;

import java.util.List;

public interface ILocationService {

    List<CityResDto> getAllCities();

    List<DistrictResDto> getDistrictsByCityId(int id);
}
