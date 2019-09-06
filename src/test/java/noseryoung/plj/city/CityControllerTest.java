package noseryoung.plj.city;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import noseryoung.plj.city.region.City;
import noseryoung.plj.city.region.RegionController;
import noseryoung.plj.city.region.RegionService;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers ={RegionController.class}, secure = false) //(Controllers ={RegionController.class}, secure = false)
public class CityControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	@MockBean
	private RegionService service;
	
	@Test
	public void givenCities_whenGetCities_ThenReturnJsonArray() throws Exception{
		City milano = new City();
		milano.setName("zurich");
		
		List<City> allCities = Arrays.asList(milano);
		
		given(service.getAllCities()).willReturn(allCities);
		
		
		mvc.perform(get("/city/listCity")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name").value(milano.getName()));
		
	}
	
	

}
