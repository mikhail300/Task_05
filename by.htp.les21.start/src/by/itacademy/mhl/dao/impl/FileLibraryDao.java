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

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.dao.LibraryDao;

public class FileLibraryDao implements LibraryDao {

	@Override
	public List<Note> allCatalog() throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String string = null;
			while ((string = bufReader.readLine()) != null) {
				fileLines.add(string);
			}

			for (String line : fileLines) {
				Note note = new Note();
				String[] params = line.split(";");
				int id;
				try {
					id = Integer.parseInt(params[0]);
				} catch (Exception e) {
					throw new DaoException("Ошибка чтения!", e);
				}

				note.setId(id);
				note.setCategoryName(params[1]);
				note.setTitle(params[2]);
				note.setAuthor(params[3]);

				notes.add(note);

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

		return notes;
	}

	@Override
	public List<Note> findByAuthor(String author) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String string = null;
			while ((string = bufReader.readLine()) != null) {
				fileLines.add(string);
			}
			for (String line : fileLines) {
				Note note = new Note();
				String[] params = line.split(";");
				int id;

				try {
					id = Integer.parseInt(params[0]);
				} catch (Exception e) {
					throw new DaoException("Ошибка чтения!", e);
				}

				note.setId(id);
				note.setCategoryName(params[1]);
				note.setTitle(params[2]);
				note.setAuthor(params[3]);

				notes.add(note);

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

		List<Note> byAuthor = new ArrayList<Note>();

		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getAuthor().equals(author)) {
				byAuthor.add(notes.get(i));
			}
		}
		return byAuthor;
	}

	@Override
	public List<Note> findAllInCategory(String categoryName) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String s = null;
			while ((s = bufReader.readLine()) != null) {
				fileLines.add(s);
			}

			for (String line : fileLines) {
				Note note = new Note();
				String[] params = line.split(";");

				int id;

				try {
					id = Integer.parseInt(params[0]);
				} catch (Exception e) {
					throw new DaoException("Ошибка чтения!");
				}

				note.setId(id);
				note.setCategoryName(params[1]);
				note.setTitle(params[2]);
				note.setAuthor(params[3]);

				notes.add(note);

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

		List<Note> allInCategory = new ArrayList<Note>();
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getCategoryName().equals(categoryName)) {
				allInCategory.add(notes.get(i));
			}
		}

		return allInCategory;
	}

	public void add(Note newNote) throws DaoException {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		PrintWriter printWriter = null;

		try {

			fileWriter = new FileWriter("resources/library.txt", true);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);

			printWriter.println(newNote.getId() + ";" + newNote.getCategoryName() + ";" + newNote.getTitle() + ";" + newNote.getAuthor());

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
	}

	@Override
	public boolean edit(int id, Note editNote) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String string = null;
			while ((string = bufReader.readLine()) != null) {
				fileLines.add(string);
			}

			for (String line : fileLines) {
				Note note = new Note();
				String[] params = line.split(";");
				int id_tmp;
				try {
					id_tmp = Integer.parseInt(params[0]);
				} catch (Exception e) {
					throw new DaoException("Ошибка чтения!");
				}

				note.setId(id_tmp);
				note.setCategoryName(params[1]);
				note.setTitle(params[2]);
				note.setAuthor(params[3]);

				notes.add(note);
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

		int counter = 0;
		for (Note note : notes) {
			if (note.getId() == id) {

				note.setId(editNote.getId());
				note.setCategoryName(editNote.getCategoryName());
				note.setTitle(editNote.getTitle());
				note.setAuthor(editNote.getAuthor());

				counter++;
			}
		}

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter("resources/library.txt", false);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
			for (int i = 0; i < notes.size(); i++) {
				printWriter.println(notes.get(i).getId() + ";" + notes.get(i).getCategoryName() + ";" + notes.get(i).getTitle() + ";" + notes.get(i).getAuthor());
			}
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

		if (counter == 0) {
			return false;
		} else {
			return true;
		}
	}
}
