package cn.liontalk.mongodb.result;

import lombok.Data;

@Data
public class Result<T> {


    private String message;

    private int code;

    private T data;


    private Result(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if (null == codeMsg) {
            return;
        }
        this.message = codeMsg.getMessage();
        this.code = codeMsg.getCode();
    }



    public static <T>  Result<T> success(T data){
       return new Result<T>(data);
    }


    public static <T> Result<T> error(CodeMsg codeMsg){
        if(null==codeMsg){
            return null;
        }
        return new Result<T> (codeMsg);
    }



}
