package by.itacademy.mhl.main;

import by.itacademy.mhl.controller.Controller;
import by.itacademy.mhl.service.impl.ServiceException;

public class Main {

	public static void main(String[] args) throws ServiceException {

		Controller controller = new Controller();

		String userRequest = null;
		String userResponse = null;

		userRequest = "logination login=Вася password=12345";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "add_note id=0 category=Категория_0 title=Название_0 author=Автор_0";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "add_note id=1 category=Категория_0 title=Название_1 author=Автор_1";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "add_note id=2 category=Категория_1 title=Название_2 author=Автор_2";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "add_note id=3 category=Категория_1 title=Название_3 author=Автор_2";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "add_note id=4 category=Категория_1 title=Название_4 author=Автор_3";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "add_note id=5 category=Категория_2 title=Название_5 author=Автор_2";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "add_note id=6 category=Категория_2 title=Название_6 author=Автор_4";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_category category=Категория_1";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_author author=Автор_2";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "edit_note id=5 id=22 category=Категория_22 title=Название_22 author=Автор_22";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();

		userRequest = "registration login=Петя password=54321 name=Петя surname=Петров email=petrov@mail.ru role=user";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "relogination";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "add_note id=6 category=Категория_6 title=Название_6 author=Автор_6";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "registration login=Петя password=54321 name=Петя surname=Петров email=petrov@mail.ru role=user";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
	
		userRequest = "logination login=Петя password=44321";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "logination login=Петя password=54321";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "add_note id=6 category=Категория_6 title=Название_6 author=Автор_6";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "registration login=Петя password=54321 name=Петя surname=Петров email=petrov@mail.ru role=user";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_category category=Категория_1";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_author author=Автор_2";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_category category=Категория_11";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "find_by_author author=Автор_11";
		userResponse = controller.doAction(userRequest);
		System.out.println ("> " +userRequest);
		System.out.println(userResponse);
		System.out.println();
	}

}
