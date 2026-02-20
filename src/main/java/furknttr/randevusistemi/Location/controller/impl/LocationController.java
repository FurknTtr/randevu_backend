package furknttr.randevusistemi.Location.controller.impl;

import furknttr.randevusistemi.Location.controller.ILocationController;
import furknttr.randevusistemi.Location.model.dto.response.CityResDto;
import furknttr.randevusistemi.Location.model.dto.response.DistrictResDto;
import furknttr.randevusistemi.Location.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController implements ILocationController {

    private final ILocationService locationService;


    @Override
    @GetMapping("/cities")
    public List<CityResDto> getAllCities() {
        return locationService.getAllCities();
    }

    @Override
    @GetMapping("/districts")
    public List<DistrictResDto> getDistrictsByCityId(@RequestParam int id) {
        return locationService.getDistrictsByCityId(id);
    }
}
