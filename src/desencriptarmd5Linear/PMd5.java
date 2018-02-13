/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desencriptarmd5Linear;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public class PMd5 extends Thread {

    private String[] hash;
    private List<String> listaString;

    public PMd5(String hash[], List<String> listaString) {
        this.hash = hash;
        this.listaString = listaString;
    }

    public String decode(String senha) throws NoSuchAlgorithmException {

        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        senha = hash.toString(16);

        return (senha);
    }

    @Override
    public void run() {

        for (String md5key : listaString) {

            try {

                for (String hashS : hash) {
                    if (decode(md5key).equals(hashS)) {
                        System.out.println("A senha para o Hash '" + hashS + "' e: " + md5key);
                    }
                }

            } catch (NoSuchAlgorithmException ex) {
            }
        }
    }

}
