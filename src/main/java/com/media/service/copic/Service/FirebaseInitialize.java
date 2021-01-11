package com.media.service.copic.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.media.service.copic.Model.FirebaseCredential;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class FirebaseInitialize {


    Properties prop = new Properties();

    @PostConstruct
        public void initialize(){

        try {

//            FileInputStream serviceAccount =
//
//                    new FileInputStream(inputStream);

            InputStream inputStream = createFirebaseCredential();

            System.out.println(inputStream);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build();

            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    private InputStream createFirebaseCredential() throws Exception {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
            if (inputStream != null){
                prop.load(inputStream);
            }else {
                throw new FileNotFoundException("property file not found in the classpath");
            }


            FirebaseCredential firebaseCredential = new FirebaseCredential();
            //private key
            String privateKey = prop.getProperty("FIREBASE_PRIVATE_KEY").replace("\\n", "\n");


            firebaseCredential.setType(prop.getProperty("FIREBASE_TYPE"));
            firebaseCredential.setProject_id(prop.getProperty("FIREBASE_PROJECT_ID"));
            firebaseCredential.setPrivate_key_id(prop.getProperty("FIREBASE_PRIVATE_KEY_ID"));
            firebaseCredential.setPrivate_key(privateKey);
            firebaseCredential.setClient_email(prop.getProperty("FIREBASE_CLIENT_EMAIL"));
            firebaseCredential.setClient_id(prop.getProperty("FIREBASE_CLIENT_ID"));
            firebaseCredential.setAuth_uri(prop.getProperty("FIREBASE_AUTH_URI"));
            firebaseCredential.setToken_uri(prop.getProperty("FIREBASE_TOKEN_URI"));
            firebaseCredential.setAuth_provider_x509_cert_url(prop.getProperty("FIREBASE_AUTH_PROVIDER_X509_CERT_URL"));
            firebaseCredential.setClient_x509_cert_url(prop.getProperty("FIREBASE_CLIENT_X509_CERT_URL"));

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(firebaseCredential);

            InputStream input = new ByteArrayInputStream(jsonString.getBytes());

            return input;
    }
}
