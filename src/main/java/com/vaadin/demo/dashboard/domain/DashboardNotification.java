package com.vaadin.demo.dashboard.domain;

public final class DashboardNotification {
	private long id;
	private String content;
	private boolean read;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(final boolean read) {
		this.read = read;
	}

}
