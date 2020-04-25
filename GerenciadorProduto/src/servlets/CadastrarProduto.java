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

@WebServlet("/CadastrarProduto.do")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Recebendo os dados do usuario: (capturando os parametros)
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String nome = request.getParameter("nome_produto");
		String descricao = request.getParameter("descricao_produto");
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		
		
					
		// Instaciar o objeto do tipo produto:
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
						
		//Enviar o objeto produto para service:
		ProdutoService produtoService = new ProdutoService();
		produtoService.cadastrar(produto);
		
		//saida:	 
		 PrintWriter saida = response.getWriter();
		 saida.println("Cadastro realizado com sucesso! <br><br>");
		 saida.println("<a href='Index.html'> Clique aqui para cadastrar outro produto </a> <br><br>");
		 saida.println("<a href='ListarProdutos.do'> Ir para lista de produtos </a>");
		 	
		
	}

}
