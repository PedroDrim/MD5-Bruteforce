/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desencriptarmd5Paralelo;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author alunoinf
 */
public class DesencriptarMD5 {

    public static void main(String args[]) throws NoSuchAlgorithmException {

        String key = "0123456789abcdefghijklmnopqrstuvwxyz";
        String[] md5Hash = new String[3];
        md5Hash[0] = "17a0a00212dde12b063af7dc22fdf02b";
        md5Hash[1] = "75abfe3020804dd73a2a6040da9df96c";
        md5Hash[2] = "c77aeec24015ad7e6e0b1db9d9deed68";

        DecodeMd5 md5 = new DecodeMd5();
        
        long inicio, fim;
        
        inicio = System.currentTimeMillis();
        md5.stringCombination(key, md5Hash[0]);
        fim = System.currentTimeMillis() - inicio;
        System.out.println("" + fim);
        
        inicio = System.currentTimeMillis();
        md5.stringCombination(key, md5Hash[1]);
        fim = System.currentTimeMillis() - inicio;
        System.out.println("" + fim);
        
        inicio = System.currentTimeMillis();
        md5.stringCombination(key, md5Hash[2]);
        fim = System.currentTimeMillis() - inicio;
        System.out.println("" + fim);
        
    }

}
