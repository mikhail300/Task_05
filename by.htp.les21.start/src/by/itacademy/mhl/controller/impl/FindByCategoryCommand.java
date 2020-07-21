package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.impl.ServiceException;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.NoteView;

public class FindByCategoryCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		String category = null;
		List<Note> byCategory = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService findService = factory.getFindService();

		if (params.length != 2) {
			return "Неверное количество параметров!";
		}
		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}

		category = params[1].split("=")[1];

		try {
			byCategory = findService.findAllInCategory(category);
			if (byCategory.isEmpty()) {
				response = "Нет такой категории!";
			} else {
				response = NoteView.noteView("По категории:", byCategory);
			}
		} catch (ServiceException e) {
			response = "Error!";
			e.printStackTrace();
		}
		return response;
	}
}
