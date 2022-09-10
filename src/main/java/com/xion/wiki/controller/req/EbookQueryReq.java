package com.xion.wiki.controller.req;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EbookQueryReq extends PageReq{

    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private String name;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long categoryId2;

}

