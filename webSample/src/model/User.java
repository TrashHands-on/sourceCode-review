package model;

import java.io.Serializable;

//このクラスはユーザー名とパスワード名を持つクラス
public class User implements Serializable {
	private String name;
	private String pass;

	public User() {
	}

	/**
	 *
	 * @param name ユーザの名前
	 * @param pass パス
	 */
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
}