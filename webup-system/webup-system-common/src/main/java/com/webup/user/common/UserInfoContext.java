package com.webup.user.common;


import com.webup.user.bms.pojo.BmsUser;

public class UserInfoContext {
    private static ThreadLocal<BmsUser> userInfo = new ThreadLocal<BmsUser>();
    public static String KEY_USERINFO_IN_HTTP_HEADER = "WL_APP_USERINFO";

    public UserInfoContext() {
    }

    public static BmsUser getUser(){
        return (BmsUser)userInfo.get();
    }

    public static void setUser(BmsUser user){
        userInfo.set(user);
    }
}