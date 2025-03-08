package le.ac.uk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
//@TableName("bioid")
public class Bioid implements Serializable {
    private String code;

    private Integer used;

    private static final long serialVersionUID = 1L;
}
