package by.itacademy.mhl.service.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.dao.LibraryDao;
import by.itacademy.mhl.dao.impl.DaoException;
import by.itacademy.mhl.dao.impl.DaoFactory;
import by.itacademy.mhl.service.FindService;

public class FindServiceImpl implements FindService {

	@Override
	public List<Note> findByAuthor(String author) throws ServiceException {

		List<Note> byAuthor = null;
		DaoFactory daoFactory = null;
		LibraryDao libraryDao = null;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			byAuthor = libraryDao.findByAuthor(author);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return byAuthor;
	}

	@Override
	public List<Note> findAllInCategory(String categoryName) throws ServiceException {

		List<Note> allInCategory = null;
		DaoFactory daoFactory = null;
		LibraryDao libraryDao = null;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			allInCategory = libraryDao.findAllInCategory(categoryName);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return allInCategory;
	}

	@Override
	public List<Note> allCatalog() throws ServiceException {

		List<Note> all = null;
		DaoFactory daoFactory = null;
		LibraryDao libraryDao = null;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			all = libraryDao.allCatalog();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return all;
	}
}
