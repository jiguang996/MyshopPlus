package com.funtl.myshop.plus.business.utils;

import com.funtl.myshop.plus.business.dto.UmsAdminDTO;
import com.funtl.myshop.plus.business.dto.UmsAdminDetails;
import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-12 22:41
 * @Version 1.0
 **/
public class UserUtils {
    public static UmsAdmin getCurrentUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            UmsAdminDetails umsAdminDetails = (UmsAdminDetails) auth.getPrincipal();
            return umsAdminDetails.getUmsAdmin();
        }catch (Exception e){
            return new UmsAdmin();
        }
    }
}
