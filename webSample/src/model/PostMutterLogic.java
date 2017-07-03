package model;

import java.util.List;

//つぶやきの投稿に関する処理を行うModelクラス
public class PostMutterLogic {
	public void execute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0, mutter);
	}
}