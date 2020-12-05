package cn.kgc.smbms.service;
import cn.kgc.smbms.commons.ServerResponse;
import cn.kgc.smbms.entity.User;
import com.github.pagehelper.PageInfo;
public interface UserService {
    public ServerResponse userLogin(String userCode , String userPassword);
    public PageInfo queryUserList(Integer pageIndex,String userName,Integer roleId);
    public String checkUserCode(String userCode);
    public void addUser(User user );
    public User queryUser(Integer id);
}
