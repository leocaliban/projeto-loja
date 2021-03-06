package com.leocaliban.loja;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leocaliban.loja.domain.Boleto;
import com.leocaliban.loja.domain.CartaoCredito;
import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.domain.Cidade;
import com.leocaliban.loja.domain.Cliente;
import com.leocaliban.loja.domain.Endereco;
import com.leocaliban.loja.domain.Estado;
import com.leocaliban.loja.domain.ItemPedido;
import com.leocaliban.loja.domain.Pagamento;
import com.leocaliban.loja.domain.Pedido;
import com.leocaliban.loja.domain.Produto;
import com.leocaliban.loja.domain.enums.EstadoPagamento;
import com.leocaliban.loja.domain.enums.TipoCliente;
import com.leocaliban.loja.repositories.CategoriaRepository;
import com.leocaliban.loja.repositories.CidadeRepository;
import com.leocaliban.loja.repositories.ClienteRepository;
import com.leocaliban.loja.repositories.EnderecoRepository;
import com.leocaliban.loja.repositories.EstadoRepository;
import com.leocaliban.loja.repositories.ItemPedidoRepository;
import com.leocaliban.loja.repositories.PagamentoRepository;
import com.leocaliban.loja.repositories.PedidoRepository;
import com.leocaliban.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	//Através do CommandLineRunner, por padrão serão instanciados esses objetos ao iniciar a aplicação
	@Override
	public void run(String... arg0) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Telefonia");
				
		Produto produto1 = new Produto(null, "Computador", 3500.00);
		Produto produto2 = new Produto(null, "Teclado", 45.00);
		Produto produto3 = new Produto(null, "Mouse", 35.00);
		Produto produto4 = new Produto(null, "Celular", 890.00);
		Produto produto5 = new Produto(null, "Fone De Ouvido", 16.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto5));
		categoria2.getProdutos().addAll(Arrays.asList(produto4, produto5));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		produto4.getCategorias().addAll(Arrays.asList(categoria2));
		produto5.getCategorias().addAll(Arrays.asList(categoria1, categoria2));

		categoriaRepository.save(Arrays.asList(categoria1, categoria2));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Estado estado1 = new Estado(null, "São Paulo");
		Estado estado2 = new Estado(null, "Rio De Janeiro");
		
		Cidade cidade1 = new Cidade(null, "Santos", estado1);
		Cidade cidade2 = new Cidade(null, "Jundiaí", estado1);
		Cidade cidade3 = new Cidade(null, "Niterói", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		estadoRepository.save(Arrays.asList(estado1, estado2));
		cidadeRepository.save(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Jack Bauer", "jb@gmail.com", "088.236.998.12", TipoCliente.FISICA);
		cliente1.getTelefones().addAll(Arrays.asList("98526-2566","99985-1222"));
		
		Endereco endereco1 = new Endereco(null, "Rua Anchieta", "200", "Vila Boaventura", "13201-804", "CASA", cliente1, cidade2);
		Endereco endereco2 = new Endereco(null, "Rua Doutor Borman", "5255", "Centro", "24020-320", "CASA", cliente1, cidade3);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
		
		clienteRepository.save(Arrays.asList(cliente1));
		enderecoRepository.save(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 09:30"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/12/2017 12:28"), cliente1, endereco2);
		
		Pagamento pagamento1 = new CartaoCredito(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new Boleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.save(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.save(Arrays.asList(pagamento1, pagamento2));
		
		ItemPedido item1 = new ItemPedido(pedido1, produto1, 0.00, 1, 3500.00);
		ItemPedido item2 = new ItemPedido(pedido1, produto5, 0.00, 1, 16.00);
		ItemPedido item3 = new ItemPedido(pedido2, produto4, 0.00, 1, 890.00);
		
		pedido1.getItens().addAll(Arrays.asList(item1, item2));
		pedido2.getItens().addAll(Arrays.asList(item3));
		
		produto1.getItens().addAll(Arrays.asList(item1));
		produto5.getItens().addAll(Arrays.asList(item2));
		produto4.getItens().addAll(Arrays.asList(item3));
		
		itemPedidoRepository.save(Arrays.asList(item1, item2, item3));

	}
}
