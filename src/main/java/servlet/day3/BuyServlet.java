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

import project.dao.TblBuyDao;
import project.vo.BuyVo;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet(urlPatterns={"/buys.cc"}, description = "구매 물품 구매")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BuyServlet.class);
       
  @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


  TblBuyDao dao = new TblBuyDao();
  List<BuyVo> list = dao.selectAll();
  logger.info("[Myinfo] 구매전체조회 : {}",list);
  
  req.setAttribute("list",list);
  
  RequestDispatcher dispatcher = req.getRequestDispatcher("/day03/Buys.jsp");
  dispatcher.forward(req, resp);
  
}
}