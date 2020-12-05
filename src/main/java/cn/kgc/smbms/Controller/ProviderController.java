package cn.kgc.smbms.Controller;

import cn.kgc.smbms.commons.Constants;
import cn.kgc.smbms.commons.PageSupport;
import cn.kgc.smbms.entity.Provider;
import cn.kgc.smbms.service.ProviderService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Resource
    private ProviderService providerService;

}
