package com.bawei.weektwomn.data.bean;

/**
 * @author Alex
 * @date 2019/2/18.
 * GitHub：https://github.com/wangshuaialex
 */
public class Root {
    private Result result;

    private String message;

    private String status;

    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
