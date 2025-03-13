package le.ac.uk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import le.ac.uk.entity.activity.activity;
import le.ac.uk.entity.activity.activityType;

import java.util.List;

public interface IActivityService extends IService<activity> {
    List<activity> selectActivityByRegionAndType(String region, int activityType);
}
