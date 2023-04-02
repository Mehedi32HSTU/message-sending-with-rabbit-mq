package com.javabeans.email.sending.send_email;

import java.io.Serializable;
import java.util.Arrays;

public class MailBody implements Serializable {

	private static final long serialVersionUID = 631056738184132181L;
	private String[] sendTo;
	private String mailSubject;
	private String messageBody;
	private String attachmentUrl;
	private String[] sendCCTo;

	public MailBody() {

	}

	public MailBody(String[] sendTo, String[] sendCCTo, String mailSubject, String messageBody) {
		this.sendTo = sendTo;
		this.mailSubject = mailSubject;
		this.messageBody = messageBody;
		this.sendCCTo = sendCCTo;
	}

	public String[] getSendTo() {
		return sendTo;
	}

	public void setSendTo(String[] sendTo) {
		this.sendTo = sendTo;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public String[] getSendCCTo() {
		return sendCCTo;
	}

	public void setSendCCTo(String[] sendCCTo) {
		this.sendCCTo = sendCCTo;
	}

	@Override
	public String toString() {
		return "MailBody [sendTo=" + Arrays.toString(sendTo) + ", mailSubject=" + mailSubject + ", messageBody="
				+ messageBody + ", attachmentUrl=" + attachmentUrl + ", sendCCTo=" + Arrays.toString(sendCCTo) + "]";
	}

}
