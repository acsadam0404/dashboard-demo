package com.vaadin.demo.dashboard;

import javax.servlet.ServletException;

import com.vaadin.server.VaadinServlet;

public class DashboardServlet extends VaadinServlet {

	@Override
	protected final void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(new DashboardSessionInitListener());
	}
}