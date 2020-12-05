package cn.kgc.smbms.service.impl;
import cn.kgc.smbms.dao.RoleMapper;
import cn.kgc.smbms.entity.Role;
import cn.kgc.smbms.service.RoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryAllRole(){
        return roleMapper.queryRoleList();
    }
}
