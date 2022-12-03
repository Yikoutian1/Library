package com.controller.request;

import lombok.Data;

/**
 * @ClassName BaseRequest
 * @Description TODO 固有属性
 * @Author QiuLiHang
 * @DATE 2022/12/3 21:47
 * @Version 1.0
 */
@Data
public class BaseRequest {
    /**
     * 为了避免出现500错误,我们默认1-10
     */
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
