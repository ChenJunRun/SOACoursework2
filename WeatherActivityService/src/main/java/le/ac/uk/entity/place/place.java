package le.ac.uk.entity.place;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("place")
public class place {

    @TableId(type = IdType.INPUT)
    private String placeId;

    private String placeName;
    private String cityName;
    private double longitude;
    private double latitude;
}
