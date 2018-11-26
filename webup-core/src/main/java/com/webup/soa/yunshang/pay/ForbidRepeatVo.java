package com.webup.soa.yunshang.pay;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@Data
public class ForbidRepeatVo implements Serializable {
    private String param;
    private String code;
    private long time;
    private Integer no = 1;

}
