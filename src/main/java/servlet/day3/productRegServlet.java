package servlet.day3;
import java.io.IOException;

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

@WebServlet(urlPatterns = {"/productReg.cc"},description = "상품 등록")
public class productRegServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	private static final Logger logger = LoggerFactory.getLogger(productRegServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[MyInfo] 상품등록 화면 요청되었습니다.");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day03/productReg.jsp");
		dispatcher.forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[MyInfo] 상품등록 데이터 저장이 요청되었습니다.");
		req.setCharacterEncoding("UTF-8");
		
		String pcode = req.getParameter("pcode");
		String category = req.getParameter("category");
		String pname = req.getParameter("pname");
		String temp = req.getParameter("price");
		int price = 0;
		if(temp.length()!=0) price=Integer.parseInt(temp);
		
		ProductVo vo = new ProductVo(pcode, category, pname, price);
		logger.info("\t 입력 값 vo :{}",vo);
		TblProductDao dao = new TblProductDao();
		dao.addProduct(vo);
		
		resp.sendRedirect("products.cc");
		
	}

}