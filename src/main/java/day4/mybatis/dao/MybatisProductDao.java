package day4.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();

	
	public List<ProductDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectAll");
		sqlSession.close();
		return list;
		}
	public int insert(ProductDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblproduct.insert",dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public List<ProductDto> selectByCategory(String category){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list2 = sqlSession.selectList("tblproduct.selectByCategory");
		sqlSession.close();
		return list2;
	}
	public List<ProductDto> selectByPname(String pname){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list3 = sqlSession.selectList("tblproduct.selectByPname");
		sqlSession.close();
		return list3;
	}
	public int delete (String pname) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblproduct.delete",pname);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	
	
	
	
	
}
