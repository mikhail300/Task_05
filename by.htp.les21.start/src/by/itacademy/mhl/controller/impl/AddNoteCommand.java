package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.NoteService;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.NoteView;

public class AddNoteCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		int id = 0;
		String category = null;
		String title = null;
		String author = null;
		Note addNote = new Note();

		ServiceFactory factory = ServiceFactory.getInstance();
		NoteService noteService = factory.getNoteService();

		if (params.length != 5) {
			return "Не верное колличество параметров!";
		}

		id = Integer.parseInt(params[1].split("=")[1]);
		category = params[2].split("=")[1];
		title = params[3].split("=")[1];
		author = params[4].split("=")[1];

		addNote.setId(id);
		addNote.setCategoryName(category);
		addNote.setTitle(title);
		addNote.setAuthor(author);

		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}

		if (!UserStatus.role.equals(Role.ADMIN)) {
			return "Ошибка доступа, Вы не Админ";
		}

		try {
			noteService.add(addNote);
			response = NoteView.noteAdd();
		} catch (Exception e) {
			response = "Ошибка!";
			e.printStackTrace();
		}
		return response;
	}
}
