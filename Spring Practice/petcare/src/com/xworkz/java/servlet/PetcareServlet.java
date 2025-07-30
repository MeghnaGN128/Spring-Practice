package com.xworkz.java.servlet;

import com.xworkz.java.dto.PetcareDTO;
import com.xworkz.java.service.PetcareService;
import com.xworkz.java.service.PetcareServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/pet")
public class PetcareServlet extends HttpServlet {
    public PetcareServlet(){
        System.out.println("running in petcareServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name= req.getParameter("name");
       int id=Integer.parseInt(req.getParameter("id"));
       String location=req.getParameter("location");
       boolean service=Boolean.parseBoolean(req.getParameter("service"));

        PetcareDTO petcareDTO=new PetcareDTO();
        petcareDTO.setName(name);
        petcareDTO.setId(id);
        petcareDTO.setLocation(location);
        petcareDTO.setHasservice(service);
        System.out.println("petDTO details"+petcareDTO);

        PetcareService petcareService=new PetcareServiceImpl();
        boolean present=petcareService.present(petcareDTO);
        if(present){
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("PetcareResult.jsp");
            req.setAttribute("petcareDTO",petcareDTO);
            requestDispatcher.forward(req,resp);
        }else {
            resp.setContentType("text/plain");
            resp.getWriter().println("Data not send");
        }
    }
}
