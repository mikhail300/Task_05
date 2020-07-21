package by.itacademy.mhl.service;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.service.impl.ServiceException;

public interface LoginService {

	Role logination(String login, String password) throws ServiceException;

	boolean registration(UserInfo user) throws ServiceException;

}
