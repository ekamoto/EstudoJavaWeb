package br.com.alura.gerenciador.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.TargetDataLine;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.web.Tarefa;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa implements Tarefa{

	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo buscaEmpresa" + this);
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
}
