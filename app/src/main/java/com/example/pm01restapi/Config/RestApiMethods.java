package com.example.pm01restapi.Config;

public class RestApiMethods
{
    //http://localhost/PM01/CreatePerson.php

    public static final String separador = "/";
    public static final String ipadress = "192.168.0.4";
    public static final String RestApi = "PM01";
    public static final String PostRouting = "CreatePerson.php";
    public static final String GetRouting = "ListPerson.php";

    // Endpoint
    public static final String  EndpointPost = "http://"  + ipadress + separador + RestApi + separador + PostRouting;
    public static final String  EndpointGet = "http://"  + ipadress + separador + RestApi + separador + GetRouting;



}
