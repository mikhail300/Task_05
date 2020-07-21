package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.impl.ServiceException;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.NoteView;

public class FindByAuthorCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		String author = null;
		List<Note> byAuthor = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService findService = factory.getFindService();

		if (params.length != 2) {
			return "Не верное колличество параметров!";
		}
		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}

		author = params[1].split("=")[1];

		try {
			byAuthor = findService.findByAuthor(author);
			if (byAuthor.isEmpty()) {
				response = "Нет такого автора!";
			} else {
				response = NoteView.noteView("By author:", byAuthor);
			}
		} catch (ServiceException e) {
			response = "Ошибка!";
			e.printStackTrace();
		}
		return response;
	}
}
