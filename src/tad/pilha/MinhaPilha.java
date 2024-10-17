package tad.pilha; //ok

// Classe que implementa uma pilha de inteiros
public class MinhaPilha implements PilhaIF<Integer> {
	private int tamanho = 10;
	private int cabeca = 0;
	private Integer[] meusDados = null;

	// Construtor
	public MinhaPilha(int tam) {
		this.tamanho = tam;
		meusDados = new Integer[tam];
	}

	public MinhaPilha() {
		meusDados = new Integer[tamanho];
	}

	// Método para empilhar um item
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		// Verifica se a pilha está cheia
		if (cabeca == tamanho - 1) {
			throw new PilhaCheiaException(); // Lança exceção se ta cheia
		} else {
			this.meusDados[this.cabeca] = item; // bota o item no topo da pilha
			this.cabeca++; // Incrementa o índice do topo
		}
	}

	// Método para desempilhar um item da pilha
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		// Verifica se a pilha está vazia
		if (isEmpty()) {
			throw new PilhaVaziaException(); // Lança exceção se vazia
		}
		Integer desempilhado = this.topo(); // pega o item do topo
		this.meusDados[cabeca - 1] = null; // tira o item do array
		this.cabeca--; // Decrementa o índice do topo
		return desempilhado; // Retorna o item desempilhado
	}

	// Método para obter o item no topo da pilha sem removê-lo
	@Override
	public Integer topo() {
		Integer retornar = null;
		if (!isEmpty()) {
			retornar = this.meusDados[cabeca - 1]; // Retorna o item do topo
		}
		return retornar; // Retorna null se a pilha estiver vazia
	}

	// Método para empilhar múltiplos itens do topo da pilha
	@Override
	public PilhaIF<Integer> multitop(int k) throws PilhaCheiaException, PilhaVaziaException {
		PilhaIF<Integer> retornar = null; // Inicializa a pilha de retorno
		if (k > this.tamanho - 1) {
			throw new PilhaVaziaException();
		}
		if (k == cabeca + 1) {
			retornar = new MinhaPilha();
			retornar.empilhar(this.meusDados[cabeca - 1]);
		} else {
			retornar = new MinhaPilha();
			for (int i = 1; i <= k; i++) {
				retornar.empilhar(this.meusDados[cabeca - i]);
			}
		}

		return retornar; // Retorna a nova pilha
	}

	// Método que verifica se a pilha está vazia
	@Override
	public boolean isEmpty() {
		return cabeca == 0;
	}

	// Método que verifica se duas pilhas são iguais
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; // Verifica se são a mesma instância
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false; // Verifica se o objeto é nulo ou de classe diferente
		}
		MinhaPilha outraPilha = (MinhaPilha) obj; // Faz o casting para comparação

		if (this.cabeca != outraPilha.cabeca) {
			return false; // Verifica se o tamanho das pilhas é igual
		}
		// Compara cada elemento da pilha
		for (int i = 0; i < cabeca; i++) {
			if (!this.meusDados[i].equals(outraPilha.meusDados[i])) {
				return false; // Retorna false se algum elemento for diferente
			}
		}
		return true; // Retorna true se todas as comparações forem iguais
	}
}
