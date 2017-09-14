package com.zen.autumn.learn;


import java.io.Serializable;

/**
 * 公共参数类.
 * 
 * @author chenhao
 *
 */
public class CommonParameter implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //登录用户ucid
    private Long ucid;

    /**
     * @return the ucid
     */
    public Long getUcid() {
        return ucid;
    }

    /**
     * @param ucid the ucid to set
     */
    public void setUcid(Long ucid) {
        this.ucid = ucid;
    }
}
