package by.itacademy.mhl.service;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.service.impl.ServiceException;

public interface FindService {

	List<Note> findByAuthor(String author) throws ServiceException;

	List<Note> findAllInCategory(String categoryName) throws ServiceException;

	List<Note> allCatalog() throws ServiceException;

}
