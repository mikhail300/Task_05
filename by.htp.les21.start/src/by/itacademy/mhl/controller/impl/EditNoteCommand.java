package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.NoteService;
import by.itacademy.mhl.service.impl.ServiceFactory;
import by.itacademy.mhl.view.NoteView;

public class EditNoteCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		Note editNote = new Note();
		int id = 0;
		int newId = 0;
		String category = null;
		String title = null;
		String author = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		NoteService noteService = factory.getNoteService();

		if (params.length != 6) {
			return "Не верное колличество параметров!";
		}

		id = Integer.parseInt(params[1].split("=")[1]);
		newId = Integer.parseInt(params[2].split("=")[1]);
		category = params[3].split("=")[1];
		title = params[4].split("=")[1];
		author = params[5].split("=")[1];

		editNote.setId(newId);
		editNote.setCategoryName(category);
		editNote.setTitle(title);
		editNote.setAuthor(author);

		if (UserStatus.role == null) {
			return "Вы не авторизованы!";
		}

		if (!UserStatus.role.equals(Role.ADMIN)) {
			return "Ошибка доступа, Вы не Админ!";
		}

		try {
			noteService.edit(id, editNote);
			response = NoteView.noteEdit();
		} catch (Exception e) {
			response = "Ошибка!";
			e.printStackTrace();
		}
		return response;
	}
}
