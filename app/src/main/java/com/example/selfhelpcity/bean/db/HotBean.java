package com.example.selfhelpcity.bean.db;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

@Data
@Entity
public class HotBean {

    /**
     * hash : QmedbYX7CotTGEpd79PxMEPfjnj75Z1frhpY66FKPkCcJw
     * coverHash : QmZEMmUU9pXKuedrsWSwdCTfGBmkpARX5R9rR9tAoA9hHh
     * size : 2581912220
     * rate : 3.5
     * estimate : 0.01
     * name : 2008.Iron.Man.2008.PROPER.1080p.BluRay.H264.AAC-RARBG
     */
    @Id
    private long id;
    /**
     * 钱包地址
     */
    String wallet;
    private String hash;
    private String coverHash;
    private long size;
    private double rate;
    private double estimate;
    private String name;

}
