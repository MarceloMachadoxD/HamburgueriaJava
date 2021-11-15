import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        try {

            String pedido = "x-salada,+cebola,+bacon";
            Boolean invalido = false;

            String[] itensDoPedido = pedido.toLowerCase().split(",");

            //verificar duplicidade de itens dentro do pedido
            for (int i = 0; i < itensDoPedido.length; i++) {
                for (int j = 0; j < itensDoPedido.length; j++) {
                    if (itensDoPedido[i].equals(itensDoPedido[j]) && i != j) {
                        invalido = true;
                    }
                }
            }


            List<String> lanches = new ArrayList<>();
            lanches.add("x-burguer");
            lanches.add("x-salada");
            lanches.add("x-bacon");
            lanches.add("x-tudo");


            //verifica se o lanche passado é valido
            if (!lanches.contains(itensDoPedido[0])) {
                invalido = false;
            }


            List<String> avulso = new ArrayList<>();
            avulso.add("bacon");
            avulso.add("tomate");
            avulso.add("cebola");
            avulso.add("picles");

            //verifica se os adicionais passados são validos
            for (int i = 1; i < itensDoPedido.length ; i++) {
                if  (!avulso.contains(itensDoPedido[i].substring(1))){
                    invalido = true;
                }
            }

            //monta os lanches
            List<String> xburguer = new ArrayList<>();
            xburguer.add("pao");
            xburguer.add("queijo");
            xburguer.add("hamburguer");
            xburguer.add("maionese");

            List<String> xsalada = new ArrayList<>();
            xsalada.add("pao");
            xsalada.add("queijo");
            xsalada.add("hamburguer");
            xsalada.add("tomate");
            xsalada.add("cebola");
            xsalada.add("maionese");

            List<String> xbacon = new ArrayList<>();
            xbacon.add("pao");
            xbacon.add("queijo");
            xbacon.add("hamburguer");
            xbacon.add("bacon");
            xbacon.add("maionese");

            List<String> xtudo = new ArrayList<>();
            xtudo.add("pao");
            xtudo.add("queijo");
            xtudo.add("hamburguer");
            xtudo.add("bacon");
            xtudo.add("tomate");
            xtudo.add("cebola");
            xtudo.add("maionese");


            String retorno = "";

            switch (itensDoPedido[0]) {

                case "x-burguer":

                    for (int i = 0; i < itensDoPedido.length; i++) {

                        //se o item não existe adicona
                        if (!xburguer.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '+') {
                            xburguer.add(itensDoPedido[i].substring(1));
                        }

                        //se o item  existe remove
                        if (xburguer.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            xburguer.remove(itensDoPedido[i].substring(1));

                        //se o item não existe retorna invalido
                        } else if (!xburguer.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            invalido = true;
                        }
                    }

                    //retorna os itens se não tem nada invalido
                    if (invalido == false) {
                        xburguer.sort((o1, o2) -> o1.compareTo(o2));
                        for (String s : xburguer
                        ) { if (s == null) {} else { retorno += s + ",";}
                        } System.out.println(retorno.substring(0, retorno.length() - 1));

                    } else if(invalido == true) { //retorna invalido se qualquer teste de invalido alterou status de invalido para true
                        System.out.println("invalido");
                    }

                    break;

                case "x-salada":

                    for (int i = 0; i < itensDoPedido.length; i++) {

                        if (!xsalada.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '+') {
                            xsalada.add(itensDoPedido[i].substring(1));
                        }

                        if (xsalada.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            xsalada.remove(itensDoPedido[i].substring(1));
                        } else if (!xsalada.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            invalido = true;
                        }
                    }

                    if (invalido == false) {
                        xsalada.sort((o1, o2) -> o1.compareTo(o2));
                        for (String s : xsalada
                        ) { if (s == null) {} else { retorno += s + ",";}
                        } System.out.println(retorno.substring(0, retorno.length() - 1));

                    } else if(invalido == true) {
                        System.out.println("invalido");
                    }

                    break;

                case "x-bacon":

                    for (int i = 0; i < itensDoPedido.length; i++) {

                        if (!xbacon.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '+') {
                            xbacon.add(itensDoPedido[i].substring(1));
                        }

                        if (xbacon.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            xbacon.remove(itensDoPedido[i].substring(1));
                        } else if (!xbacon.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            invalido = true;
                        }
                    }

                    if (invalido == false) {
                        xbacon.sort((o1, o2) -> o1.compareTo(o2));
                        for (String s : xbacon
                        ) { if (s == null) {} else { retorno += s + ",";}
                        } System.out.println(retorno.substring(0, retorno.length() - 1));

                    } else if(invalido == true) {
                        System.out.println("invalido");
                    }

                    break;

                case "x-tudo":

                    for (int i = 0; i < itensDoPedido.length; i++) {

                        if (!xtudo.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '+') {
                            xtudo.add(itensDoPedido[i].substring(1));
                        }

                        if (xtudo.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            xtudo.remove(itensDoPedido[i].substring(1));
                        } else if (!xtudo.contains(itensDoPedido[i].substring(1)) && itensDoPedido[i].charAt(0) == '-') {
                            invalido = true;
                        }
                    }

                    if (invalido == false) {
                        xtudo.sort((o1, o2) -> o1.compareTo(o2));
                        for (String s : xtudo
                        ) { if (s == null) {} else { retorno += s + ",";}
                        } System.out.println(retorno.substring(0, retorno.length() - 1));

                    } else if(invalido == true) {
                        System.out.println("invalido");
                    }
                    break;

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
