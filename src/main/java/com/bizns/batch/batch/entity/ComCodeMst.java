package com.bizns.batch.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "COM_CODE_MST")
@IdClass(ComCodeMstId.class)
@ToString
public class ComCodeMst implements Serializable {

    /**그룹코드*/
    @Id
    @Column(name = "GROUP_CODE")
    private String groupCode;

    /**코드*/
    @Id
    @Column(name = "CODE_CD")
    private String codeCd;

    /**코드명*/
    @Column(name = "CODE_NM")
    private String codeNm;

    /**설명*/
    @Column(name = "CODE_CONTENT")
    private String codeContent;

    /**정렬*/
    @Column(name = "CODE_SORT")
    private Integer codeSort;

    /**사용여부*/
    @Column(name = "USE_YN")
    private String useYn;

    /**등록자*/
    @Column(name = "CREATED_BY")
    private Integer createdBy;

    /**등록일시*/
    @Column(name = "CREATED")
    private LocalDateTime created;

    /**수정일시*/
    @Column(name = "UPDATED")
    private LocalDateTime updated;

    /**수정자*/
    @Column(name = "UPDATED_BY")
    private Integer updatedBy;
}
