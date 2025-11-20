package com.city3d.utils;

public class Res {
    private boolean success;
    private Object data;
    private String code;
    private String msg;

    public static Res success() {
        Res res = new Res(true);
        return res;
    }

    public static Res success(Object data) {
        Res res = new Res(true, data);
        return res;
    }

    public static Res fail(String code, String msg) {
        Res res = new Res(false, code, msg);
        return res;
    }

    public Res() {
    }

    public Res(boolean success) {
        this.success = success;
    }

    public Res(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Res(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Res{" +
                "success=" + success +
                ", data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

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
}
