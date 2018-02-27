/**
 * 统一了action返回的接口
 */
package org.mrhu.smartlab.dispatcher;

import com.opensymphony.xwork2.ActionSupport;
import org.mrhu.smartlab.model.Status;

import java.util.Map;

public class ActionRequestDispatcher extends ActionSupport {
    private static final String USER = "user_success";
    private static final String ADMIN = "admin_success";
    private static final String NOLOGIN = "no_login";

    public static String dispatcher(Map<String, Object> session) {
        if(session.get("status") == Status.ADMINISTRATOR) {
            return ADMIN;
        } else if (session.get("status") == Status.USER){
            return USER;
        } else {
            return NOLOGIN;
        }
    }
}
