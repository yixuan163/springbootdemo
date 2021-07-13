package com.huawei.progress.biz.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yixuan
 * @since 2021-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("my_test")
@ApiModel(value="MyTest对象", description="")
public class MyTestModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField("date")
    private LocalDate date;


}
