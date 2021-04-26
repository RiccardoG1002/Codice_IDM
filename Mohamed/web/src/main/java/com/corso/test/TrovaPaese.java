package com.corso.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.exceptions.PaeseNotFoundException;
import com.corso.paesi.CheckPaese;
import com.corso.paesi.Paese;
import com.corso.paesi.Sinonimo;



/**
 * Servlet implementation class TrovaPaese
 */
@WebServlet("/TrovaPaese")
public class TrovaPaese extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contatore =0;

    /**
     * Default constructor. 
     */
    public TrovaPaese() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paeseCercato = request.getParameter("input_paese");

		
		CheckPaese checkPaese = new CheckPaese();
		Paese paese = null;
		
		try {
			 paese = checkPaese.getPaeseStandard(paeseCercato);
			 contatore++;

				// LA MIA RISPOSTA
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>"+paese.getNome()+"</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>" + paese.getNome() + "</h1>" );
				out.println("<h3>" + paese.getCodice() + "</h3>" );
			//	for(Sinonimo s : paese.getSinonimi())
		   //		out.println("<small>" + s.getCercata() + " by: "+ s.getAlgoritmo()+ "\n"+"</small>" );
				out.println("<h3>" + "contatore: " + contatore + "</h3>" );
				out.println("</body>");
				out.println("</html>");
				
		} catch (PaeseNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
