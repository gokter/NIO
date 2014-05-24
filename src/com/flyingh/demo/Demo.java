package com.flyingh.demo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

import org.junit.Test;

public class Demo {
	private static String[] strings = { "A random string value", "The product of an infinite number of monkeys", "Hey hey we're the Monkees",
			"Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", "Help Me!  Help Me!", };

	@Test
	public void test3() {
		System.out.println(ByteBuffer.allocate(100).asIntBuffer().capacity());
		ByteBuffer buffer = ByteBuffer.allocate(5).order(ByteOrder.LITTLE_ENDIAN).put(0, (byte) 0).put(1, (byte) 'H').put(2, (byte) 0)
				.put(3, (byte) 'i').put(4, (byte) '!');
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		System.out.println(buffer);
		CharBuffer charBuffer = buffer.asCharBuffer();
		System.out.println(charBuffer);
	}

	@Test
	public void test2() {
		char[] array = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' };
		CharBuffer buffer = CharBuffer.wrap(array, 4, 5);
		System.out.println(array.length);
		System.out.println(buffer.array());
		System.out.println(buffer.capacity());
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.hasArray());
		System.out.println(buffer.remaining());
		System.out.println(buffer.arrayOffset());
		buffer.position(3).limit(6).mark().position(5);
		System.out.println(buffer.array());
		CharBuffer duplicateCharBuffer = buffer.duplicate();
		System.out.println(duplicateCharBuffer.position());
		System.out.println(duplicateCharBuffer.limit());
		System.out.println(duplicateCharBuffer.reset().position());
		System.out.println("************");
		CharBuffer sliceCharBuffer = buffer.slice();
		System.out.println(sliceCharBuffer.position());
		System.out.println(sliceCharBuffer.limit());
		System.out.println(sliceCharBuffer.remaining());
		System.out.println(sliceCharBuffer.capacity());
		System.out.println(buffer.order());
		System.out.println(duplicateCharBuffer.order());
		System.out.println(sliceCharBuffer.order());
		System.out.println(ByteOrder.nativeOrder());
		System.out.println(ByteBuffer.allocate(5).order());
	}

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
