package com.guo.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dell on 2020/3/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private  Long id;
    private String serial;
}
