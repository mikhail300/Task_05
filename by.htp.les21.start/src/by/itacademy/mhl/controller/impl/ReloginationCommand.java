package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.view.UserView;

public class ReloginationCommand implements Command {

	@Override
	public String execute(String[] params) {
		String response = null;
		if (params.length != 1) {
			response = "Не верное колличество параметров!";
		} else {
			if (UserStatus.role == null) {
				response = "Вы не авторизованы!";
			} else {
				UserStatus.role = null;
				response = UserView.relogination();
			}
		}
		return response;
	}
}
