# 1. Funções e Procedimentos

Neste capítulo, estudaremos como modularizar os nossos programas, criando nossas
próprias instruções.


## 1.1 Motivação

Veja o programa abaixo. Ele exibe um menu com as seguintes funcionalidades:
1) Calcular a média; 2) Verificar aprovação; 3) Pontuação mínima para a final;
0) Sair.

```java
public class Menu {
	public static void main(String[] args) {
		double nota1, nota2, media, notaFinal;
		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane
					.showInputDialog("Digite a opção:\n"
							+ "1) Calcular a média\n"
							+ "2) Verificar aprovação\n"
							+ "3) Pontuação mínima para a final\n"
							+ "0) Sair\n"));
			switch (opcao) {
			case 1:
				nota1 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 1a nota"));
				nota2 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 2a nota"));
				media = (nota1 + nota2) / 2;
				JOptionPane.showMessageDialog(null, "Média: " + media);
				break;
			case 2:
				nota1 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 1a nota"));
				nota2 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 2a nota"));
				media = (nota1 + nota2) / 2;

				if (media >= 6.0) {
					JOptionPane.showMessageDialog(null,
							"O estudante está aprovado");
				} else {
					JOptionPane.showMessageDialog(null,
							"O estudante está reprovado");
				}
				break;
			case 3:
				nota1 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 1a nota"));
				nota2 = Double.parseDouble(JOptionPane
						.showInputDialog("Digite a 2a nota"));
				media = (nota1 + nota2) / 2;
				notaFinal = 12 - media;
				JOptionPane.showMessageDialog(null,
						"Sua nota mínima na final deverá ser " + notaFinal);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while (opcao != 0);
	}
}
```
Observe, no código acima, as instruções que estão em `case 1:`, `case 2:` e em
`case 3:`. Viu alguma semelhança entre elas? Não? Olhe de novo, observando agora
se há instruções que se repetem. Se você foi atencioso, notou que há uma
repetição nas instruções abaixo:

```java
nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1a nota"));
nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2a nota"));
media = (nota1 + nota2) / 2;
```
que vão solicitar as notas do usuário e calcular a média destas notas.

Agora, imagine que a escola onde este estudante estuda, mudou a forma de
avaliação e agora são utilizadas três notas, ao invés de duas, para calcular a
média. Você teria então que alterar o código de cálculo da média TRÊS VEZES: no
`case 1:`, `case 2:` e no `case 3:`. Ficando assim:

```java
nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1a nota"));
nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2a nota"));
nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3a nota"));
media = (nota1 + nota2 + nota3) / 3;
```

Mas, imagino aqui se você estaria se perguntando se seria possível evitar a
repetição destas instruções, já que elas fazem a mesma coisa. E a resposta para
isto é o conceito de **função**.

**Importante:** Observe que uma função é muito parecida com um programa: ela
recebe dados, processa estes dados e retorna o resultado deste processamento.


## 1.2 Definição

Segundo a [Wikipedia][1]:

> Uma **função** consiste em uma porção de código que resolve um problema muito
específico, parte de um problema maior (a aplicação final). Uma função
geralmente "recebe" dados, processa estes dados e "retorna" o resultado deste
processamento.

Já um **procedimento** é uma função que não retorna nenhum resultado.


## 1.3 Sintaxe

A *declaração* de uma função obedece a seguinte sintaxe:

```java
public static TipoDoRetorno identificador(Tipo1 param1, Tipo2 param2, ..., TipoN paramN) {
  Instrução1;
  Instrução2;
  ...
  InstruçãoN;

  return valorOuVariavel;
}
```
Em que:
* `public static`:  indica que está se construindo uma função ou procedimento;
* `TipoDoRetorno`: indica qual o tipo do dado do valor que está sendo retornado
(ex.: `int`, `double`, `boolean`, `char`, `String`, etc.);
* `identificador`: indica como será o *"nome"* desta função;
* `Tipo1`, `Tipo2`, ..., `TipoN`: são os tipos dos parâmetros (ex.: `int`,
  `double`, `boolean`, `char`, `String`, etc.);
* `param1`, `param2`, ..., `paramN`: são os identificadores dos parâmetros
(ex.: `idade`, `quantidade`, `nome`, `valor`, etc.);
* `return valorOuVariavel`: indica que a função está retornando algum valor
(ex.: `10`, `true`, `'A'`, `"Sim"`, `7.5`, etc.) ou alguma variável que possui
algum valor.

Observações:
* Os parâmetros são opcionais.


Para *declarar* um procedimento utiliza-se uma forma semelhante, com duas
diferenças:
* O `TipoDoRetorno` será `void`, para indicar que não há nenhum valor a
retornar;
* Não há um `return valorOuVariavel`, pois não há o que retornar.


## 1.4 Exemplos

1. Desenvolva uma função que solicite ao usuário informar duas notas e retornar
a média destas notas.

  ```java
  public static double calculaMedia() {
    double nota1, nota2, media;

    nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1a nota"));
    nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2a nota"));
    media = (nota1 + nota2) / 2;

    return media;
  }
  ```
  Em que:
  * `public static`:  indica que está se construindo uma função ou procedimento;
  * `double`: indica que a função está retornando um double, que é o tipo de dado
  da `media`;
  * `calculaMedia`: indica o *"nome"* da função, que é a forma como a
  referenciamos ao longo do programa;
  * Esta função não possui parâmetros. Por esta razão, após o nome temos um `()`;
  * Dentro da função (no seu *corpo*) há instruções para solicitar as duas notas
  e calcular a média;
  * `return media`: retorna o valor da média que foi calculada.

2. No salário de um funcionário incide um desconto de 20% com relação a
impostos. Desenvolva uma função que calcule o salário líquido deste funcionário.

  Como já sabemos, 20% -> 20/100 -> 0.20. Então podemos escrever:

  ```java
  public static double calculaSalario(double salario) {
    double impostos, salarioLiquido;

    impostos = salario * 0.20;
    salarioLiquido = salario - impostos;

    return salarioLiquido;
  }
  ```
  Em que:
  * `public static`:  indica que está se construindo uma função ou procedimento;
  * `double`: indica que a função está retornando um double, que é o tipo de dado
  da `media`;
  * `calculaSalario`: indica o *"nome"* da função, que é a forma como a
  referenciamos ao longo do programa;
  * `(double salario)`: é um parâmetro do tipo double chamado salário. É por
  este parâmetro que passamos o valor do salário do funcionário para a função
  para que esta calcule o salário líquido;
  * Dentro da função (no seu *corpo*) há instruções para calcular o salário
  líquido do funcionário, que é o salario menos o valor referente aos impostos
  (20%);
  * `return media`: retorna o valor da média que foi calculada.


## 1.5 Aplicando o Conceito de Função na Motivação

Agora que conhecemos a motivação, definição e sintaxe de uma função, podemos
reescrever o programa apresentado na [Motivação](#11-motivação).

Primeiramente, vamos escrever uma função, na qual chamaremos de
`calculaMedia()`, que deverá solicitar ao usuário as duas notas e retorna a
média destas notas. Depois vamos substituir as instruções pela função recém
criada, ficando assim:

```java
public class MenuComFuncao {
	public static double calculaMedia() {
		double nota1, nota2, media;

		nota1 = Double.parseDouble(JOptionPane
				.showInputDialog("Digite a 1a nota"));
		nota2 = Double.parseDouble(JOptionPane
				.showInputDialog("Digite a 2a nota"));
		media = (nota1 + nota2) / 2;

		return media;
	}

	public static void main(String[] args) {
		double media, notaFinal;
		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane
					.showInputDialog("Digite a opção:\n"
							+ "1) Calcular a média\n"
							+ "2) Verificar aprovação\n"
							+ "3) Pontuação mínima para a final\n"
							+ "0) Sair\n"));
			switch (opcao) {
			case 1:
				media = calculaMedia();
				JOptionPane.showMessageDialog(null, "Média: " + media);
				break;
			case 2:
				media = calculaMedia();

				if (media >= 6.0) {
					JOptionPane.showMessageDialog(null,
							"O estudante está aprovado");
				} else {
					JOptionPane.showMessageDialog(null,
							"O estudante está reprovado");
				}
				break;
			case 3:
				media = calculaMedia();
				notaFinal = 12 - media;
				JOptionPane.showMessageDialog(null,
						"Sua nota mínima na final deverá ser " + notaFinal);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while (opcao != 0);
	}
}
```


## 1.6 Vantagens e Desvantagens

A utilização de funções ou procedimentos em programas traz diversas vantagens e
desvantagens, a saber:

### Vantagens

* Melhora a manutenabilidade do programa
  * diminui a quantidade de código duplicado;
  * divide o programa em partes menores, que são mais fáceis de entender;
  * esconde os detalhes de implementação;
  * ao se efetuar alguma melhoria (inclusive correções) na função, esta mudança
  é propagada para todo(s) o(s) programa(s);
  * pode ser reaproveitada em outras partes e em outros programas;
* Menor utilização da memória RAM
  * o programa em si é menor;
  * as variáveis são reutilizadas (variáveis locais);
* Possibilidade de utilizar *funções recursivas*, que facilitam a escrita de
certos algoritmos.

### Desvantagens

* Ter que aprender para que serve as novas instruções;
  * a utilização de novas funções acabam gerando quase uma nova "linguagem";
  * mas, se bem utilizado, pode ser bom!
* As chamadas das funções podem introduzir maior complexidade ao código;
  * uma função, que chama outra função, que chama outra função, que chama...
* Consome mais recursos (CPU e memória RAM).


## 1.7 Exercícios

1. [FuncaoMaiorDeDois] Desenvolva um programa que contenha uma função que receba
dois números inteiros como parâmetro e retorne o maior dos dois números. A
seguir, desenvolva um código no procedimento `main()` que solicite ao usuário
que informe dois números inteiros e, utilizando a função criada, mostre na tela
se o número informado é o maior dos dois.

2. [FuncaoEhPar] Desenvolva um programa que contenha uma função que receba um
número inteiro como parâmetro e retorne `true` se o número for par ou `false` se
o número for ímpar. A seguir, desenvolva um código no procedimento `main()` que
solicite ao usuário que informe um número inteiro e, utilizando a função criada,
mostre na tela se o número informado é par ou ímpar.

3. [FuncaoSomaTresNumeros] Desenvolva um programa que contenha uma função que
receba três números inteiros como parâmetros e retorne a soma destes três
números. Depois desenvolva um código no procedimento `main()` que solicite ao
usuário que informe três números inteiros e, utilizando a função criada, mostre
na tela o resultado obtido.

4. [FuncaoPositivoNegativoZero] Desenvolva um programa que contenha uma função
que receba um número inteiro como parâmetro e retorne o caractere 'P' se o
número passado for positivo, 'N' se for negativo e 'O' se for zero. A seguir,
desenvolva um código no procedimento `main()` que solicite ao usuário que
informe um número inteiro e, utilizando a função criada, mostre na tela o
resultado obtido.

5. [FuncaoMaiorDeTres] Desenvolva um programa que contenha uma função que receba
três números inteiros como parâmetro e retorne o maior dos três números. A
seguir, desenvolva um código no procedimento `main()` que solicite ao usuário
que informe três números inteiros e, utilizando a função criada, mostre na tela
se o número informado é o maior dos três.

6. [FuncaoEhPrimo] Um número natural é dito *primo* se este possui apenas dois
divisores diferentes: o 1 e ele mesmo. De posse desta informação, desenvolva um
programa que contenha uma função que receba um número inteiro como parâmetro e
retorne `true` se o número for primo ou `false` se o número não for primo. A
seguir, desenvolva um código no procedimento `main()` que solicite ao usuário
que informe um número inteiro, e utilizando a função criada, mostre na tela se o
número informado é primo ou não.

7. [FuncaoContaDigitos] Desenvolva um programa que contenha uma função que
receba um número inteiro como parâmetro e retorne a quantidade de dígitos deste
número. Por exemplo, se for passado o número 1243 para esta função, ela deve
retornar 4. A seguir, desenvolva um código no procedimento `main()` que solicite
ao usuário que informe um número inteiro, passe este número para a função e
mostre na tela se a quantidade de dígitos confere com o número informado.

8. [FuncaoNumeroReverso] Desenvolva um programa que contenha uma função que
receba um número inteiro como parâmetro e retorne o *inverso* do número passado.
Por exemplo, se for passado o número 123 para a função, esta deve retornar o
valor 321. A seguir, desenvolva um código no procedimento `main()` que solicite
ao usuário que informe um número inteiro e, utilizando a função criada, mostre
na tela o número informado invertido.

9. [FuncaoFatorial] Um número natural *n*, representado por *n!*, é definido
como o produto de todos os inteiros positivos menores ou iguais a *n*. Por
exemplo, 5! = 5 . 4 . 3 . 2 . 1 = 120. Além disso, também por definição, 0! = 1.
De posse destas informações, desenvolva uma função que receba como parâmetro um
número inteiro *n* e retorne como resposta o fatorial deste número. A seguir,
desenvolva um código no procedimento `main()` que solicite ao usuário que
informe um número inteiro e, utilizando a função criada, mostre na tela o
resultado.

10.	[FuncaoCalculaPrestacaoAtrasada] De acordo com a fórmula "prestação = valor +
(valor x taxa/100 x tempo), desenvolva um programa que contenha uma função que
receba o valor a ser pago, a taxa e o tempo e retorne o valor da prestação a ser
paga. A seguir, desenvolva um código no procedimento `main()` que solicite ao
usuário que informe o valor a ser pago, a taxa e o tempo e, utilizando a função
criada, mostre na tela qual o valor da prestação.

11. [FuncaoConversaoDeMoedas] Desenvolva um programa que contenha uma função que
permita uma pessoa converter uma quantia em dólares (USD) para reais (RBL), dado
que esta função deverá receber a quantia em dólares e a cotação e retornar o
valor em reais. A seguir, desenvolva um código no procedimento `main()` que
solicite ao usuário que informe a quantia a ser convertida e a cotação e,
utilizando a função criada, mostre na tela o valor em reais.

12. [FuncaoCalculaTempoDeDownload] Desenvolva um programa que contenha uma
função que receba o tamanho de um arquivo (em MiB) e a velocidade do link de
Internet (em Mbps) e retorne o tempo aproximado (em minutos) de download deste
arquivo. A seguir, desenvolva um código no procedimento `main()` que solicite ao
usuário que informe o tamanho de um arquivo qualquer, a velocidade do link de
Internet e, utilizando a função criada, mostre na tela quanto tempo levará para
realizar o download. **Observação: 1 Byte possui 8 bits; 1 MiB possui 1.048.576
Bytes; 1Mbps são 1.000.000 de bits por segundo.**

13. [FuncaoGasolinaOuAlcool] Com o surgimento dos carros bicombustíveis é
possível, de acordo com o custo na bomba, escolher qual combustível utilizar na
hora de abastecer. Em geral é mais econômico abastecer o veículo com álcool
quando o preço do litro for inferior a 70% do valor do litro da gasolina.
Sabendo desta informação, desenvolva um programa  que contenha uma função que
receba o preço da gasolina e do álcool e retorne como resposta qual combustível
é mais econômico na hora de abastecer. A seguir, desenvolva um código no
procedimento `main()` que solicite ao usuário que informe o preço do litro do
álcool e da gasolina e, utilizando a função criada, mostre na tela com qual o
combustível ele deve abastecer.

14. [FuncaoCalculaPreco] Uma loja de revenda de computadores compra um
computador de uma fábrica por um determinado preço. Ao revender este computador,
esta loja precisa acrescentar ao preço de venda 23% referente ao ICMS. De posse
deste valor, acrescentará ainda 15% referente ao lucro da loja e, em cima deste
novo valor, 3% referente à comissão do vendedor. Com base nestas informações,
desenvolva um programa que contenha uma função que receba o preço de fábrica e
retorne o preço de revenda. A seguir, desenvolva um código no procedimento
`main()` que solicite ao usuário que informe um preço qualquer de fábrica e,
utilizando a função criada, mostre na tela o preço de revenda.

15. [FuncaoPagamentoDeBoletoAtrasado] Em um determinado boleto de pagamento
lê-se “Em caso de atraso, cobrar multa de 5% do valor do boleto, acrescido de R$
0,70 por dia de atraso”. De posse desta informação, desenvolva um programa que
contenha uma função que receba o valor do boleto e retorne o valor total a ser
pago. A seguir, desenvolva um código no procedimento `main()` que solicite ao
usuário que informe um valor qualquer de boleto e, utilizando a função criada,
mostre na tela o valor total a ser pago.

16. [FuncaoCalculaPreçoCombustivel] Um posto está vendendo combustíveis com a
seguinte tabela de descontos:
<table>
  <tr>
    <th>Combutível</th>  
    <th>Preço</th>  
    <th>Descontos</th>  
  </tr>
  <tr>
    <td>Álcool</td>
    <td>R$ 3,07</td>
    <td>
      até 20 litros, desconto de 3% por litro<br/>
      acima de 20 litros, desconto de 5% por litro
    </td>
  </tr>
  <tr>
    <td>Gasolina</td>
    <td>R$ 2,75</td>
    <td>
      até 20 litros, desconto de 4% por litro<br/>
      acima de 20 litros, desconto de 6% por litro
    </td>
  </tr>
</table>
De posse destas informações, escreva um programa que contenha uma função que
receba o tipo de combustível e a quantidade de combustível e retorne o valor
total a ser pago. A seguir, desenvolva um código no procedimento `main()` que
solicite ao usuário que informe o tipo de combutível e a quantidade de
combustível e, utilizando a função criada, mostre na tela o valor total a ser
pago.

17. [FuncaoCalculaTotalDeCopias] Em uma banca de fotocópias existe a seguinte
tabela de preços:
<table>
  <tr>
    <th>Número de Cópias</th>  
    <th>Preço por Cópia</th>  
  </tr>
  <tr>
    <td>De 1 a 100</td>
    <td>R$ 0,10</td>
  </tr>
  <tr>
    <td>De 101 a 200</td>
    <td>R$ 0,09</td>
  </tr>
  <tr>
    <td>De 201 a 250</td>
    <td>R$ 0,08</td>
  </tr>
  <tr>
    <td>De 251 a 350</td>
    <td>R$ 0,06</td>
  </tr>
  <tr>
    <td>Acima de 350</td>
    <td>R$ 0,05</td>
  </tr>  
</table>
De posse destas informações, escreva um programa que contenha uma função que
receba a quantidade de cópias e retorne o valor total a ser pago. A seguir,
desenvolva um código no procedimento `main()` que solicite ao usuário que
informe a quantidade de cópias e, utilizando a função criada, mostre na tela o
valor total a ser pago.

18. [FuncaoCalculaVolumeEsfera]  Desenvolva um programa que contenha uma função
que receba o diâmetro de uma esfera e retorne o volume da mesma. A seguir,
desenvolva um código no procedimento `main()` que solicite ao usuário que
informe o diâmetro de uma esfera qualquer e, utilizando a função criada, mostre
na tela o volume desta esfera.

19. [FuncaoCalculaVolumeCaixaDeAguaRetagular]  Desenvolva um programa que
contenha uma função que receba as medidas de uma caixa d' água retangular e
retorne o volume da mesma. A seguir, desenvolva um código no procedimento
`main()` que solicite ao usuário que informe as medidas de uma caixa d' água
rentangular qualquer e, utilizando a função criada, mostre na tela o volume
desta caixa.

20. [FuncaoCalculaVolumeCaixaDeAguaCilindrica]  Desenvolva um programa que
contenha uma função que receba as medidas de uma caixa d' água cilíndrica e
retorne o volume da mesma. A seguir, desenvolva um código no procedimento
`main()` que solicite ao usuário que informe as medidas de uma caixa d' água
cilíndrica qualquer e, utilizando a função criada, mostre na tela o volume desta
caixa.

21. [NumerosPrimosEntreDoisNumeros] Um número natural é dito *primo* se este
possui apenas dois divisores diferentes: o 1 e ele mesmo. De posse desta
informação, desenvolva um programa que contenha *duas* funções:<br/>
  a) uma que informe se o número é primo ou não;<br/>
  b) outra que dados dois números inteiros, retorne todos os números primos
  entre estes números.<br/>
A função (b) deverá utilizar a função (a). Em seguida desenvolva um código no
procedimento `main()` que solicite ao usuário que informe dois números inteiros,
e utilizando a função (b) criada, mostre na tela todos os números primos entre
os números informados.

22. [FuncaoEhPerfeito] Um número natural *n* é dito perfeito se este for igual à
soma de seus divisores positivos diferentes de *n*. Exemplo: se n = 6, este será
perfeito, pois os números 1, 2 e 3 dividem o número 6 e a soma deles (1 + 2 + 3)
é igual a 6. De posse desta informação, desenvolva um programa que contenha uma
função que receba um número n e retorne se este número é perfeito ou não. A
seguir, desenvolva um código no procedimento `main()` que solicite ao usuário
que informe um número qualquer e, utilizando a função criada, mostre na tela se
este número é perfeito ou não.

23. [NumerosPerfeitosEntreDoisNumeros] Um número natural *n* é dito perfeito se
este for igual à soma de seus divisores positivos diferentes de *n*. Exemplo: se
n = 6, este será perfeito, pois os números 1, 2 e 3 dividem o número 6 e a soma
deles (1 + 2 + 3) é igual a 6. De posse desta informação, desenvolva um programa
que contenha duas funções:<br/>
  a) uma que informe se o número é perfeito ou não;<br/>
  b) outra que dados dois números inteiros, retorne todos os números perfeitos
  entre estes números.<br/>
A função (b) deverá utilizar a função (a). Em seguida desenvolva um código no
procedimento `main()` que solicite ao usuário que informe dois números inteiros,
e utilizando a função (b) criada, mostre na tela todos os números perfeitos
entre os números informados.

24. [FuncaoCalculaTotalDoSalario] Para estimular as vendas por parte dos seus
vendedores, uma revenda de pneus da cidade está oferecendo o seguinte estímulo:
se um vendedor, durante o mês, vender até 15 pneus, ganhará um bônus de 6% do
salário; se vender entre 16 a 25 pneus, ganhará um bônus de 9% do salário, se
vender entre 26 e 45 pneus, ganhará um bônus de 16% do salário e se vender acima
de 45 pneus, ganhará, além de um bônus de 21% do salário, mais R$ 320,00.  De
posse desta informação, desenvolva um programa que contenha uma função que
receba o salário do vendedor, a quantidade de pneus vendidas e retorne o valor
total do salário a ser pago a este vendedor. Também desenvolva um código no
procedimento `main()` que solite que ao usuário que informe utilizando a
função criada, mostre na tela quanto ele irá ganhar no final do mês.


## 1.8 Referências

[1]: https://pt.wikipedia.org/wiki/Sub-rotina "Wikipedia"
