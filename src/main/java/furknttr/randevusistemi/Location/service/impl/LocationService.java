package furknttr.randevusistemi.Location.service.impl;

import furknttr.randevusistemi.Location.model.dto.response.CityResDto;
import furknttr.randevusistemi.Location.model.dto.response.DistrictResDto;
import furknttr.randevusistemi.Location.model.entity.City;
import furknttr.randevusistemi.Location.model.entity.District;
import furknttr.randevusistemi.Location.repository.CityRepository;
import furknttr.randevusistemi.Location.repository.DistrictRepository;
import furknttr.randevusistemi.Location.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService implements ILocationService {

    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;

    @Override
    public List<CityResDto> getAllCities() {
        List<City> getFromDB = cityRepository.findAll();

        List<CityResDto> dtoList = new ArrayList<>();

        for (City city : getFromDB){
            CityResDto cityDto = new CityResDto(city.getId(), city.getName());
            dtoList.add(cityDto);
        }
        return dtoList;
    }

    @Override
    public List<DistrictResDto> getDistrictsByCityId(int id) {

        List<District> getFromDB = districtRepository.findByCityId(id);
        List<DistrictResDto> dtoList = new ArrayList<>();

        for (District district : getFromDB){
            DistrictResDto districtDto = new DistrictResDto(district.getId(), district.getName());
            dtoList.add(districtDto);
        }
        return dtoList;
    }
}
