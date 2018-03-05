package v2ch01.streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * 
 * 作 者：adms 时 间: 2018年2月28日 下午5:56:50 说 明: List创建流 ：list.stream(); Array创建流
 * ：Stream.of(array)或者Arrays.stream(array); Array截取流 ： Arrays.stream(array, 0,
 * 5);
 * 
 * // 1.使用值构建 Stream<String> stream = Stream.of("a", "b", "c"); // 2. 使用数组构建
 * String[] strArray = new String[] {"a", "b", "c"}; Stream<String> stream =
 * Stream.of(strArray); Stream<String> stream = Arrays.stream(strArray); // 3.
 * 利用集合构建(不支持Map集合) List<String> list = Arrays.asList(strArray); stream =
 * list.stream(); 修改时间： 修改说明：
 *
 *
 */
public class CreatingStreams {

	// <T>泛型方法，表示传入参数有泛型
	public static <T> void show(String title, Stream<T> stream) {
		final int SIZE = 10;
		List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
		System.out.print(title + ": ");
		for (int i = 0; i < firstElements.size(); i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			if (i < SIZE) {
				System.out.print(firstElements.get(i));
			} else
				System.out.print("...");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// 获取文件路径path
		Path path = Paths.get("src/java8/gutenberg/alice30.txt");
		// 读取文件字符串
		String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

		// 按词组分割文件后转成流，值构建，Stream.of
		Stream<String> words = Stream.of(contents.split("\\PL+"));
		// Stream<String> _words = Arrays.asList(contents.split("\\PL+")).stream();
		show("按词组分割文件后转成流word", words);

		// 字符拼接流，值构建，Stream.of
		Stream<String> song = Stream.of("gently", "down", "the", "stream");
		show("song", song);

		// 数组构建，Arrays.stream(array)
		String[] array = { "a", "b", "c", "d", "e", "f", "g" };
		Stream<String> str_array = Arrays.stream(array);// Arrays.stream(array, 0, 5);
		show("str_array", str_array);

		// 数字流,创建数字list,并通过流统计元素个数，利用集合构建(不支持Map集合),list.stream()
		List<Integer> list_int = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		Stream<Integer> ints = list_int.stream();
		show("Integer", ints);

		// 不包含任何元素的流
		Stream<String> silence = Stream.empty();
		show("silence", silence);

		// Stream.generate创建无限流
		Stream<String> echos = Stream.generate(() -> "Echo");
		show("echos", echos);

		// 无线随机数流
		Stream<Double> randoms = Stream.generate(Math::random);
		show("randoms", randoms);

		// 整数流
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
		show("integers", integers);

		// 词组分割流
		Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
		show("wordsAnotherWay", wordsAnotherWay);

		// 文件流
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			show("lines", lines);
		}

		String s = "abc";
		if (s != null && s.length() != 0) {
			System.out.println("hhhhhhhhhhhhhhh");
		}
		if (!s.equals("")&& !s.equals(null)) {
			System.out.println("gggggggggggggggg");
		}
	}
}
