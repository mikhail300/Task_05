package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.impl.ServiceException;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.NoteView;

public class AllCatalogCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		List<Note> allCatalog = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService findService = factory.getFindService();

		if (params.length != 1) {
			return "Не верное колличество параметров!";
		}

		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}

		try {
			allCatalog = findService.allCatalog();
			response = NoteView.noteView("Весь каталог", allCatalog);
		} catch (ServiceException e) {
			response = "Error!";
			e.printStackTrace();
		}
		return response;
	}
}
