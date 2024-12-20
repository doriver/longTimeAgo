package mybatis01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis01.model.Book;



public class BookDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public BookDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(Book book){
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            id = session.insert("BB.insert", book);
        } finally {
            session.commit();
            session.close();
        }
 
        return id;
    }
    
    public void delete(int id){
   	 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("BB.delete", id);
        } finally {
            session.commit();
            session.close();
        }
    }
    
    public List<Book> selectAll(){
        List<Book> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("BB.selectAll");
        } finally {
            session.close();
        }
 
        return list;
    }
    
    public void update(Book book){
    	 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.update("BB.update", book);
        } finally {
            session.commit();
            session.close();
        }
    }
    
    public Book selectById(int id){
        Book book = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            book = session.selectOne("BB.selectById", id);
        } finally {
            session.close();
        }
 
        return book;
    }
}
