package com.durex.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gelong
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "fans")
public class Fans {
    @Id
    private String id;

    /**
     * 作家用户id
     */
    @Column(name = "writer_id")
    private String writerId;

    /**
     * 粉丝用户id
     */
    @Column(name = "fan_id")
    private String fanId;

    /**
     * 粉丝头像
     */
    private String face;

    /**
     * 粉丝昵称
     */
    @Column(name = "fan_nickname")
    private String fanNickname;

    /**
     * 粉丝性别
     */
    private Integer sex;

    /**
     * 省份
     */
    private String province;
}