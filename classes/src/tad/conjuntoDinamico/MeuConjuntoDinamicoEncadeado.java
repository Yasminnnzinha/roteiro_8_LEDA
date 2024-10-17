package tad.conjuntoDinamico;

import tad.listasEncadeadas.ListaDuplamenteEncadeadaImpl;
import tad.listasEncadeadas.ListaEncadeadaIF;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	// lista encadeada
	ListaEncadeadaIF<Integer> meusDados = new ListaDuplamenteEncadeadaImpl<>();

	@Override
	public void inserir(Integer item) {
//		if (!meusDados.clone()) { // Verifica se o item já está no conjunto
//			meusDados.insert(item); // Insere o item no final da lista
//		}
	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException {
//		if (tamanho() == 0) {
//			throw new ConjuntoVazioException();
//		}
//
//		if (meusDados.contem(item)) { // Verifica se o item está presente
//			meusDados.remover(item); // Remove o item da lista
//			return item; // Retorna o item removido
//		}
  		return null; // Retorna null se o item não foi encontrado
	}

	@Override
	public Integer predecessor(Integer item) {
//		if (tamanho() == 0) {
//			return null; // Retorna null se o conjunto está vazio
//		}
//
//		Integer pred = null;
//		for (Integer dado : this.meusDados) { // Percorre a lista
//			if (dado.equals(item)) {
//				return pred; // Retorna o predecessor
//			}
//			pred = dado; // Atualiza o predecessor
//		}
  		return null; // Retorna null se o predecessor não foi encontrado
	}

	@Override
	public Integer sucessor(Integer item) {
//		if (tamanho() == 0) {
//			return null; // Retorna null se o conjunto está vazio
//		}
//
//		boolean encontrouItem = false;
//		for (Integer dado : meusDados) { // Percorre a lista
//			if (encontrouItem) {
//				return dado; // Retorna o sucessor
//			}
//			if (dado.equals(item)) {
//				encontrouItem = true; // Marca que o item foi encontrado
//			}
//		}
 		return null; // Retorna null se o sucessor não foi encontrado
	}

	@Override
	public int tamanho() {
//		int cont = 0;
//		for (Integer dado : meusDados) { // Percorre a lista
//			cont++; // Conta os elementos
//		}
    	return 0;//cont; // Retorna o tamanho
	}

	@Override
	public Integer buscar(Integer item) {
//		for (Integer dado : meusDados) { // Percorre a lista
//			if (dado.equals(item)) {
//				return dado; // Retorna o item se encontrado
//			}
//		}
 		return null; // Retorna null se o item não foi encontrado
	}

	@Override
	public Integer minimum() {
//		if (tamanho() == 0) {
//			return null; // Retorna null se o conjunto está vazio
//		}
//
//		Integer min = null;
//		for (Integer dado : meusDados) { // Percorre a lista
//			if (min == null || dado < min) {
//				min = dado; // Atualiza o mínimo
//			}
//		}
 		return null;//min; // Retorna o mínimo
	}

	@Override
	public Integer maximum() {
//		if (tamanho() == 0) {
//			return null; // Retorna null se o conjunto está vazio
//		}
//
//		Integer max = null;
//		for (Integer dado : meusDados) { // Percorre a lista
//			if (max == null || dado > max) {
//				max = dado; // Atualiza o máximo
//			}
//		}
 		return null;//max; // Retorna o máximo
	}
}
