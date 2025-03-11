package le.ac.uk.entity.activity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@TableName("activity")
public class activity implements Serializable {

    @TableId
    private int             activityID;

    private int             cityID;
    private String          activityName;
    private activityType    activityType;
    private int             activitySlots;
    private int             activityPrice;

}
