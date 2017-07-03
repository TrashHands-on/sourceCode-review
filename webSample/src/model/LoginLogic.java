package model;

public class LoginLogic {
	public boolean execute(User user) {
		/*判定条件、
		*1.名前が全角半角記号および全角半角スペース以外かつ10文字以内
		*2.passwordは1234のみ受け付ける*/
		if (!(user.getName().matches("^[\\p{M}\\p{P}\\p{S}\\p{Z}\\p{C}]*$")) && user.getName().length() <=10 && user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}