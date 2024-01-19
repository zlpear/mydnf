package org.zwj.mydnf.vo;

import java.io.Serializable;

public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3236329195874147801L;
    /**
     * 错误码.
     */
    private String code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;

    private String result;

    private String next;

    private String errMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public ResultVO(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.msg = errorMessage;
    }

    public static ResultVO<Void> success() {
        return new ResultVO<>("0", "success", null);
    }

    public static <T> ResultVO<T> success(T body) {
        return new ResultVO<>("200", "success", body);
    }

    public static <T> ResultVO<T> failure(String errorCode, String errorMessage) {
        return new ResultVO<>(errorCode, errorMessage);
    }

    public ResultVO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        if(code.equals("0")){
            this.result="SUCCESS";
            this.next="NONE";
        }
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
