package com.lil.fmmall.vo;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.annotation.Resource;


/**
 * @author Lil
 * @date 2022/01/06 15:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ResultVO对象",description = "封装返回给前端的对象")
public class ResultVO {

    @ApiModelProperty(dataType = "int",value = "相应状态码")
    private int code;

    @ApiModelProperty("响应提示信息")
    private String msg;

    @ApiModelProperty("相应数据")
    private Object data;


}