<?php

class Connection{
    function getConnection(){
        $host       = "localhost";
        $username   = "id3824311_root";
        $password   = "mahbub0950";
        $dbname     = "id3824311_amarnotekhata";

        try{
            $conn    = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $conn;
        }catch (PDOException $e){
            echo "ERROR CONNECTIONF : " . $e->getMessage();
        }
    }
}