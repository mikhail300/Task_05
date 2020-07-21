package by.itacademy.mhl.service.validation;

public class UserDataValidator {

	public static boolean checkAuthData(String login, String password) {

		Boolean responce = null;

		if (login == password) {

			responce = false;

		} else {

			responce = true;

		}

		return responce;

	}

}
