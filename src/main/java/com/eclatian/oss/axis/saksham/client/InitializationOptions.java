/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client;

import java.io.InputStream;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Abhideep
 */
@Getter
@Setter
public class InitializationOptions {
   private SakshamEnv env;
   private String corpCode;
   private String channelId;
   private String clientId;
   private String clientSecret;
   private String key;
   private InputStream certFileStream;
   private String certPassPhrase;
   private boolean autoPopulateSubHeader;
   private boolean hideRequestRawJson;
   

   private InitializationOptions(Builder builder) {
       this.env = builder.env;
       this.corpCode = builder.corpCode;
       this.channelId = builder.channelId;
       this.clientId = builder.clientId;
       this.clientSecret = builder.clientSecret;
       this.key = builder.key;
       this.certFileStream = builder.certFileStream;
       this.autoPopulateSubHeader = builder.autoPopulateSubHeader;
       this.hideRequestRawJson = builder.hideRequestRawJson;
       this.certPassPhrase = builder.certPassPhrase;
       
   }

   public static class Builder {
       private SakshamEnv env;
       private String corpCode;
       private String channelId;
       private String clientId;
       private String clientSecret;
       private String key;
       private String certPassPhrase;
       private InputStream certFileStream;
       private boolean autoPopulateSubHeader = true;
       private boolean hideRequestRawJson = true;
       

       public Builder env(SakshamEnv env) {
           this.env = env;
           return this;
       }

       public Builder corpCode(String corpCode) {
           this.corpCode = corpCode;
           return this;
       }

       public Builder channelId(String channelId) {
           this.channelId = channelId;
           return this;
       }

       public Builder clientId(String clientId) {
           this.clientId = clientId;
           return this;
       }

       public Builder clientSecret(String clientSecret) {
           this.clientSecret = clientSecret;
           return this;
       }

       public Builder key(String key) {
           this.key = key;
           return this;
       }

       public Builder certPassPhrase(String passPhrase) {
           this.certPassPhrase = passPhrase;
           return this;
       }

       public Builder certFileStream(InputStream certFileStream) {
           this.certFileStream = certFileStream;
           return this;
       }

       public Builder autoPopulateSubHeader(boolean autoPopulateSubHeader) {
           this.autoPopulateSubHeader = autoPopulateSubHeader;
           return this;
       }

      public Builder hideRequestRawJson(boolean hideRequestRawJson) {
           this.hideRequestRawJson = hideRequestRawJson;
           return this;
       }

       public InitializationOptions build() {
           return new InitializationOptions(this);
       }
   }
}

