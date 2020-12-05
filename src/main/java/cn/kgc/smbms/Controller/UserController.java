package cn.kgc.smbms.Controller;

import cn.kgc.smbms.commons.ServerResponse;
import cn.kgc.smbms.entity.User;
import cn.kgc.smbms.service.RoleService;
import cn.kgc.smbms.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    //登录
    @RequestMapping("/gotologin")
    public String gotoLogin(){
        return "login";
    }
    @RequestMapping("/login.do")
    public String userLogin(String userCode,
                            String userPassword,
                            HttpServletRequest httpServletRequest,
                            Model model) {
        //调用业务逻辑层来判断用户名和密码
        ServerResponse serverResponse = userService.userLogin(userCode, userPassword);
        if (serverResponse.getSuccess()) {
            //登录成功
            httpServletRequest.getSession().setAttribute("userSession", serverResponse.getData());
            return "frame";
        } else {
            //登录失败
            model.addAttribute("error", serverResponse.getMsg());
            return "login";
        }
    }

    //退出
    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request){
        //在当前会话中删除相关的用户信息，表示用户登出
        request.getSession().removeAttribute("userSession");
        return "login";
    }

    //捕获错误
    @RequestMapping("/test")
    public void testE(){
        throw new RuntimeException("项目发生了预期之外的错误。。。");
    }
    @ExceptionHandler(RuntimeException.class)
    public String expectionCache(RuntimeException e , Model model){
        model.addAttribute("error",e.getMessage());
        return "error";
    }

    @Resource
    private RoleService roleService;

    //分页
    @RequestMapping("/userlist")
    public String gotoUserList(Model model,
                               @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                               @RequestParam(required = false) String queryname,
                               @RequestParam(required = false) Integer queryUserRole){
        System.out.println("前往用户信息列表页面");
        PageInfo pageInfo = userService.queryUserList(pageIndex,queryname,queryUserRole);
        model.addAttribute("roleList",roleService.queryAllRole());
        model.addAttribute("userList",pageInfo.getList());
        model.addAttribute("totalPageCount",pageInfo.getPages());
        model.addAttribute("totalCount",pageInfo.getTotal());
        model.addAttribute("currentPageNo",pageInfo.getPageNum());
        return "userlist";
    }
    @RequestMapping("/gotoadd")
    public String gotoadd(){
        return "useradd";
    }
    @RequestMapping("/ckusercode")
    @ResponseBody
    public String checkUserCode(String userCode){
        return userService.checkUserCode(userCode);
    }
    @RequestMapping("/adduser")
    public String adduser(User user){
        userService.addUser(user);
        return "redirect:/user/userlist";
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getUser(@PathVariable Integer id){
        return JSONObject.toJSONString(userService.queryUser(id));
    }
}
