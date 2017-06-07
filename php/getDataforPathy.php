<?php
define('HOST','localhost');
define('USER','root');
define('PASS','*****');
define('DB','pathy');
 
$con = mysqli_connect(HOST,USER,PASS,DB);
 
$sql = "select * from user inner join reservations on user.uid=reservations.uid where reservations.price=0";
 
$res = mysqli_query($con,$sql);

if (!$res) {
    printf("Error: %s\n", mysqli_error($con));
    exit();
}
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array(
'mail'=>$row[2],
'from'=>$row[8],
'to'=>$row[9],
'date'=>$row[10],
'price'=>$row[11],
'time'=>$row[12],
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>