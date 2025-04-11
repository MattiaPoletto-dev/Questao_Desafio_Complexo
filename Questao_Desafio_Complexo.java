package D_AtividadeDesafio;
import java.util.ArrayList;
import java.util.Scanner;

/*
Q) Elabore um sistema de cadastro (use a criatividade)
   Deve ter um menu:
     1. Incluir
     2. Alterar
     3. Excluir
     4. Listar todos
     5. Listar item
     6. Sair
*/

public class Questao_Desafio_Complexo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> listaNomes = new ArrayList<>();
        ArrayList<String> listaEans = new ArrayList<>();
        ArrayList<Integer> listaQuantidades = new ArrayList<>();
        ArrayList<Double> listaPrecos = new ArrayList<>();
        
        int escolhaMenu = 0;
        while (escolhaMenu != 6) {
            System.out.println("""
                               --------------------
                                 MENU DE PRODUTOS  
                               --------------------
                               1. Incluir
                               2. Alterar
                               3. Excluir
                               4. Listar todos
                               5. Listar item
                               6. Sair
                               """);
            System.out.print("Escolha: ");
            escolhaMenu = scanner.nextInt();
            scanner.nextLine();
            
            if (escolhaMenu < 1 || escolhaMenu > 6) {
                System.out.println("Opção inválida!");
            } else {
                switch (escolhaMenu) {
                    case 1:
                        System.out.println("--------------------");
                        System.out.println(">>>>> CADASTRO <<<<<");
                        System.out.print("Nome: ");
                        String nomeProduto = scanner.nextLine();
                        
                        System.out.print("EAN: ");
                        String eanProduto = scanner.nextLine();
                        
                        int quantidadeProduto;
                        while (true) {
                            System.out.print("Quantidade: ");
                            quantidadeProduto = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (quantidadeProduto > 0) {
                                break;
                            } else {
                                System.out.println("A quantidade deve ser maior que 0!");
                            }
                        }
                        
                        double precoProduto;
                        while (true) {
                            System.out.print("Preço: R$");
                            precoProduto = scanner.nextDouble();
                            scanner.nextLine(); 
                            
                            if (precoProduto > 0) {
                                break;
                            } else {
                                System.out.println("O preço deve ser maior que 0!");
                            }
                        }
                        
                        
                        listaNomes.add(nomeProduto);
                        listaEans.add(eanProduto);
                        listaQuantidades.add(quantidadeProduto);
                        listaPrecos.add(precoProduto);
                        
                        System.out.println();
                        System.out.println("Produto cadastrado com sucesso!");
                        System.out.println();
                        break;
                        
                    case 2:
                        if (listaNomes.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado!");
                        } else {
                            System.out.println("--------------------");
                            System.out.println("Qual produto deseja mudar?");
                            for (int i = 0; i < listaNomes.size(); i++) {
                                System.out.printf("%d. %s\n",i+1,listaNomes.get(i));
                            }
                            int escolhaAlterar;
                            while (true) {
                                System.out.print("\nEscolha [0 para sair]: ");
                                escolhaAlterar = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (escolhaAlterar < 0 || escolhaAlterar > listaNomes.size()) {
                                    System.out.println("Escolha um número válido!");                                    
                                } else {
                                    break;
                                }
                            }
                            if (escolhaAlterar == 0) {
                                break;
                            }
                            
                            System.out.printf("""
                                              
                                              E o que deseja alterar do produto '%s'?
                                              1. EAN
                                              2. Quantidade
                                              3. Preço
                                              """,listaNomes.get(escolhaAlterar - 1));
                            System.out.print("Escolha: ");
                            int escolhaAlterarAtributo = scanner.nextInt();
                            scanner.nextLine();
                            
                            switch (escolhaAlterarAtributo) {
                                case 1:
                                    System.out.print("Digite o novo EAN: ");
                                    String novoEan = scanner.nextLine();
                                    listaEans.set(escolhaAlterar - 1, novoEan);
                                    
                                    System.out.println("\nEAN substituido com sucesso!\n");
                                    break;
                                case 2:
                                    int novaQuantidade;
                                    while (true) {
                                        System.out.print("Digite a nova quantidade: ");
                                        novaQuantidade = scanner.nextInt();
                                        scanner.nextLine();
                                        listaQuantidades.set(escolhaAlterar - 1, novaQuantidade);
                                        
                                        System.out.println("\nQuantidade substituida com sucesso!\n");
                                        break;
                                    }
                                    break;
                                case 3:
                                    double novoPreco;
                                    while (true) {
                                        System.out.print("Digite o novo preço: ");
                                        novoPreco = scanner.nextDouble();
                                        scanner.nextLine();
                                        listaPrecos.set(escolhaAlterar - 1, novoPreco);
                                        
                                        System.out.println("\nPreço substituido com sucesso!\n");
                                        break;
                                    }
                            }     
                        }
                        break; 
                    case 3:
                        if (listaNomes.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado!");
                        } else {
                            System.out.println("--------------------");
                            System.out.println("Qual produto deseja excluir?");
                            for (int e = 0; e < listaNomes.size(); e++) {
                                System.out.printf("%d. %s\n",e+1,listaNomes.get(e));
                            }
                            
                            int escolhaExcluir;
                            while (true) {
                                System.out.print("\nEscolha [0 para sair]: ");
                                escolhaExcluir = scanner.nextInt();

                                if (escolhaExcluir < 0 || escolhaExcluir > listaNomes.size()) {
                                    System.out.println("Escolha um número válido!");
                                } else {
                                    break;
                                }
                            }

                            if (escolhaExcluir == 0) {
                                break;
                            }
                            String nome = listaNomes.get(escolhaExcluir - 1);
                            listaNomes.remove(escolhaExcluir - 1);
                            listaEans.remove(escolhaExcluir - 1);
                            listaQuantidades.remove(escolhaExcluir - 1);
                            listaPrecos.remove(escolhaExcluir - 1);

                            System.out.printf("Produto %s removido com sucesso!\n",nome);
                        }
                        break;
                    case 4:
                        if (listaNomes.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado!");
                        } else {
                            System.out.println("--------------------");
                            for (int todos = 0; todos < listaNomes.size(); todos++) {
                            System.out.printf("""
                                              Nome      : %s
                                              EAN       : %s
                                              Quantidade: %d
                                              Preço     : %.2f
                                              """,listaNomes.get(todos),listaEans.get(todos),
                                              listaQuantidades.get(todos),listaPrecos.get(todos));
                            System.out.println("--------------------");
                            }     
                        }
                        break;
                    case 5:
                        if (listaNomes.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado!");
                        } else {
                            System.out.println("--------------------");
                            System.out.println("Qual item deseja ver?");
                            for (int itens = 0; itens < listaNomes.size(); itens++) {
                                System.out.printf("%d. %s\n",itens + 1,listaNomes.get(itens));
                            }
                            int escolhaItem;
                            while (true) {
                                System.out.print("Escolha [0 para voltar]: ");
                                escolhaItem = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (escolhaItem < 0 || escolhaItem > listaNomes.size()) {
                                    System.out.println("Escolha um número válido!");
                                } else {
                                    break;
                                }
                            }
                            if (escolhaItem == 0) {
                                break;
                            }
                            System.out.printf("""
                                              --------------------;
                                              Nome      : %s
                                              EAN       : %s
                                              Quantidade: %d
                                              Preço     : %.2f
                                              --------------------;
                                              """,listaNomes.get(escolhaItem - 1),listaEans.get(escolhaItem - 1),
                                              listaQuantidades.get(escolhaItem - 1),listaPrecos.get(escolhaItem - 1));
                            
                        }
                        break;        
                }    
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("  Sistema finalizado com sucesso!");
        System.out.println("-----------------------------------");
    }
}
