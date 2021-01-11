package com.media.service.copic.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.media.service.copic.Model.FirebaseCredential;
import javassist.compiler.ast.Variable;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.conscrypt.io.IoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;

@Service
public class FirebaseService{





    public String deleteImg(String id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = dbFirestore.collection("images").document(id).delete();
        return "Image with id "+id+" has been deleted";
    }




}
