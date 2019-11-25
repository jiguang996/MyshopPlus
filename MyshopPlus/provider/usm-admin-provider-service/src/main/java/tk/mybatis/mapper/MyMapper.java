package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author ji
 * @Date 2019/11/24 20:10
 * @Version 1.0
 */
public interface MyMapper<T> extends Mapper<T> , MySqlMapper<T> {
}
