<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $mail  = $_GET['mail'];
 $password = $_GET['password'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM user WHERE mail='".$mail."' AND password='".$password."' AND active=1";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 "mail"=>$res['mail'],
 "password"=>$res['password']
 )
 );
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($con);
 
 }