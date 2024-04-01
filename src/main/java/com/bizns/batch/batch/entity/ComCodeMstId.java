package com.bizns.batch.batch.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComCodeMstId implements Serializable {
    private String groupCode;
    private String codeCd;

}
