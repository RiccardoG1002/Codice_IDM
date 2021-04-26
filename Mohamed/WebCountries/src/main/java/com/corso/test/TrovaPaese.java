package com.corso.test;

import java.io.IOException;
import java.io.PrintWriter;

import com.corso.exceptions.PaeseNotFoundException;
import com.corso.paesi.CheckPaese;
import com.corso.paesi.Paese;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TrovaPaese
 */
@WebServlet("/TrovaPaese")
public class TrovaPaese extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String paeseCercato = request.getParameter("paese");

		
		CheckPaese checkPaese = new CheckPaese();
		//List dizionario = Utility.toList("C:\Users\User\Documents\Academy IDM\checkString Raissa\src\lista.txt");/
		String nomePaeseTrovato = "errore";
		try {
			Paese p = checkPaese.getPaeseStandard("Unnited statas");
			nomePaeseTrovato = p.getNome();
		} catch (PaeseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LA MIA RISPOSTA
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+nomePaeseTrovato+"</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + "TEST" + "</h1>" );
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
