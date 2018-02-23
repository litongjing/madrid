package com.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:05 2018/2/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    @NotBlank(message = "id 不能为空或者空串")
    @Length(min = 2, max = 8, message = "2到8位")
    private String id;
    @NotBlank(message = "不能为空")
    private String name;

    private BigDecimal price;

    @AssertTrue(message = "字段必须为真")
    private Boolean valid;

    @Past(message = "时间不能晚于当前时间")
    private Date date;
}
