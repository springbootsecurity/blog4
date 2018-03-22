package cn.lxl.controller;

import java.util.HashMap;
import java.util.Map;

public class FilterChainDefinitionsMap {

    public static Map getMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("/hello","anon");
        map.put("/login","anon");
        map.put("/static/**","anon");
        map.put("/doLogin","anon");
        map.put("/logout","logout");
        map.put("/admin","roles[admin]");
        map.put("/user","roles[user],authc");
        map.put("/index","user");
        map.put("/**","authc");
        return map;

    }
}
