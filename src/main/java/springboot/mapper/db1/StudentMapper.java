package springboot.mapper.db1;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import springboot.dao.db1.Student;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tjj
 * @since 2020-03-06
 */
@DS(value = "master")
public interface StudentMapper extends BaseMapper<Student> {

}
