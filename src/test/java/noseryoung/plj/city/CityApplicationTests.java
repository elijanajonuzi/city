package noseryoung.plj.city;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noseryoung.plj.city.region.RegionController;
import noseryoung.plj.city.region.RegionService;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CityApplicationTests {
	
	@Test
	public void testRegionController() {
		RegionService regionservice=new RegionService();
		RegionController regionController = new RegionController(regionservice);
	
		ResponseEntity<String> itis= regionController.getCityName(1);
		assertEquals(itis, "london");
	}
	
	

}
