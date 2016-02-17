package org.carlos.server.jetty;

import org.eclipse.jetty.util.ConcurrentHashSet;

public class Test {
	public static void main(String[] args) {
		ConcurrentHashSet<Integer> c = new ConcurrentHashSet<>();
		c.add(1);
		c.add(2);
		for (Number str : c.<Number> toArray(new Number[] {})) {
			System.out.println(str);
		}
	}
}
