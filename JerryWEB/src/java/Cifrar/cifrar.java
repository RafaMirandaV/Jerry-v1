package Cifrar;
/**
 *
 * @author Rafa
 */
public class cifrar {
    String alfabeto[] = new String[63];
    
    public String cifrar(String cadena){
        String Cifrado = "";
        alfabeto[0] = "A";
        alfabeto[1] = "B";
        alfabeto[2] = "C";
        alfabeto[3] = "D";
        alfabeto[4] = "E";
        alfabeto[5] = "F";
        alfabeto[6] = "G";
        alfabeto[7] = "H";
        alfabeto[8] = "I";
        alfabeto[9] = "J";
        alfabeto[10] = "K";
        alfabeto[11] = "L";
        alfabeto[12] = "M";
        alfabeto[13] = "N";
        alfabeto[14] = "O";
        alfabeto[15] = "P";
        alfabeto[16] = "Q";
        alfabeto[17] = "R";
        alfabeto[18] = "S";
        alfabeto[19] = "T";
        alfabeto[20] = "U";
        alfabeto[21] = "V";
        alfabeto[22] = "W";
        alfabeto[23] = "X";
        alfabeto[24] = "Y";
        alfabeto[25] = "Z";
        alfabeto[26] = " ";
        alfabeto[27] = "a";
        alfabeto[28] = "b";
        alfabeto[29] = "c";
        alfabeto[30] = "d";
        alfabeto[31] = "e";
        alfabeto[32] = "f";
        alfabeto[33] = "g";
        alfabeto[34] = "h";
        alfabeto[35] = "i";
        alfabeto[36] = "j";
        alfabeto[37] = "K";
        alfabeto[38] = "l";
        alfabeto[39] = "m";
        alfabeto[40] = "n";
        alfabeto[41] = "o";
        alfabeto[42] = "p";
        alfabeto[43] = "q";
        alfabeto[44] = "r";
        alfabeto[45] = "s";
        alfabeto[46] = "t";
        alfabeto[47] = "u";
        alfabeto[48] = "v";
        alfabeto[49] = "w";
        alfabeto[50] = "x";
        alfabeto[51] = "y";
        alfabeto[52] = "z";
        alfabeto[53] = "0";
        alfabeto[54] = "1";
        alfabeto[55] = "2";
        alfabeto[56] = "3";
        alfabeto[57] = "4";
        alfabeto[58] = "5";
        alfabeto[59] = "6";
        alfabeto[60] = "7";
        alfabeto[61] = "8";
        alfabeto[62] = "9";

        int iterar;
        for(int i = 0; i < cadena.length(); i++){
            int clave = 0;
            for( iterar = 0; iterar < 63; iterar++){
                if(alfabeto[iterar].equals(Character.toString(cadena.charAt(i)))){
                    clave = 62 - iterar;
                    Cifrado += alfabeto[clave].charAt(0);
                    break;
                }
            }
            if(iterar == 63){
                Cifrado += Character.toString(cadena.charAt(i));
            }
            iterar = 0;
        }
        return Cifrado;
    }
    
    public String d_cifar(String cadena){
        alfabeto[62] = "A";
        alfabeto[61] = "B";
        alfabeto[60] = "C";
        alfabeto[59] = "D";
        alfabeto[58] = "E";
        alfabeto[57] = "F";
        alfabeto[56] = "G";
        alfabeto[55] = "H";
        alfabeto[54] = "I";
        alfabeto[53] = "J";
        alfabeto[52] = "K";
        alfabeto[51] = "L";
        alfabeto[50] = "M";
        alfabeto[49] = "N";
        alfabeto[48] = "O";
        alfabeto[47] = "P";
        alfabeto[46] = "Q";
        alfabeto[45] = "R";
        alfabeto[44] = "S";
        alfabeto[43] = "T";
        alfabeto[42] = "U";
        alfabeto[41] = "V";
        alfabeto[40] = "W";
        alfabeto[39] = "X";
        alfabeto[38] = "Y";
        alfabeto[37] = "Z";
        alfabeto[36] = " ";
        alfabeto[35] = "a";
        alfabeto[34] = "b";
        alfabeto[33] = "c";
        alfabeto[32] = "d";
        alfabeto[31] = "e";
        alfabeto[30] = "f";
        alfabeto[29] = "g";
        alfabeto[28] = "h";
        alfabeto[27] = "i";
        alfabeto[26] = "j";
        alfabeto[25] = "K";
        alfabeto[24] = "l";
        alfabeto[23] = "m";
        alfabeto[22] = "n";
        alfabeto[21] = "o";
        alfabeto[20] = "p";
        alfabeto[19] = "q";
        alfabeto[18] = "r";
        alfabeto[17] = "s";
        alfabeto[16] = "t";
        alfabeto[15] = "u";
        alfabeto[14] = "v";
        alfabeto[13] = "w";
        alfabeto[12] = "x";
        alfabeto[11] = "y";
        alfabeto[10] = "z";
        alfabeto[9] = "0";
        alfabeto[8] = "1";
        alfabeto[7] = "2";
        alfabeto[6] = "3";
        alfabeto[5] = "4";
        alfabeto[4] = "5";
        alfabeto[3] = "6";
        alfabeto[2] = "7";
        alfabeto[1] = "8";
        alfabeto[0] = "9";
        
        String D_cifrado = "";
        int iterar;
        for(int i = 0; i < cadena.length(); i++){
            int clave = 0;
            for( iterar = 0; iterar < 63; iterar++){
                if(alfabeto[iterar].equals(Character.toString(cadena.charAt(i)))){
                    clave = 62 - iterar;
                    D_cifrado += alfabeto[clave].charAt(0);
                    break;
                }
            }
            if(iterar == 63){
                D_cifrado += Character.toString(cadena.charAt(i));
            }
            iterar = 0;
        }
        
        return D_cifrado;
    }
    
}
