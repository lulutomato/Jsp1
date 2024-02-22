package servlet.day3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVo;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet(urlPatterns ={"/products.cc"}, description = "고객 전체 조회")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	TblProductDao dao = new TblProductDao();
	List<ProductVo> list = dao.selectAll();
	logger.info("[Myinfo] 상품전체조회 : {}",list);
	
	req.setAttribute("list",list);
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("/day03/products.jsp");
	  dispatcher.forward(req, resp);


}
}