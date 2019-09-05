package noseryoung.plj.city.region.dto;




import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import noseryoung.plj.city.region.City;




@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface CityMapper {
City fromDTO(CityDTO userDto);
	
	CityDTO toDTO(City city);

	List<City> fromDTOs(List<CityDTO> userDTOs);
	
	List<CityDTO> toDTOs(List<City> users);
	
	Set<City> fromDTOs(Set<CityDTO> userDTOs);
	
	Set<CityDTO> toDTOs(Set<City> users);
	

}
