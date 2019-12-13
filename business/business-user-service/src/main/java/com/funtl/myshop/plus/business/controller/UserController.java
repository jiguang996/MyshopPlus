package com.funtl.myshop.plus.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.funtl.myshop.plus.business.controller.fallback.UserControllerFallback;
import com.funtl.myshop.plus.business.dto.UmsAdminDTO;
import com.funtl.myshop.plus.business.dto.params.IconParam;
import com.funtl.myshop.plus.business.dto.params.KeywordParam;
import com.funtl.myshop.plus.business.dto.params.PasswordParam;
import com.funtl.myshop.plus.business.dto.params.ProfileParam;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.UmsAdminService;
import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-30 22:34:41
 * @see com.funtl.myshop.plus.business.controller
 */
@RestController
@RequestMapping(value = "admin")
public class UserController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "info/{username}")
    @SentinelResource(value = "info", fallback = "infoFallback", fallbackClass = UserControllerFallback.class)
    public ResponseResult<UmsAdminDTO> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.getByUsername(username);
        UmsAdminDTO dto = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdmin, dto);
        return new ResponseResult<UmsAdminDTO>(ResponseResult.CodeStatus.OK, "获取个人信息", dto);
    }

    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
        UmsAdmin newUmsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(profileParam, newUmsAdmin);
        int result = umsAdminService.update(newUmsAdmin);

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "更新个人信息成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "更新个人信息失败");
        }
    }

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "modify/password")
    public ResponseResult<Void> modifyPassword(@RequestBody PasswordParam passwordParam) {
        UmsAdmin umsAdmin = umsAdminService.getByUsername(passwordParam.getUsername());

        // 旧密码正确
        if (passwordEncoder.matches(passwordParam.getOldPassword(), umsAdmin.getPassword())) {
            int result = umsAdminService.modifyPassword(umsAdmin.getUsername(), passwordParam.getNewPassword());
            if (result > 0) {
                return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "修改密码成功");
            }
        }

        // 旧密码错误
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "旧密码不匹配，请重试");
        }

        return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "修改密码失败");
    }

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "modify/icon")
    public ResponseResult<Void> modifyIcon(@RequestBody IconParam iconParam) {
        int result = umsAdminService.modifyIcon(iconParam.getUsername(), iconParam.getPath());

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "更新头像成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "更新头像失败");
        }
    }

    /**
     * 显示所有用户
     *
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "userlist")
    public ResponseResult<List<UmsAdminDTO>>  findAll(){
        List<UmsAdmin> allUsers = umsAdminService.getAllUsers();
        List<UmsAdminDTO> umsAdminList=new ArrayList<>();
        for (UmsAdmin umsAdmin : allUsers) {
            UmsAdminDTO dto = new UmsAdminDTO();
            BeanUtils.copyProperties(umsAdmin, dto);
            umsAdminList.add(dto);
        }
        return new ResponseResult<List<UmsAdminDTO>>(ResponseResult.CodeStatus.OK, "查询所有用户",umsAdminList);
    }

    /**
     * 搜索用户
     *
     * @param keyword {@link KeywordParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "search")
    public ResponseResult<List<UmsAdminDTO>>  searchUser(@RequestBody KeywordParam keyword){
        List<UmsAdminDTO> umsAdminList=new ArrayList<>();
        UmsAdmin umsAdminByEmail = umsAdminService.getByEmail(keyword.getKeyword());
        UmsAdmin umsAdminByOpenId = umsAdminService.getByOpenId(keyword.getKeyword());
        UmsAdmin umsAdminByNickname = umsAdminService.getByNickname(keyword.getKeyword());

        if (umsAdminByEmail != null) {
            UmsAdminDTO dto = new UmsAdminDTO();
            BeanUtils.copyProperties(umsAdminByEmail, dto);
            umsAdminList.add(dto);
        }
        if (umsAdminByNickname != null){
            UmsAdminDTO dto = new UmsAdminDTO();
            BeanUtils.copyProperties(umsAdminByNickname, dto);
            umsAdminList.add(dto);
        }
        if (umsAdminByOpenId !=null){
            UmsAdminDTO dto = new UmsAdminDTO();
            BeanUtils.copyProperties(umsAdminByOpenId, dto);
            umsAdminList.add(dto);
        }
        return new ResponseResult<List<UmsAdminDTO>>(ResponseResult.CodeStatus.OK, "搜索成功",umsAdminList);
    }

    /**
     * 删除用户
     * @param profileParam
     * @return
     */
    @PostMapping(value = "delete/user")
    public  ResponseResult<Void> deleteUser(@RequestBody ProfileParam profileParam){
        int result = umsAdminService.deleteUser(profileParam.getUsername());

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "删除成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "删除失败");
        }
    }
}
