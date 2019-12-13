package com.fiuntl.myshop.plus.business.dto.dtoparams;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ji
 */
@Data
public class UpdatePmsProductListParam implements Serializable {

    private static final long serialVersionUID = -6337562023742122967L;

    private List<Long> ids;

    private Integer verifyStatus;

    private Integer publishStatus;

    private Integer recommendStatus;

    private Integer newStatus;

    private  Integer deleteStatus;



}
