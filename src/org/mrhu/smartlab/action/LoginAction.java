package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.mrhu.smartlab.dto.UserLoginDto;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<UserLoginDto>{

    private static final String ADMIN = "admin_success";
    private static final String USER = "user_success";
    private static final String PASSWORD_ERROR = "password_error";
    private static final String DO_NOT_EXIST = "do_not_exist";

    private UserLoginDto userLoginDto = new UserLoginDto();
    private UserService userService;
    private String loginStatus;
    private String name;


    /**
     * 判断指定用户名是否存在，
     *  存在---判断是否密码正确
     *      密码正确---判断用户身份
     *          用户身份判定完成---结束
     *      密码错误---返回PASSWORD_ERROR
     *  不存在---返回DO_NOT_EXIST
     * @return 用户身份或者状态情况，同时设定登陆状态loginStatus;
     */
    public String login() {
        User user = userLoginDto.getUser();
        if (userService.get(user.getUsername()) != null) {
            User loadUser = userService.get(user.getUsername());
            if(loadUser.getPassword().equals(user.getPassword()) &&
                    loadUser.getUsername().equals(user.getUsername()) &&
                    loadUser.getStatus().equals(Status.USER)) {
                name = loadUser.getName();
                return USER;

            } else if(loadUser.getPassword().equals(user.getPassword()) &&
                    loadUser.getUsername().equals(user.getUsername()) &&
                    loadUser.getStatus().equals(Status.ADMINISTRATOR)) {
                name = loadUser.getName();
                return ADMIN;
            } else if ( !loadUser.getPassword().equals(user.getPassword())){
                loginStatus="密码错误";
                return PASSWORD_ERROR;
            }
        }
        loginStatus="用户不存在";
        return DO_NOT_EXIST;
    }

    public UserLoginDto getUserLoginDto() {
        return userLoginDto;
    }

    public void setUserLoginDto(UserLoginDto userLoginDto) {
        this.userLoginDto = userLoginDto;
    }

    @Override
    public UserLoginDto getModel() {
        return userLoginDto;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
