package es.cursoalcobendas.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saludo.html")
public class PrimerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nom");
		String apellido = req.getParameter("ape");
		
		String h1 = "<h1>¡Qué alegría tenerte "+ nombre + " " + apellido + " por aquí!</h1>";
		
		PrintWriter out = resp.getWriter();

		out.println(getHtml1() + h1 + getHtml2());
		
	}

	private String getHtml1() {
		return """
				<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>¡Te damos la bienvenida!</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #e0c3fc 0%, #8ec5fc 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #333;
        }
        .card {
            background: white;
            padding: 2.5rem;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 450px;
            width: 90%;
        }
        .icon {
            font-size: 3rem;
            margin-bottom: 1rem;
        }
        h1 {
            color: #4a5568;
            font-size: 2rem;
            margin-bottom: 1rem;
            font-weight: 700;
        }
        p {
            color: #718096;
            line-height: 1.6;
            margin-bottom: 1.5rem;
            font-size: 1.1rem;
        }
        .btn {
            display: inline-block;
            background: #6c5ce7;
            color: white;
            padding: 0.8rem 2rem;
            border-radius: 50px;
            text-decoration: none;
            font-weight: bold;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        .btn:hover {
            background: #5b4bc4;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>

    <div class="card">
        <div class="icon">✨</div>
""";
	}
	
	private String getHtml2() {
		return """
		        <p>Te damos la más cálida bienvenida a este pequeño rincón digital. Esperamos que disfrutes de tu estancia, encuentres la inspiración que buscas y que este día te traiga momentos increíbles.</p>
		        <a href="#" class="btn" onclick="alert('¡Gracias por pasarte por aquí! Que tengas un día fantástico.')">¡Hola de nuevo!</a>
		    </div>

		</body>
		</html>

		""";
	}
}
