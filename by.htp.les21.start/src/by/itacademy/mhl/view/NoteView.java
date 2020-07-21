package by.itacademy.mhl.view;

import java.util.List;

import by.itacademy.mhl.bean.Note;

public class NoteView {

	public static String noteView(String message, List<Note> notes) {
		String result = "";
		for (int i = 0; i < notes.size(); i++) {
			result += notes.get(i).getId() + "\t" + notes.get(i).getCategoryName() + "\t" + notes.get(i).getTitle() + "\t" + notes.get(i).getAuthor() + "\n";
		}
		return message + "\n" + result;
	}
	
	public static String noteEdit() {
		return "Запись отредактирована!";
	}
	
	public static String noteAdd() {
		return "Запись добавлена!";
	}
}
