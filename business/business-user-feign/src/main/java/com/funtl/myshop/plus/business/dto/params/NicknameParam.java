package com.funtl.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改头像参数
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-26 23:44:42
 * @see com.funtl.myshop.plus.business.dto
 */
@Data
public class NicknameParam implements Serializable {


    /**
     * 用户昵称
     */
    private String nickname;

}
