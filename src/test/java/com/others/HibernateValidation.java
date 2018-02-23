package com.others;

import com.domain.DTO.CardDTO;
import com.util.DateUtils;
import com.util.ValidationResult;
import com.util.ValidationUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:15 2018/2/9
 */
public class HibernateValidation {
    @Test
    public void test_1() throws ParseException {
        CardDTO cardDTO=new CardDTO();
        cardDTO.setDate(DateUtils.parse("2018-12-12 12:12:12"));
        cardDTO.setId("1111111111");
        cardDTO.setName("hahahahahaha");
        cardDTO.setPrice(BigDecimal.TEN);
        cardDTO.setValid(false);
//        ValidationResult validationResult = ValidationUtils.validateEntity(cardDTO);
        ValidationResult validationResult = ValidationUtils.validateProperty(cardDTO,"valid");
        System.out.println(validationResult);
        System.out.println(validationResult.isHasErrors()?validationResult.getErrorMsg():"");
    }
}
