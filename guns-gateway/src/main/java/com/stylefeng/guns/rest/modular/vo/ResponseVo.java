package com.stylefeng.guns.rest.modular.vo;

/**
 * 返回对象
 */
public class ResponseVo<T> {
    //返回状态
    private int status;
    //返回信息
    private String msg;
    //返回数据实体
    private T data;

    private ResponseVo(){

    }
    public static <T> ResponseVo success(T t){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(t);
        return responseVo;
    }

    public static <T> ResponseVo serviceFail(String msg){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(1);
        responseVo.setData(msg);
        return responseVo;
    }

    public static <T> ResponseVo sysFail(String msg){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(999);
        responseVo.setData(msg);
        return responseVo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
