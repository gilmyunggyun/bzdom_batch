package com.bizns.batch.batch;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Line implements Serializable {

    private String name;
    private LocalDate dob;
    private Long age;

    // standard constructor, getters, setters and toString implementation

}
