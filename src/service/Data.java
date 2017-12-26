/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("async")
@Expose
private String async;
@SerializedName("error")
@Expose
private Integer error;
@SerializedName("message")
@Expose
private String message;
@SerializedName("request_id")
@Expose
private String requestId;

public String getAsync() {
return async;
}

public void setAsync(String async) {
this.async = async;
}

public Integer getError() {
return error;
}

public void setError(Integer error) {
this.error = error;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getRequestId() {
return requestId;
}

public void setRequestId(String requestId) {
this.requestId = requestId;
}

}