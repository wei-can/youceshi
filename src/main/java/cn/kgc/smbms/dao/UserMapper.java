package cn.kgc.smbms.dao;
import cn.kgc.smbms.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface UserMapper {
    /*
    * 根据用户名和密码查询用户是否存在
    * @param user
    * */
    Integer queryUserByUserCode(String userCode);
    User queryUserByUserCodeAndUserPassword(@Param("userCode") String userCode,
                                            @Param("userPassword") String userPassword);
    /*
    * todo 查询用户第一版，后面可能会改
    * */
    List<User> queryAllUser(@Param("userName") String userName , @Param("roleId") Integer roleId);
    /*添加用户信息*/
    Integer addUser(User user);
    User getUserById(Integer id);
}
