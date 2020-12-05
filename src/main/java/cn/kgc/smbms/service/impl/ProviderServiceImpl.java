package cn.kgc.smbms.service.impl;

import cn.kgc.smbms.dao.ProviderMapper;
import cn.kgc.smbms.dao.UserMapper;
import cn.kgc.smbms.entity.Provider;
import cn.kgc.smbms.entity.User;
import cn.kgc.smbms.service.ProviderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Resource
    public ProviderMapper providerMapper;

}
