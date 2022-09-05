package com.xion.wiki.controller.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EbookQueryReq extends PageReq{

    private Long id;

    private String name;

}

