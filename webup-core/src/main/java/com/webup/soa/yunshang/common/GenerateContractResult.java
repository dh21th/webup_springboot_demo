package com.webup.soa.yunshang.common;

/**
 * @author Xiaobei
 * @create 2017-09-04 10:53
 */
public class GenerateContractResult {

    private String rootPath;//项目根路径

    private String sourceFilePath;//源文件路径

    private String targetFilePath;//目标文件路径

    private Boolean writeFlag;//是否写入成功

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public String getTargetFilePath() {
        return targetFilePath;
    }

    public void setTargetFilePath(String targetFilePath) {
        this.targetFilePath = targetFilePath;
    }

    public Boolean getWriteFlag() {
        return writeFlag;
    }

    public void setWriteFlag(Boolean writeFlag) {
        this.writeFlag = writeFlag;
    }
}
