package net.gichain.genergy.eam.common;

public interface IResponseResult {
    Integer getCode();

    String getMessage();

    IResponseResult setMessage(String message);
}
