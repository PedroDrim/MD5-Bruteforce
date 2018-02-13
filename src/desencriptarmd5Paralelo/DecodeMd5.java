/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desencriptarmd5Paralelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author alunoinf
 */
public class DecodeMd5 {

    public String decode(String senha) throws NoSuchAlgorithmException {

        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        senha = hash.toString(16);

        return (senha);
    }

    public String stringCombination(String key, String md5Hash) throws NoSuchAlgorithmException {

        //String key = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        permutationArrange(key, md5Hash);
        return null;

    }

    private void permutationArrange(String key, String md5Hash) throws NoSuchAlgorithmException {

        String[] builder = new String[5];
        String resultado, resultadoHash;

        int contador = 0;
        for (int a = 0; a < key.length(); a++) {
            builder[0] = (key.substring(a, a + 1));
            for (int b = 0; b < key.length(); b++) {
                builder[1] = (key.substring(b, b + 1));
                for (int c = 0; c < key.length(); c++) {
                    builder[2] = (key.substring(c, c + 1));
                    for (int d = 0; d < key.length(); d++) {
                        builder[3] = (key.substring(d, d + 1));
                        for (int e = 0; e < key.length(); e++) {
                            builder[4] = (key.substring(e, e + 1));

                            resultado = (builder[0] + builder[1] + builder[2] + builder[3] + builder[4]);
                            resultadoHash = decode(resultado);
                            if (resultadoHash.equals(md5Hash)) {
                                System.out.println("A senha para o Hash '" + md5Hash + "' e: " + resultado);
                                return;
                            }

                        }
                    }
                }

            }
        }
        
        System.out.println("Nao foi encontrado combinacoes para a quebra do hash: " + md5Hash);
    }
}
