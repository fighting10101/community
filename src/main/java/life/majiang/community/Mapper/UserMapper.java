package life.majiang.community.Mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT into user values (default,#{account_id},#{name},#{gmt_creat},#{gmt_modified},#{token})")
    public void addUser(User user);

    @Select("select * from user where token = #{token}")
    public User findToken(@Param("token") String token);
}
