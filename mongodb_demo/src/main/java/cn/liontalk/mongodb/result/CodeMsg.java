package cn.liontalk.mongodb.result;


import lombok.Data;

@Data
public class CodeMsg {


    private int code;

    private String message;

    public CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 调用成功
     */
    public static CodeMsg SUCCESS = new CodeMsg(200, "操作成功");




}
