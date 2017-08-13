/*
 * @(#) StringUtils.java
 *
 * v1.0.0 / 2017. 8. 6. 
 *
 * Copyright ((c) 2017 by HST, Inc. All Rights Reserved.
 */
package com.hst.pofoland.common.utils;

import java.util.UUID;

/**
 * 
 * 시스템명 : 
 * $com.hst.pofoland.common.utils.StringUtils.java
 * 클래스 설명 : 
 *
 * @author 이현규
 * @since 2017. 8. 6.
 * @version 1.0.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일          수정자         수정내용
 * -------------------------------------------------
 * 2017. 8. 6.   이현규  최초생성
 * </pre>
 */
public class StringUtils {

    /**
     * @return
     */
    public static String random() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
}
