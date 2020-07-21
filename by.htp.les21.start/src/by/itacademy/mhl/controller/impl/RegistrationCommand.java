package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.impl.ServiceException;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;

		UserInfo user = new UserInfo();

		String login = null;
		String password = null;
		String name = null;
		String surname = null;
		String email = null;
		Role role = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginService loginService = serviceFactory.getLoginService();

		if (params.length != 7) {

			return "Не верное колличество параметров!";

		}

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];
		name = params[3].split("=")[1];
		surname = params[4].split("=")[1];
		email = params[5].split("=")[1];
		role = Role.valueOf(params[6].split("=")[1].toUpperCase());

		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setRole(role);

		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}
		if (!UserStatus.role.equals(Role.ADMIN)) {
			return "Ошибка доступа, Вы не Админ!";
		}
		
		
		try {
			loginService.registration(user);
			response = UserView.registration();
		} catch (ServiceException e) {
			response = "Error!";
			e.printStackTrace();
		}
		return response;
	}
}
