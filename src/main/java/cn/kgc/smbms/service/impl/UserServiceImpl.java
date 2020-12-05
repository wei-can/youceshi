package cn.kgc.smbms.service.impl;
import cn.kgc.smbms.commons.ServerResponse;
import cn.kgc.smbms.dao.UserMapper;
import cn.kgc.smbms.entity.User;
import cn.kgc.smbms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    public UserMapper userMapper;
    @Override
    public ServerResponse userLogin(String userCode , String userPassword){
        if (userCode == null || userPassword == null){
            return ServerResponse.createResultByMsg("参数丢失",false);
        }
        Integer integer = userMapper.queryUserByUserCode(userCode);
        if (integer == 0){
            return  ServerResponse.createResultByMsg("用户名不正确",false);
        }
        User user = userMapper.queryUserByUserCodeAndUserPassword(userCode,userPassword);
        if (user == null){
            return ServerResponse.createResultByMsg("密码不正确",false);
        }
        //todo 登录成功
        return ServerResponse.createResultByData("登录成功",user,true);
    }
    @Override
    /*查询用户信息列表*/
    public PageInfo queryUserList(Integer pageIndex , String userName,Integer roleId){
        /*开始分页*/
        PageHelper.startPage(pageIndex,5);
        List<User> users = userMapper.queryAllUser(userName,roleId);
        PageInfo pageInfo = new PageInfo(users);
        List<User> resultUserList = new ArrayList<>();
        for (User user :users){
            User newUser = new User();
            //将前面对象原封不动的复制到后面的对象中
            BeanUtils.copyProperties(user,newUser);
            resultUserList.add(newUser);
        }
        pageInfo.setList(resultUserList);
        System.out.println("======================");
        System.out.println(pageInfo);
        System.out.println("======================");
        return pageInfo;
    }
    @Override
    public String checkUserCode(String userCode){
        if (StringUtils.isBlank(userCode)){
            return "error";
        }
        if (userMapper.queryUserByUserCode(userCode) == 0){
            return "notexists";
        }
        return "exist";
    }
    @Override
    public void addUser(User user){
        userMapper.addUser(user);
    }
    @Override
    public User queryUser(Integer id){
        return userMapper.getUserById(id);
    }
}
