package com.javabeans.email.sending.rabbitmq;

public class RequestDto {
	private Long requestId;
	private String[] sendTo;
	private String subject;
	private String messageBody;
	private String[] sendToCC;

	public RequestDto() {

	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String[] getSendTo() {
		return sendTo;
	}

	public void setSendTo(String[] sendTo) {
		this.sendTo = sendTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String[] getSendToCC() {
		return sendToCC;
	}

	public void setSendToCC(String[] sendToCC) {
		this.sendToCC = sendToCC;
	}

	@Override
	public String toString() {
		return "RequestDto [requestId=" + requestId + ", sendTo=" + sendTo + ", subject=" + subject + ", messageBody="
				+ messageBody + ", sendToCC=" + sendToCC + "]";
	}

}
