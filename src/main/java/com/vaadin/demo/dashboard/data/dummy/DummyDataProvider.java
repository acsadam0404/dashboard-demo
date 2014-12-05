package com.vaadin.demo.dashboard.data.dummy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vaadin.demo.dashboard.data.DataProvider;
import com.vaadin.demo.dashboard.domain.DashboardNotification;
import com.vaadin.demo.dashboard.domain.User;

/**
 * A dummy implementation for the backend API.
 */
public class DummyDataProvider implements DataProvider {

    private final Collection<DashboardNotification> notifications = randomNotifications();
    static Collection<DashboardNotification> randomNotifications() {
		DashboardNotification n1 = new DashboardNotification();
		n1.setContent("lorem ipsum");

		DashboardNotification n2 = new DashboardNotification();
		n2.setContent("lorem ipsum");

		return Arrays.asList(n1, n2);
	}



    @Override
    public User authenticate(String userName, String password) {
        User user = new User();
        user.setFirstName("lorem");
        user.setLastName("ipsum");
        user.setRole("admin");
        return user;
    }

    @Override
    public int getUnreadNotificationsCount() {
        Predicate<DashboardNotification> unreadPredicate = new Predicate<DashboardNotification>() {
            @Override
            public boolean apply(DashboardNotification input) {
                return !input.isRead();
            }
        };
        return Collections2.filter(notifications, unreadPredicate).size();
    }

    @Override
    public Collection<DashboardNotification> getNotifications() {
        for (DashboardNotification notification : notifications) {
            notification.setRead(true);
        }
        return Collections.unmodifiableCollection(notifications);
    }


}
