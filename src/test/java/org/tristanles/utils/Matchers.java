package org.tristanles.utils;

import java.util.List;

import org.fest.assertions.core.Condition;
import org.tristanles.Subscriber;

public class Matchers {
	public static Condition<List<Subscriber>> aListWithOneBuyer(
			final String buyerName) {

		return new Condition<List<Subscriber>>() {

			@Override
			public boolean matches(List<Subscriber> subscribers) {
				if (subscribers == null || subscribers.size() != 1) {
					return false;
				}
				Subscriber subscriber = subscribers.get(0);
				return subscriber != null
						&& buyerName.equals(subscriber.getName());

			}

		};
	}
}
