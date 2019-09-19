package com.jenga.leo.util.session;

import javax.servlet.http.HttpSession;

public interface SessionAction {

public abstract boolean equalsToSomething(final HttpSession session, final String compareKey);

}
