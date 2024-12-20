package mybatis01;

import java.util.List;

import mybatis01.dao.BookDAO;
import mybatis01.model.Book;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		 
        Book book = new Book();
 
        //Creat
        //2건을 입력한다.
        System.out.println("==INSERT==");
 
        book.setId(1);
        book.setName("홍길동전");
        System.out.println(bookDAO.insert(book));
        
        book.setId(2);
        book.setName("레미제라블"); 
        bookDAO.insert(book);
        
        //Delete
        System.out.println("");
        System.out.println("==DELETE==");
// 
        //2번을 삭제한다.
//        bookDAO.delete(2);
        //1번을 삭제한다.
        bookDAO.delete(1);
        
        //Read
        //입력한 리스트를 보여준다.
        List<Book> bookList = bookDAO.selectAll();
        for(Book bookInfo: bookList){
            System.out.println("BOOK ID: "+bookInfo.getId());
            System.out.println("BOOK NAME: "+bookInfo.getName());
        }
        
        //Update
        System.out.println("");
        System.out.println("==UPDATE==");
// 
//        //ID 2번의 이름을 업데이트 한다.
        book.setId(2);
        book.setName("해저 2만리");
        bookDAO.update(book);
//        
      //Read
        //변경한 ID 2번의 이름을 보여준다ㅏ.
        book = bookDAO.selectById(2);
        System.out.println("BOOK ID: "+book.getId());
        System.out.println("BOOK NAME: "+book.getName());

	}

}
