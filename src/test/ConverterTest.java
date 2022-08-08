package test;

import code.Converter;
import code.Port;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
	Converter converter = new Converter();

	@Test
	void indexesToInt() {
		Port port = new Port();
		String[] indexes = new String[]{"1-5,7,9-11"};
		port.setIndexes(indexes);
		assertEquals(List.of(List.of(1, 2, 3, 4, 5, 7, 9, 10, 11)), converter.indexesToInt(port));
	}

	@Test
	void intIndexesPermutation() {
		Port port = new Port();
		String[] indexes = new String[]{"1,3-5", "2", "3-4"};
		port.setIndexes(indexes);
		assertEquals(List.of(
						List.of(1, 2, 3), List.of(1, 2, 4), List.of(3, 2, 3), List.of(3, 2, 4),
						List.of(4, 2, 3), List.of(4, 2, 4), List.of(5, 2, 3), List.of(5, 2, 4)),
				converter.intIndexesPermutation(port));
	}
}