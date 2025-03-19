package le.ac.uk.service.support;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class baseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
