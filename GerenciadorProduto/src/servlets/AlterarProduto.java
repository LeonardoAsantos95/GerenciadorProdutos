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


@WebServlet("/AlterarProduto.do")
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capturando o codigo do produto que o usuario quer alterar:
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		
		//Solicitando à service os dados do produto do codigo informado:
		ProdutoService produtoService = new ProdutoService();
		Produto produto = produtoService.consultar(codigo);

		//saida:
		//Formulario para alterar os dados do professor:
		response.setContentType("text/html");
		
		//Criando um objeto para saida de caracteres
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarProduto.do' method='post'>");
		saida.println("Codigo: " + produto.getCodigo());
		saida.println("<input type=\"hidden\" name='codigo_produto' value='"+ produto.getCodigo() +"'> <br><br> ");
		saida.println("Nome: ");
		saida.println("<input type=\"text\" name='nome_produto' value='"+ produto.getNome() +"'> <br><br> ");
		saida.println("descricao: ");
		saida.println("<input type=\"text\" name='descricao_produto' value='"+ produto.getDescricao() +"'> <br><br> ");
		saida.println("estoque: ");
		saida.println("<input type=\"text\" name='estoque_produto' value='"+ produto.getEstoque() +"'> <br><br> ");
		saida.println("Valor: ");
		saida.println("<input type=\"text\" name='valor_produto' value='"+ produto.getValor() +"'> <br><br> ");
		saida.println("<input type='submit'>");
		saida.println("</form>");
		
				
	} 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		produtoService.alterar(produto);
		
		//saida:	 
		PrintWriter saida = response.getWriter();
		saida.println("Alteração realizada com sucesso! <br><br>");
		saida.println("<a href='ListarProdutos.do'> Voltar para lista de produtos </a>");
				
				
			}
		
	}


