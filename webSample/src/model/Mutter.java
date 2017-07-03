package model;

import java.io.Serializable;

public class Mutter implements Serializable {

	// アカウントネーム
	private String userName;
	// つぶやき内容
	private String text;

	public Mutter() {
	}

	// 引数なしでもnewできるようにするためのコンストラクタ
	/**
	 *
	 * @param userName ユーザの名前
	 * @param text つぶやき内容
	 */
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}
}