<?php
require_once("../db/Connection.php");
class DisplayJsonFood{
    function getAllJsonFood(){
        $connection = new Connection();
        $conn = $connection->getConnection();

        $jsonFood = array();
        $status="status";
        $message = "message";

        try{
            $sqlQuery = "SELECT * FROM math";
            $getJson = $conn->prepare($sqlQuery);
            $getJson->execute();

            $result = $getJson->fetchAll(PDO::FETCH_ASSOC);

            foreach($result as $data){
                array_push($jsonFood,
                    array('name'=>$data['name'],
                        'details'=>$data['details']));
            }
        }catch (PDOException $e){
            echo "Error while displaying json : " . $e->getMessage();
        }

        if($sqlQuery){
            echo json_encode(array("math"=>$jsonFood,$status=>1,$message=>"Success"));
        }else{
            echo json_encode(array("math"=>null,$status=>0, $message=>"Failed while displaying data networking"));
        }
    }
}

$json = new DisplayJsonFood();
$json->getAllJsonFood();