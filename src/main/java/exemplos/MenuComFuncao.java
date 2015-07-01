package exemplos;

import javax.swing.JOptionPane;

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
