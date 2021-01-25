/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

import java.util.ArrayList;
import bank.model.BankTextReader;
import java.util.Hashtable;


public class BankTextController {
    
    
    public String[][] getTable(String Filename){
        int i,j;
        BankTextReader bankBuilder = new BankTextReader();
        ArrayList<String> input;
        input = bankBuilder.bankReader(Filename);
        String[][] output = new String[input.size()][4];
        String array;
        String accounts;
        String[] split;
        for(i=0;i<input.size();i++){
            array = input.get(i);
            split = array.split(",");
            accounts = split[3];
            for(j=6;j<split.length;j++){
                accounts = accounts + ", " + split[j];
                j = j + 2;
            }
            output[i][3] = accounts;
            for(j=0;j<3;j++){
                output[i][j] = split[j];
            }
        }
        return output;
    }

    
    //Recibe un hashTable y busca una key, si existe, regresa una tabla con
    //la informacion del resultado de la busqueda. Si no existe, regresa
    //un apuntador null
    public String[][] getHashTable(String key) {
        BankTextReader bankBuilder = new BankTextReader();
        Hashtable<String, String> input = bankBuilder.bankHashReader("Bank.txt");
        String[][] output = new String[3][5];
        if (input.containsKey(key)) {
            String line = input.get(key);;
            String[] split = line.split(",");
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    output[i][k] = split[k];
                }
            }
            output[0][3] = split[5];
            output[0][4] = split[4];
            output[1][3] = split[8];
            output[1][4] = split[7];
            output[2][3] = split[11];
            output[2][4] = split[10];
        }
        // Si el elemento no existe, se devuelve null
        else {
            output = null;
        }
        return output;
    }

}
