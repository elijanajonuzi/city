package noseryoung.plj.city.region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Repository Layer
 * 
 * @author Elijana
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	@Query(value="Select * from city where city.population>= ?1",nativeQuery=true)
	public List<City> selectCityWithPopulation(int population);
	
	
	@Query(value="select * from city where region_id=?1",nativeQuery=true)
	public List<City> selectCityWithRegion(long idToList);
	
	@Query(value="select * from city join region on region_id=id where region_id=?1",nativeQuery=true)
	public List<City> selectCityWithRegionID(long idToList);
	
	
	public City findByName(String name);
	
}
