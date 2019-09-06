package noseryoung.plj.city;





import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import noseryoung.plj.city.region.City;
import noseryoung.plj.city.region.CityRepository;
import noseryoung.plj.city.region.RegionService;

@RunWith(SpringRunner.class)
public class CityServiceTest {
	

	@InjectMocks
	private RegionService regionservice;
	@Mock
	private CityRepository cityRepository;

	
	@Before
	public void setUp() {
		City mockCity=new City();
		
		mockCity.setName("milano");
		Mockito.when(cityRepository.findByName(mockCity.getName())).thenReturn(mockCity);	
	}
	
	@Test
	public void whenValidName_thenCitySchouldBeFound() {
	String name= "milano";
		 City city = regionservice.getCityName(name);
		 assertThat(city.getName()).isEqualTo(name);
	}
	

}
