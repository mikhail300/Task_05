package by.itacademy.mhl.service.impl;

import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.NoteService;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private final LoginService loginService = new LoginServiceImpl();
	private final NoteService noteService = new NoteServiceImpl();
	private final FindService findService = new FindServiceImpl();

	private ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public FindService getFindService() {
		return findService;
	}

}
