package com.photon.mvppattern.models.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by balaji_sh on 6/3/2017.
 */
public class LoginResponse {
    @SerializedName("errorMessage")
    @Expose
    private Object errorMessage;
    @SerializedName("jsessionId")
    @Expose
    private String jsessionId;
    @SerializedName("lbSessionId")
    @Expose
    private Object lbSessionId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("registryNumbers")
    @Expose
    private List<String> registryNumbers = new ArrayList<>();

    /**
     * @return The errorMessage
     */
    public Object getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage The errorMessage
     */
    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return The jsessionId
     */
    public String getJsessionId() {
        return jsessionId;
    }

    /**
     * @param jsessionId The jsessionId
     */
    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
    }

    /**
     * @return The lbSessionId
     */
    public Object getLbSessionId() {
        return lbSessionId;
    }

    /**
     * @param lbSessionId The lbSessionId
     */
    public void setLbSessionId(Object lbSessionId) {
        this.lbSessionId = lbSessionId;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The registryNumbers
     */
    public List<String> getRegistryNumbers() {
        return registryNumbers;
    }

    /**
     * @param registryNumbers The registryNumbers
     */
    public void setRegistryNumbers(List<String> registryNumbers) {
        this.registryNumbers = registryNumbers;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "errorMessage=" + errorMessage +
                ", jsessionId='" + jsessionId + '\'' +
                ", lbSessionId=" + lbSessionId +
                ", name='" + name + '\'' +
                ", registryNumbers=" + registryNumbers +
                '}';
    }
}
