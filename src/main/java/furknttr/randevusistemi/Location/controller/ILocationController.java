package furknttr.randevusistemi.Location.controller;

import furknttr.randevusistemi.Location.model.dto.response.CityResDto;
import furknttr.randevusistemi.Location.model.dto.response.DistrictResDto;

import java.util.List;

public interface ILocationController {

    List<CityResDto> getAllCities();

    List<DistrictResDto> getDistrictsByCityId(int id);
}
