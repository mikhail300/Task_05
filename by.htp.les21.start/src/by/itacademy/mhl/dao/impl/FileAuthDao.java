package by.itacademy.mhl.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.AuthDao;

public class FileAuthDao implements AuthDao {

	@Override
	public Role authorization(String login, String password) throws DaoException {

		Role role = null;

		List<UserInfo> users = new ArrayList<UserInfo>();
		List<String> fileLines = new ArrayList<String>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/users.txt");
			bufReader = new BufferedReader(reader);
			String s = null;

			while ((s = bufReader.readLine()) != null) {
				fileLines.add(s);
			}

			for (String line : fileLines) {
				UserInfo user = new UserInfo();
				String[] params = line.split(";");

				user.setLogin(params[0]);
				user.setPassword(params[1]);
				user.setName(params[2]);
				user.setSurname(params[3]);
				user.setEmail(params[4]);
				user.setRole(Role.valueOf(params[5]));

				users.add(user);

			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					// log - err
					System.err.println(e);
				}
			}
		}

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().compareTo(login) == 0 && users.get(i).getPassword().compareTo(password) == 0) {
				role = users.get(i).getRole();
			}
		}
		return role;
	}

	@Override
	public boolean registration(UserInfo newUser) throws DaoException {

		Boolean result = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		PrintWriter printWriter = null;

		try {

			fileWriter = new FileWriter("resources/users.txt", true);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);

			printWriter.println(newUser.getLogin() + ";" + newUser.getPassword() + ";" + newUser.getName() + ";"	+ newUser.getSurname() + ";" + newUser.getEmail() + ";" + newUser.getRole());

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			if (printWriter != null) {
				try {
					printWriter.close();
				} catch (Exception e) {
					// log - err
					System.err.println(e);
				}
			}
		}
		result = true;
		return result;
	}

}
