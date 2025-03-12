package le.ac.uk.repository;
import le.ac.uk.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    @Query("SELECT region,country FROM City group by region,country")
    List<Object[]> getCityList();
}





