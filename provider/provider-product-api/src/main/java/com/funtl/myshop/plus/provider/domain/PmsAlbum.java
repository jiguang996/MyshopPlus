package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "pms_album")
public class PmsAlbum implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "cover_pic")
    private String coverPic;

    @Column(name = "pic_count")
    private Integer picCount;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "description")
    private String description;

    private static final long serialVersionUID = 1L;
}