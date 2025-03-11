package le.ac.uk.entity.activity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

public class weatherConstraints implements Serializable {

    private double minTemperature;
    private double maxTemperature;
    private double minPrecipitations;
    private double maxPrecipitations;
    private double minWindSpeed;
    private double maxWindSpeed;
}
