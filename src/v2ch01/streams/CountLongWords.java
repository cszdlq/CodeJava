package v2ch01.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * 作 者：liaojun 时 间: 2018年2月28日 上午10:06:06 
 * 说 明: NIO 通过流处理长单词计数
 * parallelStream其实就是一个并行执行的流.它通过默认的ForkJoinPool,可能提高你的多线程任务的速度.
 * parallelStream具有平行处理能力，处理的过程会分而治之，也就是将一个大任务切分成多个小任务，这表示每个任务都是一个操作 修改时间： 修改说明：
 *
 *
 */

public class CountLongWords {

	public static void main(String[] args) throws IOException {

		// 获取path文件路径,相对项目路径
		Path path = Paths.get("src/java8/gutenberg/alice30.txt");
		System.out.println("绝对路径地址，字符串拼接的相对路径，不管存不存在:" + path.toAbsolutePath());
		System.out.println("真实路径地址，不存在会报错:" + path.toRealPath());
		
		// 获取全部文本内容
		String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		// 将文本内容分割成词组
		List<String> words = Arrays.asList(contents.split("\\PL+"));

		long count = 0;// 计数器
		int length = 12;// 词组长度

		// 方法一 迭代
		for (String w : words) {
			if (w.length() > length) {
				count++;
			}
		}
		System.out.println("通过迭代统计长单词个数:" + count);

		// 方法二 流,过滤词组长度大于12
		count = words.stream().filter(w -> w.length() > length).count();
		System.out.println("通过流统计长单词个数:" + count);

		// 方法二 平行流，过滤词组长度大于12
		count = words.parallelStream().filter(w -> w.length() > length).count();
		System.out.println("通过流库统计长单词个数:" + count);
		
	}
	
}