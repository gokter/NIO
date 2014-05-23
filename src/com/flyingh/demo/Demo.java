package com.flyingh.demo;

import java.nio.CharBuffer;

import org.junit.Test;

public class Demo {
	private static String[] strings = { "A random string value", "The product of an infinite number of monkeys", "Hey hey we're the Monkees",
			"Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", "Help Me!  Help Me!", };

	@Test
	public void test() {
		CharBuffer buffer = CharBuffer.allocate(100);
		for (String string : strings) {
			fill(buffer, string);
			buffer.flip();
			drain(buffer);
			buffer.clear();
			System.out.println();
		}
	}

	private void drain(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
	}

	private void fill(CharBuffer buffer, String string) {
		for (char c : string.toCharArray()) {
			buffer.put(c);
		}
	}
}
