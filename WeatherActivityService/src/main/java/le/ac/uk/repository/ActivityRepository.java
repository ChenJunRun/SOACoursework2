package le.ac.uk.repository;

import le.ac.uk.entity.activity.activity;
import le.ac.uk.model.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

    @Query("SELECT slots FROM Activity WHERE id = :id")
    List<Object[]> findById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Activity a SET a.slots = :newSlots WHERE a.id = :id")
    void updateSlots(@Param("id") int id, @Param("newSlots") int newSlots);

}
