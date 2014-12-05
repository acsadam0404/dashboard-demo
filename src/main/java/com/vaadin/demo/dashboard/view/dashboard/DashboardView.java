package com.vaadin.demo.dashboard.view.dashboard;

import com.vaadin.demo.dashboard.event.DashboardEvent.CloseOpenWindowsEvent;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public final class DashboardView extends Panel implements View {

	private final VerticalLayout root;

	public DashboardView() {
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		DashboardEventBus.register(this);

		root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.addStyleName("dashboard-view");
		setContent(root);
		Responsive.makeResponsive(root);

		root.addComponent(buildHeader());

		Component content = buildContent();
		root.addComponent(content);
		root.setExpandRatio(content, 1);

		// All the open sub-windows should be closed whenever the root layout gets clicked.
		// XXX kell ez?
		root.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(final LayoutClickEvent event) {
				DashboardEventBus.post(new CloseOpenWindowsEvent());
			}
		});
	}

	private Component buildHeader() {
		HorizontalLayout header = new HorizontalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);

		Label titleLabel = new Label("Dashboard");
		titleLabel.setSizeUndefined();
		titleLabel.addStyleName(ValoTheme.LABEL_H1);
		titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		header.addComponent(titleLabel);

		HorizontalLayout tools = new HorizontalLayout(new NotificationsButton());
		tools.setSpacing(true);
		tools.addStyleName("toolbar");
		header.addComponent(tools);

		return header;
	}

	private Component buildContent() {
		DashboardLayout dbl = new DashboardLayout();

		dbl.addComponent(new TextField());

		return dbl;
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
