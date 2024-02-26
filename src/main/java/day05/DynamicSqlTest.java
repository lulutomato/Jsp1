package day05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;



public class DynamicSqlTest {

	public static void main(String[] args) {
		//testNoFilter();
		//testcateFilter();
		//testpnameFilter();
		//testcatepnameFilter();
		//testallFilter();
		//testpriceFilter();
		testOrderByFilter();
	}
	public static void testNoFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(null);
		System.out.println("검색 필터 없음 :" + list); 	//전체 조회
	}

    public static void testcateFilter() {
	MybatisProductDao dao = new MybatisProductDao();
	Map<String,Object>map = new HashMap<>();
	map.put("category","C1");				//key는 파라미터 이름, value는 검색하고 싶은 컬럼값
				//key는 매퍼 xml 확인		// value는 변경해서 테스트하기
	List<ProductDto> list = dao.search(map);
	System.out.println("검색 필터 -카테고리 :" + list);
}
    public static void testpnameFilter() {
    MybatisProductDao dao = new MybatisProductDao();
    Map<String,Object>map = new HashMap<>();
    map.put("keyword","사과");	
    List<ProductDto> list = dao.search(map);
	System.out.println("검색 필터 상품명 :" + list);
    }
    public static void testcatepnameFilter() {
    	MybatisProductDao dao = new MybatisProductDao();
    	Map<String,Object>map = new HashMap<>();
    	map.put("keyword","사과");	
    	map.put("category","A1");	
    	List<ProductDto> list = dao.search(map);
    	System.out.println("검색 필터 -상품명과 카테고리 :" + list);
    }
    public static void testpriceFilter() {
    	MybatisProductDao dao = new MybatisProductDao();
    	Map<String,Object>map = new HashMap<>();
    	//문제: 가격 필터도 적용되도록 매퍼 xml의 동적쿼리를 수정하세요
    	map.put("from",10000);	
    	map.put("to",40000);	
    	List<ProductDto> list = dao.search(map);
    	System.out.println("검색 필터 -상품명과 카테고리 그리고 가격 :" + list);
    }
    public static void testallFilter() {
    	MybatisProductDao dao = new MybatisProductDao();
    	Map<String,Object>map = new HashMap<>();
    	map.put("keyword","사과");	
    	map.put("category","B2");	
    	//문제: 가격 필터도 적용되도록 매퍼 xml의 동적쿼리를 수정하세요
    	map.put("from",10000);	
    	map.put("to",40000);	
    	List<ProductDto> list = dao.search(map);
    	System.out.println("검색 필터 -상품명과 카테고리 그리고 가격 :" + list);
    }
    public static void testOrderByFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object>map = new HashMap<>(); 
		map.put("column", "pname");		//컬럼명 지정하여 정렬하기 (컬럼명 정확히)
		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 없음 :" + list); 
    }
}