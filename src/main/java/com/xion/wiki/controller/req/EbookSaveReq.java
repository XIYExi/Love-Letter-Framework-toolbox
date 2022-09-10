package com.xion.wiki.controller.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EbookSaveReq {

    @JsonSerialize(using= ToStringSerializer.class)
    @NotNull(message = "【非空校验】id还能为空的啊？")
    private Long id;

    @NotNull(message = "【非空校验】至少名字不能为空")
    private String name;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long category1Id;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long category2Id;

    private String description;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;
}
