package servlets;

import dto.TestingDto;
import service.TestingService;
import service.TestingServiceImlimentation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")

public class TestingServlet extends HttpServlet {
    public TestingServlet(){
        System.out.println("Testing servelt is running");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       String num=req.getParameter("num");

        TestingDto testingDto=new TestingDto();
        testingDto.setName(name);
        testingDto.setNum(num);
        System.out.println("Data fetched from front end is"+testingDto);

        TestingService testingService=new TestingServiceImlimentation();
        boolean save=testingService.save(testingDto);
                if(save==true){
                    RequestDispatcher requestDispatcher=req.getRequestDispatcher("sucess.jsp");
                    req.setAttribute("message","Data was saved");
                    requestDispatcher.forward(req,resp);
                }
                else{
                    System.out.println("Bettet luck next time");
                }
    }
}
