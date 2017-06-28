package com.hrpj.core.exception;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.core.exception
 * 2. 타입명 : BusinessLogicException.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:05:12
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   : BusinessLogicException
 * </pre>
 */
@SuppressWarnings("serial")
public class BusinessLogicException extends Exception
{
    public BusinessLogicException(){
    }
    
    public BusinessLogicException(String msg){
        super(msg);
    }
}
