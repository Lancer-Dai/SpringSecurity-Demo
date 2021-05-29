package com.lancer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 授权规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人都可以访问，功能只有有权限的人可以访问

        // 请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1").hasRole("v1")
                .antMatchers("/level2").hasRole("v2")
                .antMatchers("/level3").hasRole("v3");

        // 没有权限默认跳转登录页面
        //
        http.formLogin()
                // 定制登录页面
                .loginPage("/myLogin")
                // 登录认证的URL
                .loginProcessingUrl("/login")
                // 自定义上传表单时，参数key
                .usernameParameter("username")
                .passwordParameter("password");

        // 关闭防止网站攻击，不然logout会报错
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");

        // 开启注销功能，移除所有cookie
        http.logout().deleteCookies("remove").invalidateHttpSession(true);

        // 开启记住我功能，cookie实现，默认两周
        http.rememberMe()
                // 自定义表单参数
                .rememberMeParameter("remember");
    }

    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();//不对密码进行加密
    }
    /**
     * 重写方法，认证规则
     * 密码编码：PasswordEncoder
     * 在springSecurity中增加了很多加密方法
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存中添加用户,正常应该从数据库中读取
       /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lancer").password(new BCryptPasswordEncoder().encode("123456")).roles("v2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("v1","v2","v3");*/
        auth.userDetailsService(customUserService()); //user Details Service验证

    }
}
