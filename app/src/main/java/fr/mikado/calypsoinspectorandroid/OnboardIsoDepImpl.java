package fr.mikado.calypsoinspectorandroid;

import android.nfc.tech.IsoDep;

import java.io.IOException;

import isodep.CardException;
import isodep.CommandAPDU;
import isodep.IsoDepInterface;
import isodep.ResponseAPDU;

/**
 * Created by alexis on 05/04/17.
 */
public class OnboardIsoDepImpl implements IsoDepInterface {

    private IsoDep iso;

    public OnboardIsoDepImpl(IsoDep iso) {
        this.iso = iso;
    }

    @Override
    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardException {
        byte[] r;
        try {
            r = iso.transceive(commandAPDU.getBytes());
        } catch (IOException e) {
            throw new CardException(e.getMessage());
        }
        return new ResponseAPDU(r);
    }

    @Override
    public byte[] getATR() {
        return iso.getHistoricalBytes();
    }

    @Override
    public void disconnect() throws CardException {
        try {
            iso.close();
        } catch (IOException e) {
            throw new CardException(e.getMessage());
        }
    }
}
































