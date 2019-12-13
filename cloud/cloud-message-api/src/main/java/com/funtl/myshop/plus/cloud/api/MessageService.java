package com.funtl.myshop.plus.cloud.api;

import com.funtl.myshop.plus.cloud.dto.PmsProductOperateLogDTO;
import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;

public interface MessageService {

    boolean sendAdminLoginLog(UmsAdminLoginLogDTO umsAdminLoginLogDTO);
    boolean sendProductOperateLog(PmsProductOperateLogDTO pmsProductOperateLogDTO);


}
