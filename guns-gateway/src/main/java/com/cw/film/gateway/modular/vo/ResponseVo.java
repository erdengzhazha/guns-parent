package com.cw.film.gateway.modular.vo;

/**
 * 返回对象
 */
public class ResponseVo<T> {
  //返回状态码
  private int status;
  //出错的返回信息
  private String msg;
  //返回数据实体
  private T data;

  private ResponseVo() {

  }

  /**
   * 成功
   * @param data
   * @param <T>
   * @return
   */
  public static <T> ResponseVo success(T data) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.setStatus(0);
    responseVo.setData(data);
    return responseVo;
  }

  /**
   * 失败
   * @param msg
   * @param <T>
   * @return
   */
  public static <T> ResponseVo serviceFail(String msg) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.setStatus(1);
    responseVo.setMsg(msg);
    return responseVo;
  }

  /**
   * 业务出错
   * @param msg
   * @param <T>
   * @return
   */
  public static <T> ResponseVo sysFail(String msg) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.setStatus(999);
    responseVo.setMsg(msg);
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
