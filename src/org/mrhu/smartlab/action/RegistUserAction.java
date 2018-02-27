package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.RequestAware;
import org.mrhu.smartlab.dto.RegistUserDto;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Component
@Scope("prototype")
public class RegistUserAction extends ActionSupport implements RequestAware, ModelDriven<RegistUserDto>{

    private Map<String, Object> request;
    private RegistUserDto registUserDto = new RegistUserDto();
    private UserService userService;
    private User user = new User();

    public String registUser() {
        user.setUsername(registUserDto.getUsername());

        if(registUserDto.getPassword().length() <= 5) {
            request.put("result", "密码长度不合格(6位及以上)");
            return ERROR;
        } else if(userService.exist(user)) {
            request.put("result", "用户名已存在");
            return ERROR;
        } else if(!registUserDto.getPassword().equals(registUserDto.getRepPassword())) {
            request.put("result", "两次输入密码不相同");
            return ERROR;
        } else {
            userService.save(registUserDto.getUser());
            request.put("result", "注册成功");
            return SUCCESS;
        }
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public RegistUserDto getModel() {
        return registUserDto;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public RegistUserDto getRegistUserDto() {
        return registUserDto;
    }

    public void setRegistUserDto(RegistUserDto registUserDto) {
        this.registUserDto = registUserDto;
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
