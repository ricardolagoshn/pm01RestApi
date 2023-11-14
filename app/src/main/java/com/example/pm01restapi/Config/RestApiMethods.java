package com.example.pm01restapi.Config;

public class RestApiMethods
{
    //http://localhost/PM01/CreatePerson.php

    public static final String separador = "/";
    public static final String ipadress = "192.168.164.166";
    public static final String RestApi = "PM01";
    public static final String PostRouting = "CreatePerson.php";

    // Endpoint
    public static final String  EndpointPost = "http://"  + ipadress + separador + RestApi + separador + PostRouting;



}
