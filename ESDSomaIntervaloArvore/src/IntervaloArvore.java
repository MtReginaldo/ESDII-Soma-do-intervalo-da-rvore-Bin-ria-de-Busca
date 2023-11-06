class NodeArvore {
    int valor;
    NodeArvore noEsquerdo;
    NodeArvore noDireito;

    NodeArvore(int valor) {
        this.valor = valor;
    }

    NodeArvore(int valor, NodeArvore esquerdo, NodeArvore direito) {
        this.valor = valor;
        this.noEsquerdo = esquerdo;
        this.noDireito = direito;
    }
}

public class IntervaloArvore {
    private NodeArvore raiz;

    public IntervaloArvore(NodeArvore raiz) {
        this.raiz = raiz;
    }

    public int calcularSomaIntervalo(int limiteInferior, int limiteSuperior) {
        return calcularSomaIntervalo(raiz, limiteInferior, limiteSuperior);
    }

    private int calcularSomaIntervalo(NodeArvore no, int limiteInferior, int limiteSuperior) {
        if (no == null) {
            return 0;
        }

        int soma = 0;
        if (limiteInferior <= no.valor && no.valor <= limiteSuperior) {
            soma += no.valor;
        }
        if (limiteInferior < no.valor) {
            soma += calcularSomaIntervalo(no.noEsquerdo, limiteInferior, limiteSuperior);
        }
        if (no.valor < limiteSuperior) {
            soma += calcularSomaIntervalo(no.noDireito, limiteInferior, limiteSuperior);
        }

        return soma;
    }

    public static void main(String[] args) {
        NodeArvore raiz = new NodeArvore(10);
        raiz.noEsquerdo = new NodeArvore(5);
        raiz.noEsquerdo.noEsquerdo = new NodeArvore(3);
        raiz.noEsquerdo.noEsquerdo.noEsquerdo = new NodeArvore(1);
        raiz.noEsquerdo.noDireito = new NodeArvore(7);
        raiz.noEsquerdo.noDireito.noEsquerdo = new NodeArvore(6);
        raiz.noDireito = new NodeArvore(15);
        raiz.noDireito.noEsquerdo = new NodeArvore(13);
        raiz.noDireito.noDireito = new NodeArvore(18);

        IntervaloArvore arvore = new IntervaloArvore(raiz);
        System.out.println(arvore.calcularSomaIntervalo(6, 10));
    }
}
