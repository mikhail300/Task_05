package by.itacademy.mhl.service.impl;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.AuthDao;
import by.itacademy.mhl.dao.impl.DaoException;
import by.itacademy.mhl.dao.impl.DaoFactory;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.validation.UserDataValidator;

public class LoginServiceImpl implements LoginService {

	@Override
	public Role logination(String login, String password) throws ServiceException {

		if (!UserDataValidator.checkAuthData(login, password)) {
			throw new ServiceException("Не верный логин или пароль!");
		}

		Role role = null;
		DaoFactory daoFactory = null;
		AuthDao authDao = null;

		try {
			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			role = authDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		if (role == null) {
			throw new ServiceException("Не верный логин или пароль!");
		}
		return role;
	}

	@Override
	public boolean registration(UserInfo user) throws ServiceException {

		if (!UserDataValidator.checkAuthData(user.getLogin(), user.getPassword())) {
			throw new ServiceException("Не верный логин или пароль!!");
		}

		Boolean result = null;
		DaoFactory daoFactory = null;
		AuthDao authDao = null;

		try {
			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			result = authDao.registration(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
}
