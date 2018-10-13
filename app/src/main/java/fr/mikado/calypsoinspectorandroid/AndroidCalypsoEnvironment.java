package fr.mikado.calypsoinspectorandroid;

import android.content.Context;
import org.jdom2.Document;

import java.io.IOException;

import calypso.CalypsoEnvironment;

public class AndroidCalypsoEnvironment extends CalypsoEnvironment {

    private final Context context;

    public AndroidCalypsoEnvironment(Context context){
        super();
        this.context = context;
        this.buildEnvironmentList();
    }

    @Override
    public Document loadDocument(String filename) {
        try {
            return new XMLIOImpl(context, XMLIOImpl.XMLIOType.AssetFile).loadDocument(filename);
        } catch (IOException e) {
            return null;
        }
    }

    public void purgeFilesContents() {
    }
}
