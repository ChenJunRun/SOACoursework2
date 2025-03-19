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
    private int             id;

    //    private int             cityID;
    private String          name;
    private int             type;
    private int             slots;
    private int             price;
    private String          postcode;
    private double          latitude;
    private double          longitude;
    private String          town;
    private String          region;
    private String          country;

}
