package le.ac.uk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import le.ac.uk.entity.activity.activity;
import le.ac.uk.entity.activity.activityType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface activityDAO extends BaseMapper<activity> {
    List<activity> getActivityByCityAndType(@Param("region") String region, @Param("activityType") int activityType);
}
