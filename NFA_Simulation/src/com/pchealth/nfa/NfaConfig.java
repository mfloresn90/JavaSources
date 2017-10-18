package com.pchealth.nfa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mfloresn90
 */
public class NfaConfig {

    private String absolutePath;
    private Integer cardQ;
    private Integer cardF;
    private Integer[] f;
    private Integer[] cardSn;
    private Integer[][] positionDeltaN;
    private List<Integer[]> deltaN;
    private List<Integer[]> transitionT;
    private List<Integer> preLclosure = new ArrayList<Integer>();

    public NfaConfig() {
    }

    public NfaConfig(String absolutePath) {
        this.absolutePath = absolutePath;
        readNfaData();
    }

    public Integer getCardQ() {
        return cardQ;
    }

    public Integer getCardF() {
        return cardF;
    }

    public Integer[] getF() {
        return f;
    }

    public List<Integer[]> getDeltaN() {
        return deltaN;
    }

    public Integer[] getCardSn() {
        return cardSn;
    }

    public Integer[][] getPositionDeltaN() {
        return positionDeltaN;
    }

    public List<Integer[]> getTransitionT() {
        return transitionT;
    }

    public void readNfaData() {
        int counter = 0;
        Integer[] tmp;
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
            for (String line; (line = br.readLine()) != null;) {
                if (counter == 0) {
                    cardQ = Integer.parseInt(line);
                } else if (counter == 1) {
                    cardF = Integer.valueOf(line);
                } else if (counter == 2) {
                    f = new Integer[cardF];
                    String[] infoF = line.split(", ");
                    for (int i = 0; i < infoF.length; i++) {
                        f[i] = Integer.valueOf(infoF[i]);
                    }
                } else if (counter == 3) {
                    String[] infoSa = line.split(", ");
                    cardSn = new Integer[infoSa.length];
                    for (int i = 0; i < infoSa.length; i++) {
                        cardSn[i] = Integer.valueOf(infoSa[i]);
                    }
                    positionDeltaN = new Integer[cardSn[0]][cardSn[1]];
                    int position = 0;
                    for (int x = 0; x < cardSn[0]; x++) {
                        for (int y = 0; y < cardSn[1]; y++) {
                            positionDeltaN[x][y] = position;
                            position++;
                        }
                    }
                } else if (counter == 4) {
                    deltaN = new ArrayList<Integer[]>();
                    transitionT = new ArrayList<Integer[]>();
                    String[] sa = line.split("\\|");

                    for (int i = 0; i < sa.length; i++) {
                        String con = sa[i];
                        String[] sap = con.split(", ");
                        tmp = new Integer[sap.length];
                        for (int j = 0; j < sap.length; j++) {
                            tmp[j] = Integer.valueOf(sap[j]);
                        }
                        deltaN.add(tmp);
                    }

                    for (int i = 0; i < sa.length; i += 3) {
                        String con = sa[i + 2];
                        String[] sap = con.split(", ");
                        tmp = new Integer[sap.length];
                        for (int j = 0; j < sap.length; j++) {
                            tmp[j] = Integer.valueOf(sap[j]);
                        }
                        transitionT.add(tmp);
                    }

                }
                counter++;
            }
        } catch (IOException e) {
            System.err.println("readLineByLine.IOException Message: " + e);
        }
    }

    public List<Integer[]> getLambdaClosure(int cardQ) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        Stack<Integer> lifo = new Stack<Integer>();
        Integer[] getInfo;
        for (int i = cardQ - 1; i >= 0; i--) {
            lifo.push(i);
        }
        while (!lifo.empty()) {
            preLclosure.clear();
            Integer value = lifo.pop();
            getPreLambdaClosure(value);
            getInfo = new Integer[preLclosure.size()];
            for (int i = 0; i < preLclosure.size(); i++) {
                getInfo[i] = preLclosure.get(i);
            }
            result.add(getInfo);
        }
        return result;
    }

    private void getPreLambdaClosure(Integer state) {
        preLclosure.add(state);
        Integer[] finded = transitionT.get(state);
        for (int i = 0; i < finded.length; i++) {
            if (finded[i] == state) {
            } else {
                getPreLambdaClosure(finded[i]);
            }
        }
    }

    public Integer[] move(Integer[] s, int c) {
        List<Integer> preResult = new ArrayList<Integer>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != deltaN.get(positionDeltaN[s[i]][c])[0]) {
                preResult.add(deltaN.get(positionDeltaN[s[i]][c])[0]);
            }
        }
        Integer[] result = new Integer[preResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = preResult.get(i);
        }
        return result;
    }

    public Integer[] lClosure(Integer[] move, List<Integer[]> lambdaClosure) {
        List<Integer> preResult = new ArrayList<Integer>();
        Integer[] preRes;
        Integer[] result;
        for (int i = 0; i < move.length; i++) {
            preRes = lambdaClosure.get(move[i]);
            for (int j = 0; j < preRes.length; j++) {
                preResult.add(preRes[j]);
            }
        }
        result = new Integer[preResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = preResult.get(i);
        }
        return result;
    }

    public void clsConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.err.println("clsConsole: Message = " + e.getMessage());
        }
    }

}
