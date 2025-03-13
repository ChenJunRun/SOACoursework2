package le.ac.uk.entity.activity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
//@TableName("activity")
public class activity implements Serializable {

    //    @TableId
    private int             activityID;

    //    private int             cityID;
    private String          activityName;
    private int             activityType;
    private int             activitySlots;
    private int             activityPrice;
    private String          postcode;
    private double          latitude;
    private double          longitude;
    private String          town;
    private String          region;
    private String          country;

}
