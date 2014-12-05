package com.vaadin.demo.dashboard.data;

import java.util.Collection;

import com.vaadin.demo.dashboard.domain.DashboardNotification;
import com.vaadin.demo.dashboard.domain.User;

/**
 * QuickTickets Dashboard backend API.
 */
public interface DataProvider {

    /**
     * @param userName
     * @param password
     * @return Authenticated used.
     */
    User authenticate(String userName, String password);

    /**
     * @return The number of unread notifications for the current user.
     */
    int getUnreadNotificationsCount();

    /**
     * @return Notifications for the current user.
     */
    Collection<DashboardNotification> getNotifications();
}
