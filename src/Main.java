/**
 * esse import vai ser util para analizar arquivos musicais e fazer grafico
 *
 * site bom para ver como pegar os dados das musicas:
 * https://docs.oracle.com/javase/tutorial/sound/index.html
 */

import java.io.FileInputStream;
//import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.InputStream;
//import javax.sound.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hello World!");
        Som oi = new Som();
        InputStream inputstream;
        //inputstream = new FileInputStream("Volumes/HD_EXTERNO/paradas_de_algoritmo/quinto_semestre/genres/rock/rock.00000.au");
        inputstream = new FileInputStream("rock.00000.au");


        oi.tocar(inputstream,true);
    }
}
