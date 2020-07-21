package by.itacademy.mhl.dao;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.impl.DaoException;

public interface AuthDao {

	Role authorization(String login, String password) throws DaoException;

	boolean registration(UserInfo newUser) throws DaoException;
}
