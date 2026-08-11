package projetoa3;
import javax.swing.JOptionPane;

public class ProjetoA3 {

    public static void main(String[] args) {

        String nome;
        int idade;
        double peso;
        double altura;
        int sexo;
        double imc;
        int ultraProcessado;
        
        String classificacaoIMC;
        String risco;
        String recomendacao;

        int objetivo;
        int nivelAtividade;
        
        JOptionPane.showMessageDialog(
        null,
        "Este sistema fornece apenas estimativas.\n"
        + "Consulte um nutricionista para orientações profissionais."
);

        nome = lerNome();
        idade = lerIdade();
        peso = lerPeso();
        altura = lerAltura();
        sexo = lerSexo();
        
        // IMC
        imc = calcularIMC(peso, altura);
        classificacaoIMC = classificarIMC(imc);
        risco = riscoIMC(imc);
        recomendacao = recomendacaoIMC(imc);
        
        JOptionPane.showMessageDialog(
        null,
        "===== RESULTADO IMC =====\n\n"
        + "IMC: " + String.format("%.2f", imc) + "\n"
        + "Classificação: " + classificacaoIMC + "\n"
        + "Risco: " + risco + "\n\n"
        + recomendacao
        );

        objetivo = lerObjetivo();
        
        JOptionPane.showMessageDialog(
        null,
        "O QUE SÃO OS NÍVEIS DE ATIVIDADE\n\n"
        + "1 - Sedentário:\n"
        + "Pouco ou nenhum exercício.\n\n"

        + "2 - Moderado:\n"
        + "Exercícios de 3 a 5 vezes por semana.\n\n"

        + "3 - Ativo:\n"
        + "Treinos intensos ou atividade física frequente."
);
        nivelAtividade = lerNivelAtividade();
        ultraProcessado = lerConsumoUltraProcessado();
        
        

        double tmb;
        double gastoCalorico;
        double calorias;

        double proteina;
        double gordura;
        double carbo;
        
        // TMB e calorias
        tmb = calcularTMB(peso, altura, idade, sexo);
        gastoCalorico = calcularGastoCalorico(tmb, nivelAtividade);
        calorias = calcularCalorias(gastoCalorico, objetivo);

        // Macronutrientes
        proteina = calcularProteina(peso);
        gordura = calcularGordura(peso);
        carbo = calcularCarbo(calorias, proteina, gordura);
        

        if (carbo < 0) {
            carbo = 0;
        }

        String mensagem = "";

        mensagem += "Nome: " + nome + "\n";
        mensagem += "Idade: " + idade + " anos\n";
        mensagem += "Peso: " + peso + " kg\n";
        mensagem += "Altura: " + altura + " m\n";

        if (sexo == 1) {

            mensagem += "Sexo: Masculino\n";

        } else {

            mensagem += "Sexo: Feminino\n";
        }

        if (objetivo == 1) {

            mensagem += "Objetivo: Emagrecer\n";

        } else if (objetivo == 2) {

            mensagem += "Objetivo: Manter\n";

        } else {

            mensagem += "Objetivo: Ganhar massa\n";
        }

        if (nivelAtividade == 1) {

            mensagem += "Nível de atividade: Sedentário\n";

        } else if (nivelAtividade == 2) {

            mensagem += "Nível de atividade: Moderado\n";

        } else {

            mensagem += "Nível de atividade: Ativo\n";
        }
        mensagem += "\n\n===== RESULTADOS =====\n";

        mensagem += "IMC: " + String.format("%.2f", imc) + "\n";
        mensagem += "Classificação: " + classificacaoIMC + "\n";
        mensagem += "Risco: " + risco + "\n\n";

        mensagem += "TMB: " + String.format("%.2f", tmb) + " kcal\n";
        mensagem += "Gasto calórico diário: "
                + String.format("%.2f", gastoCalorico) + " kcal\n";

        mensagem += "Calorias recomendadas: "
                + String.format("%.2f", calorias) + " kcal\n\n";

        mensagem += "Proteína: "
                + String.format("%.2f", proteina) + " g\n";

        mensagem += "Gordura: "
                + String.format("%.2f", gordura) + " g\n";

        mensagem += "Carboidratos: "
                + String.format("%.2f", carbo) + " g\n";

        mensagem += analisarHabitos(ultraProcessado, nivelAtividade);
        String alimentos = exemplosAlimentos();
        
        JOptionPane.showMessageDialog(
                null,
                mensagem
        );
        JOptionPane.showMessageDialog(
                null,
                alimentos
        );
    }
    
    public static String lerNome() {

        String nome;

        do {

            nome = JOptionPane.showInputDialog(
                    "Digite seu nome:"
            );

        } while (nome == null || nome.trim().isEmpty());

        return nome;
    }

    public static int lerIdade() {

        int idade;

        do {

            idade = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Digite sua idade:"
                    )
            );

            if (idade <= 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "Idade inválida!"
                );
            }

        } while (idade <= 0);

        return idade;
    }

    public static double lerPeso() {

        double peso;

        do {

            peso = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Digite seu peso em kg usando ponto.\nExemplo: 75.45:"
                    )
            );

            if (peso <= 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "Peso inválido!"
                );
            }

        } while (peso <= 0);

        return peso;
    }

    public static double lerAltura() {

        double altura;

        do {

            altura = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Digite sua altura em metros usando ponto.\nExemplo: 1.75:"
                    )
            );

            if (altura <= 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "Altura inválida!"
                );
            }

        } while (altura <= 0);

        return altura;
    }

    public static int lerSexo() {

        int sexo;

        sexo = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Sexo biológico (digite 1 ou 2)\n"
                        + "1 - Masculino\n"
                        + "2 - Feminino"
                )
        );

        while (sexo != 1 && sexo != 2) {

            JOptionPane.showMessageDialog(
                    null,
                    "Opção inválida!"
            );

            sexo = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "1 - Masculino\n"
                            + "2 - Feminino"
                    )
            );
        }

        return sexo;
    }

    public static int lerObjetivo() {

        int objetivo;

        objetivo = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Objetivo\n"
                        + "1 - Emagrecer\n"
                        + "2 - Manter\n"
                        + "3 - Ganhar massa"
                )
        );

        while (objetivo < 1 || objetivo > 3) {

            JOptionPane.showMessageDialog(
                    null,
                    "Opção inválida!"
            );

            objetivo = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "1 - Emagrecer\n"
                            + "2 - Manter\n"
                            + "3 - Ganhar massa"
                    )
            );
        }

        return objetivo;
    }

    public static int lerNivelAtividade() {

        int nivelAtividade;

        nivelAtividade = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Nível de atividade\n"
                        + "1 - Sedentário\n"
                        + "2 - Moderado\n"
                        + "3 - Ativo"
                )
        );

        while (nivelAtividade < 1 || nivelAtividade > 3) {

            JOptionPane.showMessageDialog(
                    null,
                    "Opção inválida!"
            );

            nivelAtividade = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "1 - Sedentário\n"
                            + "2 - Moderado\n"
                            + "3 - Ativo"
                    )
            );
        }

        return nivelAtividade;
    }
    
    public static String recomendacaoIMC(double imc) {

    if (imc < 18.5) {

        return "Recomendação: buscar ganho de peso com acompanhamento profissional.";

    } else if (imc < 25) {

        return "Recomendação: manter hábitos saudáveis.";

    } else {

        return "Recomendação: considerar emagrecimento com dieta e exercícios.";
    }
}
    
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau 1";
        } else if (imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public static String riscoIMC(double imc) {
        if (imc < 18.5) {
            return "Risco de desnutrição";
        } else if (imc < 25) {
            return "Baixo risco";
        } else if (imc < 30) {
            return "Risco moderado";
        } else if (imc < 35) {
            return "Risco alto";
        } else if (imc < 40) {
            return "Risco muito alto";
        } else {
            return "Risco extremamente alto";
        }
    }
    public static double calcularTMB(double peso, double altura, int idade, int sexo) {

        double alturaCm = altura * 100;

        double tmb;

        if (sexo == 1) {

            tmb = 88.36 + (13.4 * peso) + (4.8 * alturaCm) - (5.7 * idade);

        } else {

            tmb = 447.6 + (9.2 * peso) + (3.1 * alturaCm) - (4.3 * idade);
        }

        return tmb;
    }
    
    public static double calcularGastoCalorico(double tmb, int nivelAtividade) {

    double fatorAtividade = 0;

    if (nivelAtividade == 1) {

        fatorAtividade = 1.2;

    } else if (nivelAtividade == 2) {

        fatorAtividade = 1.55;

    } else {

        fatorAtividade = 1.725;
    }

    return tmb * fatorAtividade;
}

    public static double calcularCalorias(double gastoCalorico, int objetivo) {

    if (objetivo == 1) {

        return gastoCalorico - 500;

    } else if (objetivo == 2) {

        return gastoCalorico;

    } else {

        return gastoCalorico + 500;
    }
}
    
     public static double calcularProteina(double peso) {
            double proteina = peso * 2;
            return proteina;
        }

        public static double calcularGordura(double peso) {
            double gordura = peso * 0.8;
            return gordura;
        }

        public static double calcularCarbo(double calorias, double proteina, double gordura) {

            double caloriasProteina = proteina * 4;
            double caloriasGordura = gordura * 9;

            double caloriasRestantes = calorias - (caloriasProteina + caloriasGordura);

            double carbo = caloriasRestantes / 4;

            return carbo;
        }

        public static int lerConsumoUltraProcessado() {

            int ultraProcessado;

            ultraProcessado = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Quantas vezes por semana você consome fast food\n"
                            + "ou alimentos ultraprocessados?\n\n"

                            + "0 - Nunca\n"
                            + "1 - 1 a 2 vezes\n"
                            + "2 - 3 a 5 vezes\n"
                            + "3 - Quase todos os dias"
                    )
            );

            while (ultraProcessado < 0 || ultraProcessado > 3) {

                JOptionPane.showMessageDialog(
                        null,
                        "Opção inválida!"
                );

                ultraProcessado = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "0 - Nunca\n"
                                + "1 - 1 a 2 vezes\n"
                                + "2 - 3 a 5 vezes\n"
                                + "3 - Quase todos os dias"
                        )
                );
            }

            return ultraProcessado;
        }


        public static String analisarHabitos(
          int ultraprocessado,
          int nivelAtividade
        ) {

            String mensagem = "===== ANÁLISE DOS HÁBITOS =====\n\n";

            // atividade física
            if (nivelAtividade == 1) {

                mensagem += "• Seu nível de atividade física é baixo.\n";
                mensagem += "  Tente incluir mais exercícios na rotina.\n\n";

            } else if (nivelAtividade == 2) {

                mensagem += "• Seu nível de atividade física é moderado.\n\n";

            } else {

                mensagem += "• Bom nível de atividade física.\n\n";
            }

            // alimentação
            if (ultraprocessado == 3) {

                mensagem += "• Alto consumo de ultraprocessados.\n";
                mensagem += "  Reduza fast food e refrigerantes.\n\n";

            } else if (ultraprocessado == 2) {

                mensagem += "• Consumo moderado de ultraprocessados.\n";
                mensagem += "  Tente melhorar a qualidade da alimentação.\n\n";

            } else {

                mensagem += "• Bons hábitos alimentares.\n\n";
            }

            return mensagem;
        }

        public static String exemplosAlimentos() {

            String alimentos = "";

            alimentos += "===== EXEMPLOS DE ALIMENTOS =====\n\n";

            alimentos += "100g de frango:\n";
            alimentos += "Proteína: 31g\n\n";

            alimentos += "100g de arroz:\n";
            alimentos += "Carboidratos: 28g\n\n";

            alimentos += "1 ovo:\n";
            alimentos += "Proteína: 6g\n";
            alimentos += "Gordura: 5g\n\n";

            alimentos += "1 pão francês:\n";
            alimentos += "Carboidratos: 25g\n\n";

            alimentos += "1 colher de azeite:\n";
            alimentos += "Gordura: 13g\n";

            return alimentos;
        }
        

}

