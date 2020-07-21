package by.itacademy.mhl.view;

public class UserView {

	public static String relogination() {
		return "Выход успешен!";
	}

	public static String registration() {
		return "Регистрация успешна!";
	}

	public static String welcome(String role) {
		return "Вход успешен, Вы " + role;
	}


}
