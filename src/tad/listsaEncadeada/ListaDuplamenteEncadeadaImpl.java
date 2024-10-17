package tad.listasEncadeadas;

// Classe que implementa uma lista duplamente encadeada
public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

	// Nó cabeça e nó cauda da lista
	private NodoListaDuplamenteEncadeada<T> cabeca;
	private NodoListaDuplamenteEncadeada<T> cauda;

	// inicializa a lista
	public ListaDuplamenteEncadeadaImpl() {
		cabeca = new NodoListaDuplamenteEncadeada<>();
		cauda = new NodoListaDuplamenteEncadeada<>();
		cabeca.setProximo(cauda); // Conecta o nó cabeça ao nó cauda
		cauda.setAnterior(cabeca); // Conecta o nó cauda ao nó cabeça
	}

	// Verifica se a lista está vazia
	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda; // Verifica se o nó cabeça aponta para o nó cauda
	}

	// Retorna o tamanho da lista
	@Override
	public int size() {
		int size = 0;
		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo(); // Começa após o nó cabeça
		while (atual != cauda) { // Percorre até o nó cauda
			size++;
			atual = atual.getProximo();
		}
		return size; // Retorna o tamanho total
	}

	// Busca um elemento na lista
	@Override
	public NodoListaDuplamenteEncadeada<T> search(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo(); // Começa a busca após o nó cabeça
		while (atual != cauda) { // Continua até o nó cauda
			if (atual.getChave().equals(chave)) {
				return atual; // Retorna o nó se a chave for encontrada
			}
			atual = atual.getProximo(); // Avança para o próximo nó
		}
		return null; // Retorna null se não encontrado
	}

	// Insere um novo elemento na lista
	@Override
	public void insert(T chave) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<>(chave); // Cria um novo nó
		if (isEmpty()) { // Se a lista estiver vazia
			cabeca.setProximo(novoNo); // Conecta o novo nó ao nó cabeça
			novoNo.setAnterior(cabeca);
			cauda.setAnterior(novoNo); // Conecta o novo nó ao nó cauda
			novoNo.setProximo(cauda);
		} else {
			NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior(); // Obtém o último nó
			ultimo.setProximo(novoNo); // Conecta o último nó ao novo nó
			novoNo.setAnterior(ultimo); // Conecta o novo nó ao último
			novoNo.setProximo(cauda); // Conecta o novo nó ao nó cauda
			cauda.setAnterior(novoNo); // Atualiza o nó cauda
		}
	}

	// Remove um elemento da lista
	@Override
	public NodoListaDuplamenteEncadeada<T> remove(T chave) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException(); // Lança exceção se a lista estiver vazia
		}
		NodoListaDuplamenteEncadeada<T> removido = search(chave); // Busca o nó a ser removido
		if (removido != null) { // Se o nó for encontrado
			// Ajusta as referências dos nós ao redor do nó removido
			removido.getAnterior().setProximo(removido.getProximo());
			removido.getProximo().setAnterior(removido.getAnterior());
			if (removido == cabeca.getProximo()) {
				cabeca.setProximo(removido.getProximo()); // Se o nó removido era o primeiro
			}
			if (removido == cauda.getAnterior()) {
				cauda.setAnterior(removido.getAnterior()); // Se o nó removido era o último
			}
		}
		return removido; // Retorna o nó removido
	}

	// Imprime a lista em ordem
	@Override
	public String imprimeEmOrdem() {
		StringBuilder sb = new StringBuilder();
		if (!isEmpty()) {
			NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
			while (atual != cauda) {
				sb.append(atual.getChave()).append(", "); // Adiciona cada chave ao StringBuilder
				atual = atual.getProximo();
			}
			sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
		}
		return sb.toString(); // Retorna a string formada
	}

	// Imprime a lista em ordem inversa
	@Override
	public String imprimeInverso() {
		StringBuilder sb = new StringBuilder();
		if (!isEmpty()) {
			NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior(); // Começa do último elemento
			while (atual != cabeca) { // Continua até o nó cabeça
				sb.append(atual.getChave()).append(", ");
				atual = atual.getAnterior(); // Move para o nó anterior
			}
			sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
		}
		return sb.toString(); // Retorna a string formada
	}

	// Retorna o sucessor de um elemento
	@Override
	public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = search(chave);
		return (atual != null && atual.getProximo() != cauda) ? atual.getProximo() : null; // Retorna o próximo nó, se existir
	}

	// Retorna o predecessor de um elemento
	@Override
	public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = search(chave);
		return (atual != null && atual.getAnterior() != cabeca) ? atual.getAnterior() : null; // Retorna o nó anterior, se existir
	}

	// Converte a lista para um array
	@Override
	public T[] toArray(Class<T> clazz) {
		T[] elementos = (T[]) java.lang.reflect.Array.newInstance(clazz, size()); // Cria um novo array do tipo correto
		if (!isEmpty()) {
			NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
			for (int index = 0; index < elementos.length; index++) {
				elementos[index] = atual.getChave(); // Popula o array com os elementos da lista
				atual = atual.getProximo();
			}
		}
		return elementos; // Retorna o array populado
	}

	// Insere um elemento no início da lista
	@Override
	public void inserePrimeiro(T elemento) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<>(elemento);
		if (isEmpty()) {
			cabeca.setProximo(novoNo);
			novoNo.setAnterior(cabeca);
			novoNo.setProximo(cauda);
			cauda.setAnterior(novoNo);
		} else {
			novoNo.setProximo(cabeca.getProximo()); // Conecta o novo nó ao primeiro elemento
			novoNo.setAnterior(cabeca);
			cabeca.getProximo().setAnterior(novoNo); // Atualiza o primeiro elemento
			cabeca.setProximo(novoNo); // Atualiza o nó cabeça
		}
	}

	// Remove o último elemento da lista
	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() {
		if (isEmpty()) {
			return null; // Retorna null se a lista estiver vazia
		}
		NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior(); // Obtém o último nó
		ultimo.getAnterior().setProximo(cauda); // Atualiza o penúltimo nó
		cauda.setAnterior(ultimo.getAnterior()); // Atualiza a cauda
		return ultimo; // Retorna o nó removido
	}

	// Remove o primeiro elemento da lista
	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
		if (isEmpty()) {
			return null; // Retorna null se a lista estiver vazia
		}
		NodoListaDuplamenteEncadeada<T> primeiro = cabeca.getProximo(); // Obtém o primeiro nó
		cabeca.setProximo(primeiro.getProximo()); // Atualiza o nó cabeça
		primeiro.getProximo().setAnterior(cabeca); // Atualiza o próximo nó
		return primeiro; // Retorna o nó removido
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!"); // Método não implementado
	}
}
