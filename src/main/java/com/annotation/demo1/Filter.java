package com.annotation.demo1;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:15 2018/2/2
 */
@Table("ltj_table")
@Data
public class Filter {
    @Column("ltj_id")
    private Integer id;
    @Column("ltj_name")
    private String name;
}
