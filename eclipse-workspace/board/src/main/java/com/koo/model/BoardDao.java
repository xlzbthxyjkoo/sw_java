package com.koo.model;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
	
	private static SqlSessionFactory sessionFactory = null;
	
	public static SqlSessionFactory getInstance() {
        if (sessionFactory == null) {
            try {
                String resource = "mybatis-config.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
	
	public List<NoticeBoard> selectAllArticles() {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		List<NoticeBoard> articleList = session.selectList("mapper.board.selectAllArticles");
		session.close();
		return articleList;
	}
	
	public void insertArticle(NoticeBoard noticeBoard) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.insert("mapper.board.insertArticle", noticeBoard);
		session.commit();
	}
	
	public NoticeBoard selectArticle(int articleNo) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		NoticeBoard article = session.selectOne("mapper.board.selectArticle", articleNo);
		session.close();
		return article;
	}
	
	public void updateArticle(NoticeBoard noticeBoard) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.update("mapper.board.updateArticle", noticeBoard);
		session.commit();
	}
	
	public void deleteArticle(int articleNo) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.delete("mapper.board.deleteArticle", articleNo);
		session.commit();
	}

}
