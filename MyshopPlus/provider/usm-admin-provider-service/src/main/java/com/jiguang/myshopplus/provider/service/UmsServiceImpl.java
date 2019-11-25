package com.jiguang.myshopplus.provider.service;

import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import com.jiguang.myshopplus.provider.mapper.UmsAdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理服务。
 * @Author ji
 * @Date 2019/11/25 11:26
 * @Version 1.0
 */
@Service(version = "1.0.0"  )
public class UmsServiceImpl  implements UmsAdminService {
    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public int insert(UmsAdmin umsAdmin) {
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin get(String username) {
        Example example=new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    /**
     * 初始化用户对象
     * @param umsAdmin {@link  UmsAdmin}
     */
    private  void  initUmsAdmin(UmsAdmin umsAdmin){
        //初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        //初始化状态
        if(umsAdmin.getStatus()==null){
            umsAdmin.setStatus(0);
        }
        //密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));

    }
}
