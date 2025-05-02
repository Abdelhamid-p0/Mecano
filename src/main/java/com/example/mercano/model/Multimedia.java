package com.example.mercano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MULTIMEDIA_OBJ_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_seq")
    @SequenceGenerator(name = "media_seq", sequenceName = "media_seq", allocationSize = 1)
    @Column(name = "ID_MEDIA")
    private Long idMedia;

    @Column(name = "TYPE", length = 20)
    private String type;

    @Column(name = "FILE_NAME", length = 40)
    private String fileName;

    @Column(name = "FILE_PATH", length = 120)
    private String filePath;

    @Lob
    @Column(name = "FILE_DATA")
    private byte[] fileData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_REF")
    private Product product;
}