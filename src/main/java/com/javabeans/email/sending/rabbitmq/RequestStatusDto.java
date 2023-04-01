package com.javabeans.email.sending.rabbitmq;

public class RequestStatusDto {

	private RequestDto requestDto;
	private String status;
	private String message;

	public RequestStatusDto() {

	}

	public RequestDto getRequestDto() {
		return requestDto;
	}

	public void setRequestDto(RequestDto requestDto) {
		this.requestDto = requestDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
