import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ArenaTech {
    private static final double ORCAMENTO = 1000.00;
    private static final double POTENCIA_W = 800.00;
    private static final double PRECO_KWH = 1.2;
    private static final double PRECO_KIT = 20.00;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            int qteParticipantes = scanner.nextInt();

            if (qteParticipantes <= 0) {
                System.out.println("Número de participantes inválido.");
                return;
            }
            System.out.println("Quantos jogadores em cada time?:");
            int qteJogadoresPorTime = scanner.nextInt();

            if (qteJogadoresPorTime <= 0){
                System.out.println("Informe uma quantidade positiva de jogadores");
                return;
            }
            System.out.println("Quantos computadores estão disponiveis?");
            int qteComputadores = scanner.nextInt();    

            if (qteComputadores <= 0){
                System.out.println("Informe uma quantidade positiva de computadores");
                return;
            }
            System.out.println ("Qual a duração do evento em horas?");
            double duração = scanner.nextDouble();

            if (Double.isFinite(duracao)
            || duracao <= 0.0
            || duracao > 168.0){
                System.out.println("INVALIDO: A duraçao deve ser maior que 0 e menor que 168 horas");
                return;
            }
            }

            System.out.print(
                "Outros custos do evento (R$, use ponto para decimais): "
            );
            double outrosCustos = scanner.nextDouble();

            if (!Double.isFinite(outrosCustos)
                    || outrosCustos < 0.0
                    || outrosCustos > 1_000_000_000.0) {
                System.out.println(
                    "Erro: informe um custo entre zero e 1 bilhao de reais."
                );
                return;
            }
            int timesCompletos =
                qteParticipantes / qteJogadoresPorTime;

            int participantesRestantes =
                qteParticipantes % qteJogadoresPorTime;

            int qteTimes = timesCompletos;

            if (participantesRestantes > 0) {
                qteTimes++;
            }
            if (qteComputadores < qteParticipantes) {
                computadoresFaltantes =
                    qteParticipantes - qteComputadores;
            }
            double consumoEnergia =
                (qteComputadores * POTENCIA_W * duracao) / 1000.0;

            double custoEnergia = consumoEnergia * PRECO_KWH;
            double custoAlimentacao = qteParticipantes * PRECO_KIT;

            double custoTotal =
                custoEnergia + custoAlimentacao + outrosCustos;

            double custoPorParticipante =
                custoTotal / qteParticipantes;

            double saldo = ORCAMENTO - custoTotal;

        
            // Relatório 

            System.out.println("\n==========ARENA TECH==========\n");

            System.out.printf("Participantes: %d%n", qteParticipantes);
            
            System.out.printf("Jogadores por time: %d%n", qteJogadoresPorTime);

            System.out.printf("Times completos: %d%n", timesCompletos);

            if (participantesRestantes > 0) {
                System.out.printf("Time incompleto: %d participante(s)%n", participantesRestantes);
            }
            System.out.printf("Computadores disponiveis: %d%n", qteComputadores);

            if (computadoresFaltantes == 0) {
                System.out.println("Infraestrutura: SUFICIENTE");
            } else {
                System.out.println("Infraestrutura: INSUFICIENTE");
                System.out.printf(
                    "Computadores faltantes: %d%n", computadoresFaltantes
                );
            }

            System.out.printf("%nDuracao: %.2f horas%n", duracao);
            System.out.printf(
                "Consumo estimado: %.2f kWh%n", consumoEnergia
            );

            if (consumoEnergia <= 20.0) {
                System.out.println("Classificacao do consumo: BAIXO");
            } else if (consumoEnergia <= 40.0) {
                System.out.println("Classificacao do consumo: MODERADO");
            } else {
                System.out.println("Classificacao do consumo: ALTO");
            }

            System.out.println("\n======= CUSTOS =======\n");

            System.out.printf("Energia: R$ %.2f%n", custoEnergia);
            System.out.printf("Alimentacao: R$ %.2f%n", custoAlimentacao);
            System.out.printf("Outros custos: R$ %.2f%n", outrosCustos);
            System.out.printf("CUSTO TOTAL: R$ %.2f%n", custoTotal);
            System.out.printf(
                "CUSTO POR PARTICIPANTE: R$ %.2f%n",
                custoPorParticipante
            );

            System.out.println("\n======= ORCAMENTO =======\n");

            System.out.printf("Orcamento disponivel: R$ %.2f%n", ORCAMENTO);
            System.out.printf("Saldo: R$ %.2f%n", saldo);

            if (custoTotal > ORCAMENTO) {
                System.out.println("Situacao: ACIMA DO ORCAMENTO");
            } else if (saldo <= ORCAMENTO * 0.05) {
                System.out.println("Situacao: NO LIMITE DO ORCAMENTO");
            } else {
                System.out.println("Situacao: DENTRO DO ORCAMENTO");
            }

        } catch (InputMismatchException e) {
            System.out.println(
                "Erro: entrada invalida. Informe um numero do tipo solicitado "
                + "e use ponto para decimais."
            );
        }
    }
}
