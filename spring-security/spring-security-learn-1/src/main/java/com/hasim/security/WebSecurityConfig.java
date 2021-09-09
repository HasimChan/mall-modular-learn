package com.hasim.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description
 * @Author Hasim
 * @Date 2021/9/9 10:39
 * @Version 1.0
 */
@Configuration // security 配置类
@EnableWebSecurity // 开启 Security 服务
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启全局 Security 注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    /**
     * AuthenticationManagerBuilder: AuthenticationManager 的建造器，用于登录认证
     * 使用此功能需要配置 UserDetailService 和 PasswordEncoder
     * UserDetailService 用于在认证器中根据用户传过来的用户名查找一个用户
     * PasswordEncoder 用于密码的加密与比对
     * 存储用户密码的时候用PasswordEncoder.encode() 加密存储
     * 在认证器里会调用 PasswordEncoder.matches() 方法进行密码比对
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString(); // 明文加密
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString()); // 明文比对
            }
        });
    }

    /**
     * 配置登录相关操作
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
//                .antMatchers().permitAll()
                .anyRequest()
                .authenticated()
                .and()

                .formLogin() // 设置登录页
                .loginPage("/login") // 登录页请求路径
                .usernameParameter("username") // 用户属性名
                .passwordParameter("password") // 密码属性名
                .defaultSuccessUrl("/") // 登陆成功页
                .permitAll() // 任意用户可访问
                // 自定义登陆用户名和密码参数，默认为username和password

                .and()
                .logout().permitAll();

        // 关闭CSRF跨域
        http.csrf().disable();
    }

    /**
     * 配置静态资源处理方式，可使用 Ant 匹配规则
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
