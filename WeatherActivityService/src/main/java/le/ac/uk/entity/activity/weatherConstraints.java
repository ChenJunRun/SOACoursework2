package le.ac.uk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("weatherConstraints")
public class weatherConstraints implements Serializable {

    @TableId(type = IdType.INPUT)
    private String id;

    private double minTemperature;
    private double maxTemperature;
    private double minPrecipitations;
    private double maxPrecipitations;
    private double minWindSpeed;
    private double maxWindSpeed;
}
