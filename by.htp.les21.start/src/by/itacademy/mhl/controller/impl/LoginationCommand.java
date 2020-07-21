package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.impl.ServiceException;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class LoginationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String login;
		String password;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginService loginService = serviceFactory.getLoginService();

		String response = null;

		if (params.length != 3) {
			return "Не верное колличество параметров!";
		}

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];

		try {
			UserStatus.role = loginService.logination(login, password);
			response = UserView.welcome(UserStatus.role.toString());
		} catch (ServiceException e) {
			response = "Error!";
			e.printStackTrace();
		}
		return response;
	}
}
