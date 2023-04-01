package com.javabeans.email.sending.rabbitmq;

public class RequestDto {
	private Long requestId;
	private String requestName;
	private String requestDescription;
	private String requestRemarks;

	public RequestDto() {

	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public String getRequestRemarks() {
		return requestRemarks;
	}

	public void setRequestRemarks(String requestRemarks) {
		this.requestRemarks = requestRemarks;
	}

	@Override
	public String toString() {
		return "RequestDto [requestId=" + requestId + ", requestName=" + requestName + ", requestDescription="
				+ requestDescription + ", requestRemarks=" + requestRemarks + "]";
	}
}
