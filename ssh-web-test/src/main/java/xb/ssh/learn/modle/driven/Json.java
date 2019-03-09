package xb.ssh.learn.modle.driven;

import java.io.Serializable;

public class Json implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success = false;
    private String message;
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
