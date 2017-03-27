package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/8.
 */
public class WxFileDto {
    private byte[] fileStream;
    private String fileName;

    public WxFileDto(byte[] stream, String name){
        this.fileName = name;
        this.fileStream = stream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileStream() {
        return fileStream;
    }

    public void setFileStream(byte[] fileStream) {
        this.fileStream = fileStream;
    }
}
