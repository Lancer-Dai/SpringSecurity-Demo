package com.lancer.config;

import com.lancer.beans.RoleInfo;
import com.lancer.beans.UserInfo;
import com.lancer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {



    @Autowired
    UserService userService;



    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        System.out.println(username);
        UserInfo user = userService.getUserByAccount(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (RoleInfo role : user.getRoles()) {
            // 必须添加“ROLE_”开头，前台才能识别，识别时还是直接识别角色名即可
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            System.out.println(role.getName());
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(), authorities);
    }

}
