package com.xworkz.spects.servlet;

import com.xworkz.spects.dto.SpectDTO;
import com.xworkz.spects.service.SpectService;
import com.xworkz.spects.service.SpectServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/sumbit",loadOnStartup = 1)
public class SpectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shape =req.getParameter("shape");
        String brand= req.getParameter("brand");
        String price= req.getParameter("price");

        SpectDTO spectDTO =new SpectDTO();
        spectDTO.setShape(shape);
        spectDTO.setBrand(brand);
        spectDTO.setPrice(price);
        System.out.println("Spect info:"+spectDTO);

        SpectService spectService=new SpectServiceImpl();
        boolean added = spectService.save(spectDTO);
        if(added){
            req.setAttribute("spectDTO",spectDTO);
            RequestDispatcher dispatcher = req.getRequestDispatcher("Spectorder.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.getWriter().println("adding  is required!");
        }

    }

    }

