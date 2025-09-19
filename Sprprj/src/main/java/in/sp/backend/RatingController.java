package in.sp.backend;

import com.example.dao.RatingDAO;
import com.example.dao.RatingDAOImpl;
import com.example.dto.RatingDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/rateMovie")
public class RatingController extends HttpServlet {
    private RatingDAO ratingDAO = new RatingDAOImpl();

    // ✅ Handles GET request → open rateMovie.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Forward to JSP inside WEB-INF
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rateMovie.jsp");
        rd.forward(request, response);
    }

    // ✅ Handles POST request → save rating
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int ratingValue = Integer.parseInt(request.getParameter("rating"));

        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setUserId(userId);
        ratingDTO.setMovieId(movieId);
        ratingDTO.setRating(ratingValue);

        boolean success = ratingDAO.saveOrUpdateRating(ratingDTO);

        request.setAttribute("status", success ? "SUCCESS" : "FAILURE");
        request.setAttribute("rating", ratingDTO);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ratingResult.jsp");
        rd.forward(request, response);
    }
}
