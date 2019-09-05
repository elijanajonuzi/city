package noseryoung.plj.city;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import noseryoung.plj.city.region.RegionService;

@Profile("test")
@Configuration
public class JUnitControllerTest {

	@Bean
	@Primary
	public RegionService regionService() {
		return Mockito.mock(RegionService.class);
	}
	
	
}
