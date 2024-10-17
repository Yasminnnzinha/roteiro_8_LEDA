package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = new Integer[10];
	private int posInsercao = 0;

	@Override
	public void inserir(Integer item) {
		if (arrayEstaCheio()) {
			aumentarArray();
		}
		meusDados[posInsercao] = item;
		posInsercao++;
	}
	//TODO:  Implementar esse método também
	private boolean arrayEstaCheio() {
		return this.posInsercao == this.meusDados.length;
	}

	private Integer[] aumentarArray() {
		// criar um array maior (arrayMaior)
		// Qual é a taxa de aumento desse array?
		Integer[] copiaArray = new Integer[(this.meusDados.length) * 2];

		// copiar os dados de meusDados (array cheio)
		for (int i = 0; i < this.meusDados.length; i++){
			copiaArray[i] = this.meusDados[i];
		}

		// colar os dados para o novo array (arrayMaior)
		this.meusDados = copiaArray;
		return copiaArray;
	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException{
		Integer retornar = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		}
		else{
			for(int i = 0; i < this.posInsercao; i++){
				if(this.meusDados[i] == item){
					for(int j = 0; j < this.posInsercao - 1; j++){
						this.meusDados[j] = this.meusDados[j+1];
					}
					this.meusDados[this.posInsercao - 1] = null;
					this.posInsercao--;
					retornar = item;
				}
			}
		}
		return retornar;
	}

	@Override
	public Integer predecessor(Integer item) throws ConjuntoVazioException {
		Integer retornar = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		}
		else{
			for(int i = 0; i < this.posInsercao; i++){
				if(this.meusDados[i] == item){
					if(i > 0){
						retornar = this.meusDados[i-1];
					}
					break;
				}
				if(i == (this.posInsercao - 1) && retornar==null){
					throw new ConjuntoVazioException();
				}
			}
		}
		return retornar;
	}

	@Override
	public Integer sucessor(Integer item) throws ConjuntoVazioException {
		Integer retornar = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		}
		else{
			for(int i = 0; i < this.posInsercao; i++){
				if(this.meusDados[i] == item){
					if(i < this.posInsercao - 1){
						retornar = this.meusDados[i+1];
					}
					break;
				}
				if (i == this.posInsercao - 1 && retornar == null){
					throw new ConjuntoVazioException();
				}
			}
		}
		return retornar;
	}

	@Override
	public int tamanho() {
		int count = 0;
		if(this.meusDados != null){
			for(Integer dado : this.meusDados){
				if(dado != null){
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public Integer buscar(Integer buscado) {
		Integer retornar = null;
		for(int i = 0; i < this.posInsercao; i++){
			if(this.meusDados[i] == (buscado)){
				retornar = buscado;
			}
		}
		return retornar;
	}

	@Override
	public Integer minimum() throws ConjuntoVazioException {
		Integer retornar = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		}
		else{
			Integer min = this.meusDados[0];
			for(int i = 1; i < this.posInsercao; i++){
				if(this.meusDados[i] < min){
					min = this.meusDados[i];
				}
			}
			retornar = min;
		}
		return retornar;
	}

	@Override
	public Integer maximum() throws ConjuntoVazioException {
		Integer retornar = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		}
		else{
			Integer max = this.meusDados[0];
			for(int i = 1; i < this.posInsercao; i++){
				if(this.meusDados[i] > max){
					max = this.meusDados[i];
				}
			}
			retornar = max;
		}
		return retornar;
	}

}
