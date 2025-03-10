package le.ac.uk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@TableName("activity")
public class activity implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private UUID id;

    private String activityName;
    private activityType activityType;
    private String activityPrice;
    private String weatherConstraintId;

}
