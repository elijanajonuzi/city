package noseryoung.plj.city;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import noseryoung.plj.city.region.City;
import noseryoung.plj.city.region.CityRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CityApplicationTests {
	 
	   @Autowired
	    private TestEntityManager entityManager;
	   
	   @Autowired 
	   private CityRepository cityRepository;
	   
	   @Test
	   public void whenFindByName_thenReturnCity() {
		   //given
		  
		   City newYork = new City("New York", 324545);
		   entityManager.persist(newYork);
		   entityManager.flush();
		   
		   //when
		   City gound = cityRepository.findByName(newYork.getName());
		   
		   //then
		   assertEquals(newYork.getName(),gound.getName());
		   
		   
		   
		   
				  
		   
		   
		   
	   }
    	
    	
    	

}
