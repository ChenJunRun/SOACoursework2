package le.ac.uk.service.impl;

import le.ac.uk.entity.activity.activity;
import le.ac.uk.mapper.activityDAO;
import le.ac.uk.service.IActivityService;
import le.ac.uk.service.support.baseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class activityServiceImpl extends baseServiceImpl<activityDAO, activity>
    implements IActivityService
{

    @Override
    public List<activity> selectActivityByRegionAndType(String region, int activityType) {
        List<activity> activityList = baseMapper.getActivityByCityAndType(region, activityType);
        if (activityList == null || activityList.isEmpty()) {
            return null;
        }

        return activityList;
    }

}
