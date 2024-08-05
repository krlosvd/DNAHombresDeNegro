package org.prueba.tecnica.dnahombresdenegro.service.impl;
import org.prueba.tecnica.dnahombresdenegro.service.MenInblackService;
import org.springframework.stereotype.Component;

@Component
public class MenInblackImpl implements MenInblackService {


    @Override
    public boolean isAlien(String[] dna) {
        int n = dna.length;
        int conteoSecuencia = 0;
        int tamañoSecuencia = 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j + tamañoSecuencia - 1 < n && tieneSecuencia(dna, i, j, 0, 1, tamañoSecuencia)) {
                    conteoSecuencia++;
                }

                if (i + tamañoSecuencia - 1 < n && tieneSecuencia(dna, i, j, 1, 0, tamañoSecuencia)) {
                    conteoSecuencia++;
                }

                if (i + tamañoSecuencia - 1 < n && j + tamañoSecuencia - 1 < n && tieneSecuencia(dna, i, j, 1, 1, tamañoSecuencia)) {
                    conteoSecuencia++;
                }

                if (i + tamañoSecuencia - 1 < n && j - tamañoSecuencia + 1 >= 0 && tieneSecuencia(dna, i, j, 1, -1, tamañoSecuencia)) {
                    conteoSecuencia++;
                }

                if (conteoSecuencia > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean tieneSecuencia(String[] dna, int x, int y, int dx, int dy, int length) {
        char firstChar = dna[x].charAt(y);
        for (int i = 1; i < length; i++) {
            if (dna[x + i * dx].charAt(y + i * dy) != firstChar) {
                return false;
            }
        }
        return true;
    }

}
