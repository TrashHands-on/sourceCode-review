package SortPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * csvファイルを読み込んで、バブルソートを行い、<br>
 * 実行結果を作成したファイルに書き込む
 *
 * @author RyoTokuno
 * @version 1.0.0
 *
 */
public class ReSortPractice {

	/**
	 * バブルソートを行うために読み込むファイル
	 */
	private static final String FILE_INPUT = "C:/Users/owner/Desktop/java練習/石崎さん課題/refactoring/test01.csv";
	/**
	 * バブルソートの結果を書き込むファイル
	 */
	private static final String FILE_OUTPUT = "C:/Users/owner/Desktop/java練習/石崎さん課題/refactoring/TestOutput.csv";

	/**
	 * csvファイルを読み込み<br>
	 * バブルソートメソッドと書き込みメソッドを呼び出す。
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// 時間計測開始
		long start = System.currentTimeMillis();
		System.out.println("---START---");

		File fileIn = new File(FILE_INPUT);
		File fileOut = new File(FILE_OUTPUT);

		try (BufferedReader br = new BufferedReader(new FileReader(fileIn));) {

			if (fileOut.exists()) {
				fileOut.delete();
			}

			String line;
			String headerStr = "";
			Map<Integer, String> map = new HashMap<Integer, String>();
			headerStr = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				Integer valueNum = Integer.parseInt(data[0]);
				map.put(valueNum, line);

			}
			// 書き込みメソッドの呼び出し
			writeFile(headerStr, map);

		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("---END---");
		// 時間計測終了
		long end = System.currentTimeMillis();
		System.out.println("TIME:" + (end - start) + "ms");
	}

	/**
	 * 読み込んだcsvファイルをバブルソートする
	 *
	 * @param headerStr
	 *            読み込んだcsvファイルの先頭行が格納されている
	 * @param map
	 *            読み込んだcsvファイルの先頭行以外の中身が格納されている
	 *
	 * @throws IOException
	 */

	private static void writeFile(String headerStr, Map<Integer, String> map) throws IOException {

		Set<Integer> itemIdSet = map.keySet();
		Object[] mapKey = itemIdSet.toArray();
		Map<Integer, String> map2 = new HashMap<Integer, String>();

		// ソートメソッドの呼び出し
		sortFile(map, map2, mapKey);

		System.out.println(headerStr);
		for (int a = 0; a < map2.size(); a++) {
			System.out.println(map.get(mapKey[a]));
		}

		FileWriter fileWrite = new FileWriter(FILE_OUTPUT, false);
		PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWrite));

		printWriter.println(headerStr);

		for (int a = 0; a < map2.size(); a++) {
			// 取り出した一行をtestOutファイルへ書き込んで改行
			printWriter.println(map.get(mapKey[a]));
		}
		printWriter.println();

		// 書き込み終了
		printWriter.close();
		System.out.println("---CSV Output Done---");

	}

	/**
	 * バブルソートした結果を作成したcsvファイルに書き込む
	 *
	 * @param map 読み込んだcsvファイルの先頭行以外の中身が格納されている
	 * @param map2 読み込んだcsvファイルの先頭行を除いた中身がバブルソートされた結果を格納している
	 * @param mapKey mapに設定されたキーが配列形式で格納されている
	 */
	private static void sortFile(Map<Integer, String> map, Map<Integer, String> map2, Object[] mapKey) {

		for (int n = 0; n < mapKey.length; n++) {

			for (int m = mapKey.length - 1; m > n; m--) {

				if (Integer.parseInt(mapKey[m].toString()) < Integer.parseInt(mapKey[m - 1].toString())) {
					Object t = mapKey[m];
					mapKey[m] = mapKey[m - 1];
					mapKey[m - 1] = t;
				}
			}

			map2.put(Integer.parseInt(mapKey[n].toString()), map.get(mapKey[n]));
		}
	}

}