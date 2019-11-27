package com.jiguang.myshopplus.business.controller;


import com.google.common.collect.Maps;
import com.jiguang.myshopplus.business.dto.LoginInfo;
import com.jiguang.myshopplus.business.dto.LoginParam;
import com.jiguang.myshopplus.business.feign.ProfileFeign;
import com.jiguang.myshopplus.commons.utils.MapperUtils;
import com.jiguang.myshopplus.commons.utils.OkHttpClientUtil;
import com.jiguang.myshopplus.commons.dto.ResponseResult;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @Author ji
 * @Date 2019/11/25 21:16
 * @Version 1.0
 */
@RestController
public class LoginController {
    private  static  final String URL_AUTH2_URl="http://localhost:9001/oauth/token";
    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService  userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private TokenStore tokenStore;

    @Resource
    private ProfileFeign profileFeign;

    @PostMapping(value = "user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParam loginParam){
        //封装返回结果
        Map<String,Object> result=Maps.newHashMap();

        //验证账号密码
        UserDetails userDetails=userDetailsService.loadUserByUsername(loginParam.getUsername());
        if(userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())){



            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.FAIL,"账号或密码错误",null);
        }

        //通过http客户端请求登录接口
        Map<String,String> map= Maps.newHashMap();
        map.put("username", loginParam.getUsername());
        map.put("password", loginParam.getPassword());
        map.put("grant_type", oauth2GrantType);
        map.put("client_id", oauth2ClientId);
        map.put("client_secret", oauth2ClientSecret);

        try {
            //解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_AUTH2_URl, map);
            String jsonString= Objects.requireNonNull(response.body()).string();
            Map<String,Object> jsonMap= MapperUtils.json2map(jsonString);
            String token= String.valueOf(jsonMap.get("access_token"));
            result.put("token",token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"登录成功",result);
    }

    /**
     * 获取用户信息
     *
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() throws Exception {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取个人信息
        String jsonString = profileFeign.info(authentication.getName());
        UmsAdmin umsAdmin = MapperUtils.json2pojoByTree(jsonString, "data", UmsAdmin.class);
        // 封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(umsAdmin.getUsername());
        loginInfo.setAvatar(umsAdmin.getIcon());
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }


    @PostMapping(value = "/user/logout")
    public  ResponseResult<Void> logout(HttpServletRequest request){
        String token=request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"获取注销",null);
    }
}
