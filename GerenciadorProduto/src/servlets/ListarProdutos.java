package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/ListarProdutos.do" )
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//solicitar à servicea lista de produtos:
		ProdutoService produtoService = new ProdutoService();
		//Instanciando a lista um lista de produtos (vazia):
		ArrayList<Produto> listaProduto = null;
		//Carregando a lista com os professores do banco de dados:
		listaProduto = produtoService.listaProduto();
		
		//definir um objeto de saida de caractes:
		PrintWriter saida = response.getWriter();
		
		//percorrer toda lista de objetos produtos e imprimir os dados:
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table>");
		listaProduto.forEach(
				p -> {
					saida.println("<tr>");
					saida.println("<td>");
					saida.println(p.getCodigo());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getNome());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getDescricao());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getValor());
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getEstoque());
					saida.println("</td>");
					
					
					/* Criando um coluna para link de exclusao*/
					saida.println("<td>");
					saida.println("<a href='ExcluirProduto.do?codigo="+ p.getCodigo() +"'> Excluir </a>");
					saida.println("</td>");
					
					/* Criando um coluna para link de alteracao*/
					saida.println("<td>");
					saida.println("<a href='AlterarProduto.do?codigo="+ p.getCodigo() +"'> Alterar </a>");
					saida.println("</td>");
					
					saida.println("</tr>");
					
					
					
				}
				
			);
			
		saida.println("</table>");
		
		saida.println("<a href='Index.html'> Clique aqui para cadastrar produto </a> <br><br>");
		
		
	}

}
