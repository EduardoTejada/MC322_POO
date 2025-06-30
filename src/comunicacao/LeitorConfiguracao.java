package comunicacao;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import ambiente.Ambiente;
import obstaculo.Obstaculo;
import robo.Robo;


public class LeitorConfiguracao {
    static public void carregar(String filename, Ambiente a){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.startsWith("AMBIENTE")){
                    String[] ambData = data.trim().split(" ");
                    
                    int comprimento, largura, altura;

                    try {
                        comprimento = Integer.parseInt(ambData[1]);
                    }
                    catch (NumberFormatException e) {
                        comprimento = 0;
                    }

                    try {
                        largura = Integer.parseInt(ambData[2]);
                    }
                    catch (NumberFormatException e) {
                        largura = 0;
                    }

                    try {
                        altura = Integer.parseInt(ambData[3]);
                    }
                    catch (NumberFormatException e) {
                        altura = 0;
                    }

                    
                    a.setComprimento(comprimento);
                    a.setLargura(largura);
                    a.setAltura(altura);
                }
                else if(data.startsWith("ROBO")){
                    String[] roboData = data.trim().split(" ");
                    
                    int x, y;

                    try {
                        x = Integer.parseInt(roboData[3]);
                    }
                    catch (NumberFormatException e) {
                        x = 0;
                    }

                    try {
                        y = Integer.parseInt(roboData[4]);
                    }
                    catch (NumberFormatException e) {
                        y = 0;
                    }

                    Robo r = new Robo(roboData[3], roboData[2], x, y, a);
                    a.adicionarRobo(r);
                }
                else if(data.startsWith("OBSTACULO")){
                    String[] obsData = data.trim().split(" ");
                    
                    int posicaoX1, posicaoY1, altura, posicaoX2, posicaoY2;

                    try { posicaoX1 = Integer.parseInt(obsData[3]); }
                    catch (NumberFormatException e) { posicaoX1 = 0; }

                    try { posicaoY1 = Integer.parseInt(obsData[3]); }
                    catch (NumberFormatException e) { posicaoY1 = 0; }

                    try { altura = Integer.parseInt(obsData[3]); }
                    catch (NumberFormatException e) { altura = 0; }

                    try { posicaoX2 = Integer.parseInt(obsData[3]); }
                    catch (NumberFormatException e) { posicaoX2 = 0; }

                    try { posicaoY2 = Integer.parseInt(obsData[3]); }
                    catch (NumberFormatException e) { posicaoY2 = 0; }

                    Obstaculo o = new Obstaculo(posicaoX1, posicaoY1, altura, posicaoX2, posicaoY2);

                    a.adicionarObstaculo(o);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
