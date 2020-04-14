package com.ailbb.aws.mybatis.table;

import net.sf.json.JSONObject;

/**
 * Created by Wz on 2017/2/13.
 */
public class Ailbb {
    int id = 0;
    String user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString(){
        try {
            return JSONObject.fromObject(this).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
