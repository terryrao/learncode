package com.example.fluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raowei
 * @date 2019-04-09
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Quote {
    private String id;
    private String book;
    private String context;


}
