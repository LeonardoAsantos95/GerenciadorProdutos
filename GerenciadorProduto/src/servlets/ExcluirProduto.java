package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/ExcluirProduto.do")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//captura de parametros: Produto para ser excluido do banco:
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		//Instanciando um objeto do tipo Produto:
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		
		//Solicitando a service a remoção do produto:
		ProdutoService produtoService = new ProdutoService();
		produtoService.excluir(produto);
		
		
		//saida:	 
		PrintWriter saida = response.getWriter();
		saida.println("Produto excluido com sucesso! <br><br>");
		saida.println("<a href='ListarProdutos.do'> Voltar para lista de produtos </a>");
	}

}