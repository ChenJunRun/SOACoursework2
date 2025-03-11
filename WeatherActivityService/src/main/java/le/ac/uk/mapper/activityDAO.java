package le.ac.uk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import le.ac.uk.entity.activity.activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface activityDAO extends BaseMapper<activity> {

}
